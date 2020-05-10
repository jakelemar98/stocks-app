package main

import (
	"encoding/json"
	"io/ioutil"
	"log"
	"net/http"
)

type CryptoQuote struct {
	Crypto map[string]string `json:"Realtime Currency Exchange Rate"`
}

func cryptoPriceFetch(symbol string) string {
	log.Println("cryptoPrice request.....")
	var returnVal string
	url := apiBase + "CURRENCY_EXCHANGE_RATE&from_currency=" + symbol + "&to_currency=USD&apikey=" + randAPIKey()
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
