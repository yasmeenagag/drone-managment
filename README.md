# Drone-managment

## About the project 
This is a mini project the bussiness is to use Drones to deliver light weight meidcations that are (urgently) needed in locations with difficult access


### What's inside <br/>

four mini spring boot projects<br/>

1- Erureka server (service discovery and registry allows services to find and communicate with each other without hard-coding the hostname and port <br/>

2- Api Gateway, It provides a flexible way of routing requests based on a number of criteria, as well as focuses on cross-cutting concerns such as security, resiliency, and monitoring.<br/>

3- Drone microservice<br/>

Apis:- <br/>
     registering a drone <br/>
     checking loaded medication items for a given drone <br/>
     checking available drones for loading <br/>
     check drone battery level for a given <br/>
     get drone by serial (used in medication service) <br/> 

Database:-

   * h2 database (contains preloaded data presented into /resources/data.sql 
   
4-Medication microservices <br/><br/>

 Apis:- <br/>
      loading a drone with medication items<br/>
      retrun medictions loaded by drone (called through fiegn client in drone service)<br/>
    
Database:-<br/>

   * h2 database (contains preloaded data presented into /resources/data.sql <br/>

### prerequisites<br/>


1- Install java8
1- Downlad zipkin server jar from https://jar-download.com/artifact-search/zipkin <br/>
2- Make sure the port 9411 is not used in your system <br/>
3- run the cmd "java -jar zipkin-server-2.23.19-exec.jar"<br/>
<br/><br/><br/>


### Building the application<br/>   
clone the project to your local machine <br/>
then run this cmds in order <br/>

cd Eureka-server <br/>
mvn clean install <br/>
cd .. <br/>
cd api-gateway <br/>
mvn clean install  <br/>
cd ..  <br/>
cd drone-service <br/>
mvn clean install <br/>
cd .. <br/>
cd medication-service <br/>
mvn clean install <br/>

should return BUILD SUCCESS for all projects <br/>

### Running the application <br/>

After successful build for each project should run each jar " located in trget folder for each project " using java -jar "path_to_jar" <br/>

Ex java -jar Eureka-server-0.0.1-SNAPSHOT <br/>




## notes 
to check the full trace for each request cycle please view http://localhost:9411/zipkin/ <br/><br/>
![image](https://user-images.githubusercontent.com/17744054/204864488-67284fae-5ba7-45c0-8f14-6d249f2bd962.png)
<br/><br/>
to check services registed in eureka please visit http://localhost:8761/ <br/><br/>
![image](https://user-images.githubusercontent.com/17744054/204864593-7de7354a-decc-4246-acf6-23f39c13298d.png) <br/>



about Zipkin :is an open source project that provides mechanisms for sending, receiving, storing, and visualizing traces. This allows us to correlate activity between servers and get a much clearer picture of exactly what is happening in our services. 
