set currentdir=%cd%

cd %OX_HOME%\tomcat\bin
call shutdown.bat

cd %OX_HOME%\workspace
del buscacoro /s /q

cd %OX_HOME%\tomcat\webapps 
del buscacoro /s /q

cd %currentdir%
