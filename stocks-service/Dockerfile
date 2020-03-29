FROM golang:1.14

RUN mkdir -p /app

WORKDIR /app

ADD . /app

RUN go get github.com/golang/protobuf/proto
RUN go get golang.org/x/net/context
RUN go get google.golang.org/grpc

RUN go build main.go

ENTRYPOINT ["./main"]


