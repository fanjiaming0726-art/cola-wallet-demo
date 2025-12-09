FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","--add-opens","java.base/java.math=ALL-UNNAMED","-jar","/app.jar"]