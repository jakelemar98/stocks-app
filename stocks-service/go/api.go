package main

import (
	"encoding/json"
	"io/ioutil"
	"log"
	"net/http"
	"sort"
	"strings"
)

var (
	apiBase = "https://www.alphavantage.co/query?function="
	apiKey  = "N8ECE7S8XE8QTU03"
)

type Item struct {
	Close  string `json:"4. close"`
	High   string `json:"2. high"`
	Low    string `json:"3. low"`
	Open   string `json:"1. open"`
	Volume string `json:"5. volume"`
	Date   string
}

type TimeSeriesMonthly struct {
	Monthly map[string]Item `json:"Monthly Time Series"`
}

type TimeSeriesWeekly struct {
	Weekly map[string]Item `json:"Weekly Time Series"`
}

type TimeSeriesDaily struct {
	Daily map[string]Item `json:"Time Series (Daily)"`
}

type GlobalQuote struct {
	Stock map[string]string `json:"Global Quote"`
}

type CryptoQuote struct {
	Crypto map[string]string `json:"Crypto Quote"`
}

type BestMatches struct {
	Matches []map[string]string `json:"BestMatches"`
}

func stockPriceFetch(symbol string) string {
	log.Println("stockPrice request.....")
	var returnVal string
	url := apiBase + "GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + apiKey
	response, err := http.Get(url)
	if err != nil {
		log.Fatalf("server error -> %s\n", err)
	} else {
		defer response.Body.Close()
		data, _ := ioutil.ReadAll(response.Body)
		var gq GlobalQuote
		err = json.Unmarshal(data, &gq)
		if err != nil {
			log.Fatal(err)
		}

		valueMap := map[string]int{"01. symbol": 0, "02. open": 1,
			"03. high": 2, "04. low": 3, "05. price": 4, "06. volume": 5,
			"07. latest trading day": 6, "08. previous close": 7,
			"09. change": 8, "10. change percent": 9}

		m := make(map[int]string)
		for k, v := range gq.Stock {
			m[valueMap[k]] = v
		}

		jsonString, _ := json.Marshal(m)
		returnVal = string(jsonString)
	}
	return returnVal
}

func cryptoPriceFetch(symbol string) string {
	log.Println("cryptoPrice request.....")
	var returnVal string
	url := apiBase + "CURRENCY_EXCHANGE_RATE&from_currency=" + symbol + "&to_currency=USD&apikey=" + apiKey
	response, err := http.Get(url)
	if err != nil {
		log.Fatalf("server error -> %s\n", err)
	} else {
		defer response.Body.Close()
		data, _ := ioutil.ReadAll(response.Body)
		var gq CryptoQuote
		err = json.Unmarshal(data, &gq)
		if err != nil {
			log.Fatal(err)
		}

		valueMap := map[string]int{"1. From_Currency Code": 0, "2. From_Currency Name": 1,
			"3. To_Currency Code": 2, "4. To_Currency Name": 3, "5. Exchange Rate": 4, "6. Last Refreshed": 5,
			"7. Time Zone": 6, "8. Bid Price": 7,
			"9. Ask Price": 8}

		m := make(map[int]string)
		for k, v := range gq.Crypto {
			m[valueMap[k]] = v
		}

		jsonString, _ := json.Marshal(m)
		returnVal = string(jsonString)
	}
	return returnVal
}

func stockOptionsFetch(symbol string) string {
	log.Println("stockOptions request.....")
	var returnVal string
	url := apiBase + "SYMBOL_SEARCH&keywords=" + symbol + "&apikey=" + apiKey
	response, err := http.Get(url)
	if err != nil {
		log.Fatalf("server error -> %s\n", err)
	} else {
		defer response.Body.Close()
		data, _ := ioutil.ReadAll(response.Body)
		var bm BestMatches
		err = json.Unmarshal(data, &bm)
		if err != nil {
			log.Fatal(err)
		}
		om := make(map[int]map[string]string)
		var i int = 0
		for k := range bm.Matches {
			m := make(map[string]string)
			for k2, v2 := range bm.Matches[k] {
				if k2 == "1. symbol" {
					m["symbol"] = v2
				}
				if k2 == "2. name" {
					m["name"] = v2
				}
			}
			om[i] = m
			i++
		}
		jsonString, _ := json.Marshal(om)
		returnVal = string(jsonString)
	}
	return returnVal
}

func apiFetch(path string) *http.Response {
	url := apiBase + path
	response, err := http.Get(url)
	if err != nil {
		log.Fatalf("server error -> %s\n", err)
	}
	return response
}

func timeSeriesFetch(symbol string, time string) string {
	log.Println(time + " price request.....")

	var returnVal string

	response := apiFetch("TIME_SERIES_" + strings.ToUpper(time) + "&symbol=" + symbol + "&outputsize=compact&apikey=" + apiKey)

	switch time {
	case "monthly":
		returnVal = monthLogic(response)
	case "weekly":
		returnVal = weekLogic(response)
	case "daily":
		returnVal = dayLogic(response)
	}

	return returnVal
}

func monthLogic(response *http.Response) string {
	var results TimeSeriesMonthly
	json.NewDecoder(response.Body).Decode(&results)

	length := len(results.Monthly)
	keys := make([]string, 0)

	for k := range results.Monthly {
		keys = append(keys, k)
	}

	sort.Strings(keys)

	m := make(map[int]Item)
	i := 0
	for _, k := range keys {
		if i >= (length - 12) {
			r := results.Monthly[k]
			r.Date = k
			results.Monthly[k] = r
			key := length - i - 1
			m[key] = results.Monthly[k]
		}
		i++
	}
	jsonString, _ := json.Marshal(m)
	return string(jsonString)
}

func weekLogic(response *http.Response) string {
	var results TimeSeriesWeekly
	json.NewDecoder(response.Body).Decode(&results)

	length := len(results.Weekly)
	keys := make([]string, 0)

	for k := range results.Weekly {
		keys = append(keys, k)
	}

	sort.Strings(keys)

	m := make(map[int]Item)
	i := 0
	for _, k := range keys {
		if i >= (length - 15) {
			r := results.Weekly[k]
			r.Date = k
			results.Weekly[k] = r
			key := length - i - 1
			m[key] = results.Weekly[k]
		}
		i++
	}
	jsonString, _ := json.Marshal(m)
	return string(jsonString)
}

func dayLogic(response *http.Response) string {
	var results TimeSeriesDaily
	json.NewDecoder(response.Body).Decode(&results)

	length := len(results.Daily)
	keys := make([]string, 0)

	for k := range results.Daily {
		keys = append(keys, k)
	}

	sort.Strings(keys)

	m := make(map[int]Item)
	i := 0
	for _, k := range keys {
		if i >= (length - 30) {
			r := results.Daily[k]
			r.Date = k
			results.Daily[k] = r
			key := length - i - 1
			m[key] = results.Daily[k]
		}
		i++
	}
	jsonString, _ := json.Marshal(m)
	return string(jsonString)
}
