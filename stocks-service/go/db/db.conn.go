package db

import (
	"context"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
	"log"
)

// GetDBConn gets db conn for mongo stocks db
func GetDBConn() *mongo.Client {

	// Set client options
	clientOptions := options.Client().ApplyURI(
		"mongodb://stock-service:tTubGkePzhAxNYZa@stocks-cluster-shard-00-00-ciiim.gcp.mongodb.net:27017,stocks-cluster-shard-00-01-ciiim.gcp.mongodb.net:27017,stocks-cluster-shard-00-02-ciiim.gcp.mongodb.net:27017/test?ssl=true&replicaSet=stocks-cluster-shard-0&authSource=admin&retryWrites=true&w=majority",
	)

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

	return client
}
