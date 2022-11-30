# Drone-managment

## About the project 
This is a mini project the bussiness is to use Drones to deliver light weight meidcations that are (urgently) needed in locations with difficult access


### What's inside 

4 mini spring boot projects

1- Erureka server (service discovery and registry allows services to find and communicate with each other without hard-coding the hostname and port 

2- Api Gateway, It provides a flexible way of routing requests based on a number of criteria, as well as focuses on cross-cutting concerns such as security, resiliency, and monitoring.

3- Drone microservice

Apis:-
    * registering a drone 
    * checking loaded medication items for a given drone
    * checking available drones for loading
    * check drone battery level for a given 
    * get drone by serial (used in medication service)

Database:-

   * h2 database (contains preloaded data presented into /resources/data.sql 
   
4-Medication microservices 
  includes api for  
    * loading a drone with medication items
    * retrun medictions loaded by drone (called through fiegn client in drone service)
    
Database:-

   * h2 database (contains preloaded data presented into /resources/data.sql 

### prerequisites


1- Install java8
1- Downlad zipkin server jar from https://jar-download.com/artifact-search/zipkin 
2- Make sure the port 9411 is not used in your system 
3- run the cmd "java -jar zipkin-server-2.23.19-exec.jar"



### Building the application
clone the project to your local machine 
then run this cmds in order 

cd Eureka-server
mvn clean install 
cd ..
cd api-gateway 
mvn clean install 
cd .. 
cd drone-service
mvn clean install
cd .. 
cd medication-service 
mvn clean install

should return BUILD SUCCESS for all projects 

### Running the application

After successful build for each project should run each jar " located in trget folder for each project " using java -jar "path_to_jar"

Ex java -jar Eureka-server-0.0.1-SNAPSHOT

### testing 




## notes 
about Zipkin :is an open source project that provides mechanisms for sending, receiving, storing, and visualizing traces. This allows us to correlate activity between servers and get a much clearer picture of exactly what is happening in our services. 
