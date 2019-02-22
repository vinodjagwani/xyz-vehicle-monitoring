FROM java:8

EXPOSE 8081
EXPOSE 5005


ENV RABBITMQ_HOST rabbitmq
ENV RABBITMQ_PORT 5672
ENV RABBITMQ_USER_NAME guest
ENV RABBITMQ_PASSWORD guest


ADD vehicle-monitoring-producer-1.0.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker","-jar","/app.jar"]
