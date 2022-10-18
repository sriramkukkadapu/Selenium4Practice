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
 	


 	








