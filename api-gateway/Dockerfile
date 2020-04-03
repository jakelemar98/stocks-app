FROM openjdk:11-jdk-slim
ARG $GITPATH
RUN ls -la ${GITPATH}/gateway

COPY ${GITPATH}/gateway/*.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ] 