
# After IDEA imported the maven project, it reported an error Unable to import maven project: See logs for details (https://www.programmersought.com/article/14535097405/)
The IDEA version I used here is version 2018, and the latest maven is version 3.6.3. 
This version of maven also has the same problem on IDEA 2019 version. 
The solution is to replace the maven version with a version below 3.6.1.

# Running a SpringBoot application
mvn clean spring-boot:run
java -jar target/rest-service-0.0.1-SNAPSHOT.jar

# Docker commands
docker image build -t miel1980/open-trivia-api .
docker container run --name open-trivia-api -d -p 10001:10001 miel1980/open-trivia-api
docker exec -it open-trivia-api bash

# Run in the foreground for debugging
docker container run --name open-trivia-api -p 10001:10001 miel1980/open-trivia-api

# Some resources on github.com
https://github.com/Saseke/poseidon
https://github.com/apache/usergrid