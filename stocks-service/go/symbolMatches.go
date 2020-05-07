package main

import (
	"encoding/json"
	"io/ioutil"
	"log"
	"net/http"
)

type BestMatches struct {
	Matches []map[string]string `json:"BestMatches"`
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
