FROM openjdk:11-jdk-slim
RUN ls -la $GITHUB_WORKSPACE/gateway
COPY $GITHUB_WORKSPACE/gateway/*.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ] 