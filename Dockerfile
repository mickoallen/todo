FROM java:8-jdk
EXPOSE 8080
RUN mkdir -p /app/

ADD build/libs/todo-0.0.1-SNAPSHOT.jar /app/todo-0.0.1-SNAPSHOT.jar
ADD my-app/dist /app/my-app
WORKDIR /app
ARG JAVA_OPTS="-Xms256m -Xmx512m"

ENTRYPOINT ["java", "-jar", "/app/todo-0.0.1-SNAPSHOT.jar"]
