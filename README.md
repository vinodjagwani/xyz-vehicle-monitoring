# xyz-vehicle-monitoring



Overview

Vehicle status monitoring is basically online web based solution where users are able to see their status, while every connected vehicle will send ping in every minute to the system if there is no ping, means the vehicle is not connected.
The proposed solution is based on highly scalable solution which runs under on any cloud platform without changing any code apart from configurations. The whole system is developed on Java and spring echo system.
Architecture  
Above diagram represents the overall picture and flow of solution. The solution is designed based on consideration of highly scalable solution. Following is the explanation.
1. The producer is responsible for getting incoming request from device(device will consume rest api) which contains the information such vehicle id, customer id and the status true, so whenever device send a request it will send these 3 parameters (it’s assumption parameter can be more) and then producer will forward this message to rabbitmq on the queue. 
2. Producer is microservice in nature, so it can be run on cloud with multiple instances with load balancer.
3. Once the message arrives on queue, different consumers will be ready to pick message and based on round robin algorithm queue will be consumed by any one consumer and process the message.
4. Each Consumer is connected with redis db cluster and after receiving message consumer will store this message in redis db for 60 seconds and after this time it will automatically remove this message.
5. Consumer is also microservice in nature, its can also increase into multiple instances and also create a group of consumers who can connected with redis cluster.
6. Once the message store in redis db immediately afterwards it send the same message to websocket which is connected with frontend application.
7.  Once message received by frontend using socketconnection it will refresh the status of vehicles on the page (just for performance purpose pagination is used).
8. Since currently frontend application connected with consumer so after refreshing of page, frontend ask the vehicle and customer data which is store in mysql and also contact with redis db, so to update those status which are already in redis db and return back to frontend.


