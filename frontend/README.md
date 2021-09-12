docker image build -t miel1980/open-trivia-frontend .
docker container run --name open-trivia-frontend -d -p 80:80 miel1980/open-trivia-frontend
docker exec -it open-trivia-frontend bash