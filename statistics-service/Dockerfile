FROM eclipse-temurin:17-jre

COPY build/libs/statistics-service-1.0-SNAPSHOT.jar app.jar
EXPOSE 8083

ENTRYPOINT ["java", "-jar", "app.jar"]