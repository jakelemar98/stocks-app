package main

import (
	"encoding/json"
	"io/ioutil"
	"log"
	"net/http"
)

type GlobalQuote struct {
	Stock map[string]string `json:"Global Quote"`
}

func stockPriceFetch(symbol string) string {
	log.Println("stockPrice request.....")
	var returnVal string
	url := apiBase + "GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + randAPIKey()
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
