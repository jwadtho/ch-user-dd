# shell

imageBuild=ch-user:0.1
docker build -t $imageBuild .

#docker run -p 127.0.0.1:9211:9211/tcp \
#           -e SPRING_PROFILES_ACTIVE=k8s  \
#           -e MYSQL_HOST=rm-gs5sie41gt309b8jn.mysql.singapore.rds.aliyuncs.com \
#           -e SPRING_DATASOURCE_PASSWORD=48Wfft_tsPBD5eWu \
#           -e SPRING_DATASOURCE_USERNAME=tootest \
#        $imageBuild


docker run -p 127.0.0.1:9211:9211/tcp \
           -e SPRING_PROFILES_ACTIVE=k8s \
            $imageBuild
