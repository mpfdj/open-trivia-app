# Postman Maximize window
https://medium.com/@hirosht/postman-does-not-show-up-after-opening-62bdf533b10e
Alt + space => Maximize window



# First build the images
docker image build -t miel1980/open-trivia-frontend .
docker image build -t miel1980/open-trivia-api .

# Init swarm
docker swarm init
docker node ls
docker stack deploy -c docker-stack.yml open-trivia
docker stack ls

# Destroy swarm
docker swarm leave --force