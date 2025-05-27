export JAVA_HOME=/usr/lib/sdk/openjdk8/jvm/java-8-openjdk
export JBOSS_HOME=/home/lsnidero/Projects/jboss-eap-7.4

compile:
	./mvnw clean package
deploy: compile
	cp target/spring-greeter.war ${JBOSS_HOME}/standalone/deployments

run-eap: deploy compile
	${JBOSS_HOME}/bin/standalone.sh -b 0.0.0.0 -Djboss.socket.binding.port-offset=1000

build: compile
	podman build -t quay.io/lsnidero/eap-spring-greeter .

run-eap-container: build compile
	podman run -it -p 9080:9080 -e JBOSS_SOCKET_BINDING_PORT_OFFSET=1000 quay.io/lsnidero/eap-spring-greeter
