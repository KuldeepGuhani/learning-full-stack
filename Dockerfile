FROM eclipse-temurin:25-jre

WORKDIR /app

COPY target/Learning-Full-Stack-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9001

ENTRYPOINT ["java", "-jar", "app.jar"]