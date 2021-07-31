# shell

imageBuild=ch-user:0.1
docker build -t $imageBuild .

docker run -p 127.0.0.1:9211:9211/tcp \
        $imageBuild