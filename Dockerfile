FROM jboss/wildfly
ADD ./JServer/deployment/standalone/standalone-full.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml
ADD ./JServer/deployment/modules/ /opt/jboss/wildfly/modules/
ADD ./JServer/war /opt/jboss/wildfly/standalone/deployments/
EXPOSE 8080
EXPOSE 8787
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0","--debug"]