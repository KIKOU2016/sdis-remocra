#
# Container name  : dbdocker_geoserver_1
# URL             : http://localhost:8090/geoserver
# Credentials     : admin / geoserver
#

cd $(dirname $0)

# Installation du plugin querylayer

# Récupération de la version de Geoserver
#GEOSERVER_VERSION="2.6.0"
GEOSERVER_VERSION=$(docker exec dbdocker_geoserver_1 cat /usr/local/tomcat/webapps/geoserver/META-INF/MANIFEST.MF | grep Implementation-Version | cut -d ':' -f 2 | cut -d ' ' -f 2) \
  && GEOSERVER_VERSION=${GEOSERVER_VERSION:-1}

# Récupération du plugin querylayer
wget -q "http://downloads.sourceforge.net/geoserver/geoserver-${GEOSERVER_VERSION}-querylayer-plugin.zip" \
  && unzip -qn geoserver-${GEOSERVER_VERSION}-querylayer-plugin.zip \
  && rm -f geoserver-*-querylayer-plugin.zip \
  && docker cp gs-querylayer-${GEOSERVER_VERSION}.jar dbdocker_geoserver_1:/usr/local/tomcat/webapps/geoserver/WEB-INF/lib/ \
  &&  rm -f gs-querylayer-*.jar

