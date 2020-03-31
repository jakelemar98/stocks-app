# Setup docker-compose
if [ $1 = "build" ]; then
    # go to java app
    cd api-gateway

    # build new jar file from gradle wrapper
    ./gradlew clean build

    echo "building new docker containers"
    docker-compose up --build

elif [ $1 = "down" ]; then
    docker-compose down
else
    docker-compose up
fi