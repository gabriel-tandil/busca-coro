@rem bees app:bind -db ${cloudbees.db.name} -a ${cloudbees.app.name} -as ${cloudbees.binding.alias} 
bees app:deploy -a $cloudName -t tomcat7 -Rjava_version=1.7 ${releaseFileName}
