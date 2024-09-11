FROM openjdk:11.0-jre-slim
EXPOSE 8081
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} srv-neg-employee-clean-architecture-v1.jar
ENTRYPOINT ["java","-jar","/srv-neg-employee-clean-architecture-v1.jar"]