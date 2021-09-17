  
FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY target/*.jar app.jar
ENTRYPOINT ["java","-Xmx300m -jar","/app.jar"]
