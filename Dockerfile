FROM openjdk:21-jdk-slim AS build
WORKDIR /app
COPY . .
RUN apt-get update && apt-get install -y maven && apt-get clean
RUN mvn dependency:go-offline

COPY src/ ./src/
RUN mvn package -DskipTests

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar trenergia.jar
CMD ["java", "-jar", "trenergia.jar"]