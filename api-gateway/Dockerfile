FROM eclipse-temurin:17-jre

COPY build/libs/api-gateway-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8085

ENTRYPOINT ["java", "-jar", "app.jar"]