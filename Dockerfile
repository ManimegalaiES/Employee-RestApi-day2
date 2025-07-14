FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk
COPY --from=build /target/*.jar springbootfirst.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "springbootfirst.jar"]
