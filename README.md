# STOCKS APPLICATION

Stocks Application to get info about specific stocks. Services will be built out over time

### List Of Services
  - Angular9 frontend (Node and NPM needed)
  - Java api-gateway (uses Java 11)
  - Redis Data Store (Caches frequently made requests)
  - Go stocks service (Go 1.14)
  - Python users service (Python 3.6)
  
 ### How To Use
  - Clone Repo
  - Install Docker & docker-compose
  - Install protoc for protobufs (Using gRPC from API-Gateway to services)
  - from / run `./app.sh build` (Will build new JAR file for API-Gateway and build new docker containers)
    - If ran without build parameter docker containers will not be recreated (i.e. `./app.sh`) 
     - When done, run `./app.sh down` this will terminate docker network and containers

### Helpful Hints
  - protoc compiler commands
    - Java
      - proto files are compiled when the gradle wrapper runs a build (i.e. `./gradlew clean build` from api-gateway/)
    - Go
      - `protoc  stocks.proto --go_out=plugins=grpc:.` (run this command from stocks-service/proto directory)
    - Docker
      - Build & Run Angular Frontend container
        - `cd stocks-app && docker build -t angular-app . && docker run -p 4200:4200 -it angular-app`
      - Build & Run Java API Gateway
        - `cd api-gateway && docker build -t api-gateway . && docker run -p 8080:8080 -it api-gateway`
      - Build & Run Redis Data Store for API Gateway
        - `Docker pull redis && docker run -p 6379:6379 --name redis-container redis`
      - Build & Run Go Stocks Service
        - `cd stocks-service && docker build -t stocks-service . && docker run -p 8000:8000 -it stocks-service`
      - Build & Run Python Users Service
        - `cd users-service && docker build -t users-service . && docker run -p 8001:8001 -it users-service`
