FROM openjdk:11-jdk-slim
COPY $GITHUB_WORKSPACE/gateway/*.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ] 