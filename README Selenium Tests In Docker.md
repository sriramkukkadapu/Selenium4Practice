# XXXXXXXXXXXXX This didnt work XXXXXXXXXXXX
docker-compose -f docker-compose-v3.yml updocker-compose -f docker-compose-v3.yml updocker-compose -f docker-compose-v3.yml up
# Referring:
https://www.youtube.com/watch?v=_lBaedX4UAE&list=PL6flErFppaj1quyeiIF8Rz7nlBPOZTk6d&index=2

# Github link for docker images
https://github.com/SeleniumHQ/docker-selenium
https://hub.docker.com/u/selenium

Commands to run local

docker images => check the list of images

# pull docker image for hub
docker pull selenium/hub

# pull node - chrome debug
docker pull selenium/node-chrome-debug

# pull node - firefox debug
docker pull selenium/node-firefox-debug

# Commands to start the containers:

docker run -d -p 4545:4444 —name selenium-hub selenium/hub

docker run -d -P —link  selenium-hub:hub selenium/node-chrome-debug

docker run -d -P —link  selenium-hub:hub selenium/node-firefox-debug


# Help notes
if any container is already using an image, if some error comes like that check the list of containers
docker ps -a
then 
docker rm <container id>

