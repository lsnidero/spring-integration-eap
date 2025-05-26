FROM registry.redhat.io/jboss-eap-7/eap74-openjdk8-openshift-rhel8:7.4.22-5.1746546304
COPY target/spring-greeter.war /deployments

RUN mkdir /opt/eap/extensions
COPY extensions/actions.cli /opt/eap/extensions
COPY extensions/postconfigure.sh /opt/eap/extensions
USER root
RUN chmod 774 /opt/eap/extensions/*.sh
USER jboss
EXPOSE 9080
CMD ["/opt/eap/bin/openshift-launch.sh"]


