# Course link
https://thoughtworks.udemy.com/course/selenium-webdriver-with-docker/learn/lecture/13299740#overview

# Commands to create a docker image file.

1) Dont run this => docker system prune -a => clears everything
2) docker rm $(docker ps -aq) => Removes all open containers
3) Bring down containers started only via docker-compose 	
docker-compose down

2) docker pull alpine => we ll use alpine mostly
3) docker pull busybox
4) docker images => To get list of docker images

Docker file: (DockerfileVinothSelvaraj)
=============================================

FROM alpine
ENTRYPOINT date

Now build the docker image from file

 	docker build -t=sriramkukkadapu/datefinder .

Now run command and check
 
 	docker images
 	
It will show newly created image in the list

 	sriramkukkadapu/datefinder   latest        cfbcf675af73   2 months ago    5.54MB
 	
To run the datefinder image

 	docker run sriramkukkadapu/datefinder 	
 	
Create image with java 	
============================

write a program Test.java which displays Hello World message

Now Start alpine container interactive mode.

 	docker run -it alpine
 	
Run Below command to see all available packages in alipe

 	ls -al
 	
Run below command to install java in alipe image.

 	apk add openjdk8
 	
Now Run both java & javac commands and see if they are working fine
 	
 	java
 	javac
 	

[ONLY IN CASE OF ERROR] If javac doesnt work that means we need to add javac to the path
	
 	find / -name javac 	 	
 	
 	It will give a path, add it to PATH variable
 	export PATH = $PATH:/usr/lib/jvm/java-1.8-openjdk/bin/javac
 	
Create a work directory under path /usr/share
	
 	mkdir sriram
 	
Add Test.java to the docker image -> Test.java is so far present in our local 

 	ADD Test.java
 	
Build the image to run the Hello world java program

 	docker build -t=sriramkukkadapu/helloworld .

Now check the docker images to see new image of hello world
 	
 	docker images 	
 	
 	it will show new image sriramkukkadapu/helloworld
 	
Now run the docker image hello world

 	docker run sriramkukkadapu/helloworld 	
 	
 	It will print Hello World
 	
(FYI) Start a container in interactive mode with hello world image

 	docker run -it --entrypoint=/bin/sh sriramkukkadapu/helloworld 	

Now change the Java program to accept integer, command line argument and print squares of it. 	

Now Build the docker image with new name saying "Squares"

 docker build -t=sriramkukkadapu/squares .
 
Check docker images to see if new image is built

  	docker images will list below
	sriramkukkadapu/squares
	
Run the new docker image squares

 	docker run sriramkukkadapu/squares
 	
Now make the docker file has a ENV variable instead of hard coded input

 	Instead of this: ENTRYPOINT javac Test.java && java Test 5 	
 	We ll make it as
 	ENTRYPOINT javac Test.java && java Test $NUMBER
 	
Now Rebuild image again and Run this time run by passing environment variable
	
 	docker build -t=sriramkukkadapu/squares .
 	docker run -e NUMBER=10  sriramkukkadapu/squares
 	
Pushing image to docker hub

 	docker login
 	docker push sriramkukkadapu/squares
 	
Updating the image with new tag name after changes

 	docker tag sriramkukkadapu/squares:latest sriramkukkadapu/squares:release-1.0 
 	
 	Now run docker images
 	
 	sriramkukkadapu/squares      release-1.0   5ff57a2d3fde   3 hours ago    131MB
 	
Push the updated release to docker repository

 	docker push sriramkukkadapu/squares:release-1.0 
 	
Now go and check the docker website it will show 2 releases of this image.

 	
 		 	
#How to Run the existing Image with environment variable

docker run -e NUMBER=10 sriramkukkadapu/squares:latest 	 	

#How to check the logs/output of a container

docker logs <container_id>/<container_name>

#Docker-compose

Docker compose helps to run multiple containers at a time. For ex Database, server, etc can be run as multiple containers at same time
Docker compose is to perform series of steps with the help of a file.

#How to bringup docker container using docker-compose

docker-compose up
docker-compose -f <docker-compose.yaml> up
docker-compose -f <docker-compose.yaml> down


#Example to start multiple containers

version: "3"
services:

  nginx: 
    image: nginx
    container_name: nginxContainer

  alpine:
    image: alpine
    entrypoint: "ping nginx"
    depends_on: 
       - nginx
       
#Bring up container in detached mode(Doesnt show much logs)

docker-compose  -f docker-compose2.yaml up -d      

#Steps to run the Docker + Selenium Grid example locally 

1. docker-compose -f docker-compose-selenium-grid.yaml up -d
2. Run this testng xml: TestNG_Docker_Gird_Chrome_FireFox.xml
3. Check in browser(Tests running on Grid): http://localhost:4444/ui/index.html

#Scale up containers in Grid

1. To Scale up chrome to 4 containers
	docker-compose -f docker-compose-selenium-grid.yaml up -d --scale chrome=4

2. To scale up both chrome & firefox to 4 containers
	docker-compose -f docker-compose-selenium-grid.yaml up -d --scale chrome=4 --scale firefox=4
	
	
#Scale down containers in Grid

docker-compose -f docker-compose-selenium-grid.yaml up -d --scale chrome=1 --scale firefox=1

Just mention the number in scale to less number 
 	

#Make a External Node machine connect to Hub

In the Node machine run below command, We need to give IP address of Hub machine

java -jar selenium-standalone-3.3.1.jar -role node -hub http://10.0.1.2:4444/grid/register 


#Connect Node machine to Hub(External machine). Here Hub is in some other machine

In docker-compose, In  the node side we need to add IP address of Host Hub in the envirnoment variable

version: "3"
services:
  chrome:
    image: selenium/node-chrome:4.1.0
    shm_size: '2g'        
    depends_on:
      - hub
    environment:
      - HUB_HOST=10.0.1.15 
      - SE_EVENT_BUS_HOST=hub
      - SE_EVENT_BUS_PUBLISH_PORT=4442
      - SE_EVENT_BUS_SUBSCRIBE_PORT=4443

  firefox:
    image: selenium/node-firefox:4.1.0
    shm_size: '2g'   
    depends_on:
      - hub
    environment:
      - HUB_HOST=10.0.1.15 
      - SE_EVENT_BUS_HOST=hub
      - SE_EVENT_BUS_PUBLISH_PORT=4442
      - SE_EVENT_BUS_SUBSCRIBE_PORT=4443      
      
      
# Running tests inside docker container

0. Start Selenium Grid 7 keep it running using below command

docker-compose -f docker-compose-selenium-grid.yaml up

1. Configure maven to run in command line

2. Add maven plugins to the POM.xml => refer to maven-plugins.txt file to know what plugins to add

3. In the project Root directory run this command to build the package (Dont run the tests just build package)

mvn clean package -DskipTests      

4. Above command will generate the jar files of main folder & test folder of the project

/Users/sriramku/eclipse-workspace/Selenium4Practice/target/selenium-docker.jar
/Users/sriramku/eclipse-workspace/Selenium4Practice/target/selenium-docker-tests.jar

5. Target will also have libs folder which has all dependencies like selenium testng etc

6. Now use below command to run the TestNG xml file along with maven jar file

java -cp "selenium-docker.jar:selenium-docker-tests.jar:libs/*" org.testng.TestNG ../docker_handson_vinothselvaraj/TestNG_Docker_Gird_Chrome_FireFox.xml

7. If we are having any properties file under resources directory it wont be considered while running the command above so we need to specify it.

java -cp "selenium-docker.jar:selenium-docker-tests.jar:libs/*:src/test/resources/my.properties" org.testng.TestNG ../docker_handson_vinothselvaraj/TestNG_Docker_Gird_Chrome_FireFox.xml

8. by default above tests run in chrome because we didnt specify browser parameter in the command. If we want to run the tests in firefox.

java -cp "selenium-docker.jar:selenium-docker-tests.jar:libs/*" -DBROWSER=firefox org.testng.TestNG ../docker_handson_vinothselvaraj/TestNG_Docker_Gird_Chrome_FireFox.xml


9. Now we need to create a image with all above contents. Create a DockerFile with these contents

- Get openjdk alpine image
FROM openjdk:18-ea-11-jdk-alpine3.15

- Set a starting WORKDIR
WORKDIR /usr/share/eclipse-workspace

- ADD jars to target location from host into this image
ADD target/selenium-docker.jar 				selenium-docker.jar
ADD target/selenium-docker-tests.jar 		selenium-docker-tests.jar
ADD target/libs								libs

- Add suite files, in case of other dependencies like .csv / .json / .xls add them too

ADD docker_handson_vinothselvaraj/TestNG_Docker_Gird_Chrome_FireFox.xml 	TestNG_Docker_Gird_Chrome_FireFox.xml

- 	#BROWSER
   	#HUB_HOST
	#MODULE

ENTRYPOINT java -cp "selenium-docker.jar:selenium-docker-tests.jar:libs/*" -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE

10. Now build the docker for above docker file. 

(Run this command in Root of the project)

docker build -t=sriramkukkadapu/selenium-docker -f docker_handson_vinothselvaraj/DockerFile2 .


11. Now run docker images and you ll see new image created

sriramkukkadapu/selenium-docker   latest        eea96777e00a   51 seconds ago   399MB

12. Now open above image in interactive mode.

docker run -it --entrypoint=/bin/sh sriramkukkadapu/selenium-docker

10. Now Try to run the Tests using jar file inside the image.

java -cp "selenium-docker.jar:selenium-docker-tests.jar:libs/*" -DBROWSER=firefox org.testng.TestNG TestNG_Docker_Gird_Chrome_FireF
ox.xml

This would give error Connection refused: localhost/127.0.0.1:4444

Its because inside this container docker hub is not present, docker hub is running in our host machine 

selenium-docker container nodes should point to host ip address port 4444 where grid is running

11. Find Local IP address of mac from the Network in settings

My Ip is: http://192.168.43.37/

12. Now run the tests using Jar file inside image and pass HOST IP address

java -cp "selenium-docker.jar:selenium-docker-tests.jar:libs/*" -DBROWSER=firefox -DHUB_HOST=192.168.43.37 org.testng.TestNG TestNG_Docker_Gird_Chrome_FireFox.xml

This would run the tests successfully.

13. Now Lets run the tests by creating a container of above image.

docker run -e HUB_HOST=192.168.43.37 sriramkukkadapu/selenium-docker

This would fail asking us to specify atleast one testng.xml (we need to pass $MODULE defined in docker file)

So, Modify the command as:

docker run -e HUB_HOST=192.168.43.37 -e MODULE=TestNG_Docker_Gird_Chrome_FireFox.xml sriramkukkadapu/selenium-docker

14. Run the Tests in container and do the volume mapping to host directory , To access the test-output files inside container

docker run -e HUB_HOST=192.168.43.37 -e MODULE=TestNG_Docker_Gird_Chrome_FireFox.xml -v $PWD/output:/usr/share/eclipse-workspace/test-output sriramkukkadapu/selenium-docker


# Create a docker compose file for everything above.

File created: docker_handson_vinothselvaraj/docker-compose-selenium-hub-grid-tests.yaml

Run the docker-compose file using below command (at Root of the project)

docker-compose -f docker_handson_vinothselvaraj/docker-compose-selenium-hub-grid-tests.yaml up

Sometimes above step gives error of empty vm/session not created exceptions in that we need to check the status of hub before running the tests.

curl -s http://192.168.43.37:4444/wd/hub/status | jq -r .value.ready

1. pull docker image of open jdk for debugging
docker pulll openjdk:18-ea-11-jdk-alpine3.15

2. start the container 
docker run -it --entrypoint=/bin/sh openjdk:18-ea-11-jdk-alpine3.15

3. In this container curl, jq wont be there so install them
apk add curl jq

4. Just for understanding, here you can exit from the container

5. Now health check script is added in a separate file healthcheck.sh

6. Now build the maven package once again
mvn clean package -DskipTests

7. Now build the docker image again (Run this command at root of the project)
docker build -t=sriramkukkadapu/selenium-docker -f docker_handson_vinothselvaraj/DockerFile2 .

8. Now run everything using docker-compose up
docker-compose -f docker_handson_vinothselvaraj/docker-compose-selenium-hub-grid-tests.yaml up


# Run 2 suites(testng.xmls) in parallel
1. In the docker file add one more service with browser parameter=chrome

2. These 2 services (1 chrome & 1 firefox) will run in parallel (as by default all services will run in parallel in docker-compose file)

Check the modified docker file updated. It will have 2 services like below

#sample service name just to run the tests 
  selenium-tests:
   image: sriramkukkadapu/selenium-docker
   depends_on: 
      - chrome
      - firefox
   environment:
      - BROWSER=chrome
      - HUB_HOST=hub
      - MODULE=TestNG_Docker_Gird_Chrome_FireFox.xml
   volumes:
      - ./output:/usr/share/eclipse-workspace/test-output
      
      
  #sample service name just to run the tests 
  selenium-tests2:
   image: sriramkukkadapu/selenium-docker
   depends_on: 
      - chrome
      - firefox
   environment:
      - BROWSER=firefox
      - HUB_HOST=hub
      - MODULE=TestNG_Docker_Gird_Chrome_FireFox.xml
   volumes:
      - ./output2:/usr/share/eclipse-workspace/test-output    
      
3. Note that in above services we are copying outputs of 2 xmls in 2 different folders (output & output2)      

4. Run the above file using below command and see the outputs folders under docker_handson_vinothselvaraj folder.

docker-compose -f docker_handson_vinothselvaraj/docker-compose-selenium-hub-grid-tests.yaml up

5. scale chrome & firefox and run the same command again.

docker-compose -f docker_handson_vinothselvaraj/docker-compose-selenium-hub-grid-tests.yaml up --scale chrome=2 --scale firefox=2


# Docker Tip - Remove none images
None image usually comes when we rebuild a old image docker keeps the old image as none

docker system prune -f

This command removes all none images.

# File Downloads

In your application, if you have any file downloads scenario and if you are planning to use selenium grid with docker container as shown here, then the file will be downloaded within docker container only.  As you know we need to do the volume mapping to have the file available in the host machine.

For both chrome and firefox containers, the downloaded files would be available by default in this container location. /home/seluser/Downloads

We could do the volume mapping as shown here - check the firefox and chrome section

version: "3"
services:
  hub:
    image: selenium/hub:3.14
  chrome:
    image: selenium/node-chrome:3.14      
    depends_on:
      - hub
    environment:
      - HUB_HOST=hub
    volumes:
      - ./downloads:/home/seluser/Downloads      
  firefox:
    image: selenium/node-firefox:3.14
    shm_size: '1gb'   
    depends_on:
      - hub
    environment:
      - HUB_HOST=hub
    volumes:
      - ./downloads:/home/seluser/Downloads
  search-module:
    image: vinsdocker/selenium-docker
    depends_on:
      - chrome
      - firefox
    environment:
      - HUB_HOST=hub
      - BROWSER=firefox
      - MODULE=search-module.xml
    volumes:
      - ./output/search-result:/usr/share/udemy/test-output 
      
      
# File Uploads

If you have any file upload scenario in your automated tests,  We need to add the below code. This is something you might have already if you are already using remote selenium grid.

//assuming driver is the name of the variable for WebDriver instance.
if(driver instanceof RemoteWebDriver){
   ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
}
Why the above code is required

It is not because of docker. It is because the machine containing the file and machine running chrome / firefox are different. So, we are sending our file from the selenium scripts machine to the selenium grid machine. In our case we have multiple containers instead of physical machines/VMs. So, we need to add the above code before you do the actual upload.

Will it affect my local testing when I do NOT use docker?

No worries. It will NOT affect your local testing.


      


