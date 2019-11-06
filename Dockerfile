FROM java:8-jdk
ENV MYSQL_URL jdbc:mysql://localhost:3306/test
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/todo-0.0.1-SNAPSHOT.jar /app/todo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/todo-0.0.1-SNAPSHOT.jar"]