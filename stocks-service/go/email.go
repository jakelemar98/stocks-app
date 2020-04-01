package main

import (
	"context"
	"log"
	"time"

	pb "../proto/email"
	"google.golang.org/grpc"
)

const (
	address = "email-service:5001"
)

func email() {
	log.Printf("emailing")
	// Set up a connection to the server.
	conn, err := grpc.Dial(address, grpc.WithInsecure(), grpc.WithBlock())
	if err != nil {
		log.Fatalf("did not connect: %v", err)
	}
	defer conn.Close()
	c := pb.NewEmailServiceClient(conn)

	// Contact the server and print out its response.
	ctx, cancel := context.WithTimeout(context.Background(), time.Second)
	defer cancel()
	em := &pb.Email{
		[]string{"jakelemar@gmail.com", "jake2@gmail.com"},
		"Jake@gmail.com",
		"nothing",
		"this isnt workign weel"}

	r, err := c.SendMail(ctx, &pb.EmailRequest{Email: em})
	if err != nil {
		log.Fatalf("could not send: %v", err)
	}
	log.Printf("Email: %s", r.GetReply())
}
