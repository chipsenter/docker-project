Helpful commands to run your testNG files

(make sure your're in the target dir /Users/jlindstrom/IdeaProjects/Docker_demo/target)

# java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* org.testng.TestNG ../book-flight-module.xml
# java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* org.testng.TestNG ../search-module.xml

---- Compile Command after code change ----
- Go to your project root dir  /Users/jlindstrom/IdeaProjects/Docker_demo
- mvn clean package -DskipTests
