FROM eclipse-temurin:17-jre

COPY build/libs/disease-service-1.0-SNAPSHOT.jar app.jar
EXPOSE 8084

ENTRYPOINT ["java", "-jar", "app.jar"]