Helpful commands to run your testNG files

(make sure your're in the target dir /Users/jlindstrom/IdeaProjects/Docker_demo/target)

# java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* org.testng.TestNG ../book-flight-module.xml
# java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* org.testng.TestNG ../search-module.xml

---- Compile Command after code change ----
- Go to your project root dir  /Users/jlindstrom/IdeaProjects/Docker_demo
- mvn clean package -DskipTests

---- See your Images ----
#  docker images

---- See your active Images ----
# docker ps -a

---- Build your image ----
# docker build -t=fanaticsautomation/selenium-docker .

---- Start your Docker Compose file ----
# docker-compose up

---- Bring down your Docker compose file ----
# docker-compose down

---- See status of containers running from your compose file ----
# docker-compose ps -a

---- Scale multiple browsers (chrome,firefox)
# docker-compose up -d --scale chrome=2 (will spin up 2 chrome browsers) default 1
# docker-compose up -d --scale chrome=4 --scale firefox=4 (will add 4 chromes and 4 firefox browsers)

---- Run your docker image in Interactive Mode ----
# docker run -it --entrypoint=/bin/sh fanaticsautomation/selenium-docker

---- Run your java image inside of your docker container ----
# java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* org.testng.TestNG search-module.xml

---- Volume mapping of the container ----
# docker run -it --entrypoint=/bin/sh -v /Users/jlindstrom/IdeaProjects/Docker_demo/output:/usr/share/udemy/test-output fanaticsautomation/selenium-docker

---- Map your container to go to correct hub ----
# java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DHUB_HOST=192.168.1.6 org.testng.TestNG search-module.xml

---- Run your container from your commandline locally ----
# docker run -e HUB_HOST=10.0.0.195 -e MODULE=search-module.xml fanaticsautomation/selenium-docker

---- Remove image not in use ----
# docker rmi repository name i.e selenium/test + tag 3.14

---- Filter the output in the terminal ----
# docker-compose up | grep -e 'search-module'

---- Clean up your unused images and <none> images ----
# docker system prune -f

---- Rebuild your image after updating the dockerfile ----
# docker build -t="fanaticsautomation/selenium-docker" .
