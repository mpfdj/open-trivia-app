docker image build -t miel1980/greeting-frontend .
docker container run --name greeting-frontend -d -p 80:80 miel1980/greeting-frontend
docker exec -it greeting-frontend bash