FROM eclipse-temurin:17-jdk-alpine-3.22

COPY ./build/libs/sopkathon-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-Duser.timezone=Asia/Seoul", "-jar",  "/app.jar"]
