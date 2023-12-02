FROM eclipse-temurin:17-jre

COPY build/libs/pet-service-1.0-SNAPSHOT.jar app.jar
EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]