FROM jboss/wildfly
ADD ./war/Times/deployment/standalone/standalone-full.xml /opt/jboss/wildfly/standalone/configuration/standalone.xml
ADD ./war/Times/deployment/modules/ /opt/jboss/wildfly/modules/
ADD ./war/Times/war /opt/jboss/wildfly/standalone/deployments/
EXPOSE 8080
EXPOSE 8787
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0","--debug"]