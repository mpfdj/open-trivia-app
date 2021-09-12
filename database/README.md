# Fix apt update in WSL
https://askubuntu.com/questions/91543/apt-get-update-fails-to-fetch-files-temporary-failure-resolving-error
https://github.com/microsoft/WSL/issues/6404


# Elasticsearch docker image
https://www.elastic.co/guide/en/elasticsearch/reference/7.5/docker.html

docker pull docker.elastic.co/elasticsearch/elasticsearch:7.5.2
docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.5.2
