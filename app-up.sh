# go to java app
cd api-gateway

# build new jar file from gradle wrapper
./gradlew clean build

# Setup docker-compose
if [ $1 = "build" ]; then
    echo "building new docker containers"
    docker-compose up --build
else
    docker-compose up
fi