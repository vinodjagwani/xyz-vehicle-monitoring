# How to run vehicle-monitoring-consumer

Before running the service we should have installed maven and docker along with jdk8

1. Using docker approach

First Build the project with command "mvn clean package docker:build -DskipTests"

Secondly There is docker-compose.yml file is provided on root folder, so to run this file we should use the command.

docker-compose up

It will start download all the containers and starts the containers.

Now you can check the urls

http://127.0.0.1:8082/index.html  (Web-Gui) you can able to see the vehicle status

http://localhost:15672/  (RabbitMQ with guest:guest username and password)



2. Using maven command

if you don't have docker then first build the project using following command

"mvn clean package"

Note for running this service you need to have rabbitmq running locally

after running rabbitmq run the command

"mvn spring-boot:run"

Now you can check the urls

http://127.0.0.1:8082/index.html  (Web-Gui) you can able to see the vehicle status

http://localhost:15672/  (RabbitMQ with guest:guest username and password)
