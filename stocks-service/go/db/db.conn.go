package db

import (
	"context"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
	"log"
	"time"
)

// GetDBConn gets db conn for mongo stocks db
func GetDBConn() (*mongo.Database, context.Context) {

	// Set client options
	clientOptions := options.Client().ApplyURI("mongodb+srv://stock-service:tTubGkePzhAxNYZa@stocks-cluster-ciiim.gcp.mongodb.net/test?retryWrites=true&w=majority")

	// Connect to MongoDB
	client, err := mongo.Connect(context.TODO(), clientOptions)

	if err != nil {
		log.Fatal(err)
	}

	// Check the connection
	err = client.Ping(context.TODO(), nil)

	if err != nil {
		log.Fatal(err)
	}
	ctx, _ := context.WithTimeout(context.Background(), 10*time.Second)
	err = client.Connect(ctx)
	if err != nil {
		log.Fatal(err)
	}
	defer client.Disconnect(ctx)
	database := client.Database("stocks-database")

	return database, ctx
}
