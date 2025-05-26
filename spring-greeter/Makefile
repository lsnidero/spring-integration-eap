export JAVA_HOME=/usr/lib/sdk/openjdk8/jvm/java-8-openjdk
export EAP_HOME=/home/lsnidero/Projects/jboss-eap-7.4

compile:
	./mvnw clean package
deploy: compile
	cp target/spring-greeter.war ${EAP_HOME}/standalone/deployments

run-eap: deploy compile
	${EAP_HOME}/bin/standalone.sh -b 0.0.0.0 -Djboss.socket.binding.port-offset=1000
