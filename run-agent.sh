java -javaagent:dd-java-agent.jar \
-Ddd.logs.injection=true  \
-Ddd.service=ch-user  \
-Ddd.env=toolocalhost \
-Ddd.version=0.1 \
-Ddd.logs.injection=true \
-jar build/libs/user-0.0.1-SNAPSHOT.jar


#docker run -d -v /var/run/docker.sock:/var/run/docker.sock:ro \
#              -v /proc/:/host/proc/:ro \
#              -v /sys/fs/cgroup/:/host/sys/fs/cgroup:ro \
#              -p 127.0.0.1:8126:8126/tcp \
#              -e DD_API_KEY=841f2251fac8060a105b01cb900ce622  \
#              -e DD_APM_ENABLED=true \
#              gcr.io/datadoghq/agent:latest