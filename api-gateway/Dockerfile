FROM openjdk:11-jdk-slim
ARG $GITPATH
COPY ${GITPATH}/gateway/*.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ] 