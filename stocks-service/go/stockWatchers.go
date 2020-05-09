package main

import (
	db "./db"
	"context"
	"encoding/json"
	"fmt"
	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/bson/primitive"
	"go.mongodb.org/mongo-driver/mongo"
	"log"
)

var (
	conn       = db.GetDBConn()
	database   = conn.Database("stock-database")
	collection = database.Collection("watching")
)

type Watching struct {
	ID     primitive.ObjectID `json:"id" bson:"_id"`
	User   string             `json:"user" bson:"user"`
	Stocks []string           `json:"stocks" bson:"stocks"`
}

func addWatch(symbol string, id string) string {

	log.Print("Add Watching Request")
	count, err := collection.CountDocuments(context.TODO(), bson.M{"user": id})
	if err != nil {
		log.Fatal(err)
	}

	if count != 1 {
		_, err := collection.InsertOne(context.TODO(), bson.D{
			{Key: "user", Value: id},
			{Key: "stocks", Value: bson.A{symbol}},
		})
		if err != nil {
			log.Fatal(err)
		}
		return "inserted"
	}

	result, err := collection.UpdateOne(
		context.TODO(),
		bson.M{"user": id},
		bson.D{
			{"$push", bson.M{"stocks": symbol}},
		},
	)
	if err != nil {
		log.Fatal(err)
	}
	res := fmt.Sprintf("document %v Updated", result.UpsertedID)
	return res

}

func getWatching(id string) string {

	log.Print("Get Watchers Request")
	var result Watching
	err := collection.FindOne(context.TODO(), bson.M{"user": id}).Decode(&result)
	if err != nil {
		if err == mongo.ErrNoDocuments {
			return "No documents exist with that ID"
		}
		log.Fatal(err)
	}

	m := make(map[int]string)

	for index, val := range result.Stocks {
		res := stockPriceFetch(val)
		m[index] = res
	}

	json, _ := json.Marshal(m)

	return string(json)
}

//
