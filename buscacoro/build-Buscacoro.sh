#!/bin/sh

GENDIR=$(cd `dirname $0`;pwd)

cd $OX_HOME/workspace/OpenXavaTemplate
ant -f CreateNewProject.xml -Dproject=buscacoro

cp $MP_HOME/target/mp-openxava/*.jar $OX_HOME/workspace/buscacoro/web/WEB-INF/lib
cp $MP_HOME/application/lib/extra/*.jar $OX_HOME/workspace/buscacoro/web/WEB-INF/lib	
cp $OX_HOME/tomcat/lib/jta.jar $OX_HOME/workspace/buscacoro/web/WEB-INF/lib	
cp $OX_HOME/tomcat/lib/ejb.jar $OX_HOME/workspace/buscacoro/web/WEB-INF/lib	
cd $GENDIR
cp -R * ${OX_HOME}/workspace/buscacoro 

cp other/tomcat/snippet/context.xml $OX_HOME/tomcat/conf

cp $MP_HOME/application/lib/extra/*.jar $OX_HOME/tomcat/lib

cd $OX_HOME/tomcat/bin
./startup.sh

cd $OX_HOME/workspace/buscacoro
ant -f mp4openxava-build.xml
ant

cd $OX_HOME/workspace/buscacoro
ant generatePortlets

firefox http://localhost:8080/buscacoro/xava/homeMenu.jsp

cd $GENDIR
