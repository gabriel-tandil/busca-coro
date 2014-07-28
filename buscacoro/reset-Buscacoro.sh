#!/bin/sh

GENDIR=$(cd `dirname $0`;pwd)

cd $OX_HOME/tomcat/bin
./shutdown.bat

cd $OX_HOME/workspace
rm -r buscacoro 

cd $OX_HOME/tomcat/webapps 
rm -r buscacoro 

cd $GENDIR
