package main

import (
	"encoding/json"
	"log"
	"net/http"
	"sort"
	"strings"
)

type TimeSeriesMonthly struct {
	Monthly map[string]Item `json:"Monthly Time Series"`
}

type TimeSeriesWeekly struct {
	Weekly map[string]Item `json:"Weekly Time Series"`
}

type TimeSeriesDaily struct {
	Daily map[string]Item `json:"Time Series (Daily)"`
}

type Item struct {
	Close  string `json:"4. close"`
	High   string `json:"2. high"`
	Low    string `json:"3. low"`
	Open   string `json:"1. open"`
	Volume string `json:"5. volume"`
	Date   string
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

	response := apiFetch("TIME_SERIES_" + strings.ToUpper(time) + "&symbol=" + symbol + "&outputsize=compact&apikey=" + randAPIKey())

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
		if i >= (length - 13) {
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
