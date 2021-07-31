java -javaagent:dd-java-agent.jar \
-Ddd.logs.injection=true  \
-Ddd.service=ch-user  \
-Ddd.env=toolocalhost \
-Ddd.version=0.1 \
-Ddd.logs.injection=true \
-jar build/libs/user-0.0.1-SNAPSHOT.jar