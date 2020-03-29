# STOCKS APPLICATION

Stocks Application to get info about specific stocks. Services will be built out over time

## List Of Services
  - Angular9 frontend (Node and NPM needed)
  - Java api-gateway (uses Java 11)
  - Go stocks service (Go 1.14)
  
 ## How To Use
  - Clone Repo
  - Install Docker & docker-compose
  - Install protoc for protobufs (Using GRPC from API-Gateway to services)
  - from / run `./app.sh build` (Will build new JAR file for API-Gateway and build new docker containers)
    - If ran without build parameter docker containers will not be recreated (i.e. `./app.sh`) 
     - When done, run `./app.sh down` this will terminate docker network and containers
