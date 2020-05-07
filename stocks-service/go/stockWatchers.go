package main

import (
	db "./db"
	"go.mongodb.org/mongo-driver/bson"
	"log"
)

func addWatch(symbol string, id string) string {

	conn, ctx := db.GetDBConn()

	collection := conn.Collection("watching")

	watchingResult, err := collection.InsertOne(ctx, bson.D{
		{Key: "user", Value: id},
		{Key: "watching", Value: symbol},
	})
	if err != nil {
		log.Fatal(err)
	}
	log.Print(watchingResult)
	return "inserted"
}
