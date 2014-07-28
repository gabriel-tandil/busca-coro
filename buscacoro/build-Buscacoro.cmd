@echo off
set currentdir=%cd%

IF %OX_HOME% == "" (
set /p OX_HOME= What Openxava home directory?
)
IF %MP_HOME% == "" (
set /p MP_HOME= What Minuteproject home directory?
)
cd %OX_HOME%\workspace\OpenXavaTemplate
call ant -f CreateNewProject.xml -Dproject=buscacoro

copy %MP_HOME%\target\mp-openxava\*.jar %OX_HOME%\workspace\buscacoro\web\WEB-INF\lib
copy %MP_HOME%\application\lib\extra\*.jar %OX_HOME%\workspace\buscacoro\web\WEB-INF\lib	
copy %OX_HOME%\tomcat\lib\jta.jar %OX_HOME%\workspace\buscacoro\web\WEB-INF\lib	
copy %OX_HOME%\tomcat\lib\ejb.jar %OX_HOME%\workspace\buscacoro\web\WEB-INF\lib	
cd %currentdir%
xcopy * %OX_HOME%\workspace\buscacoro /y /s

copy other\tomcat\snippet\context.xml %OX_HOME%\tomcat\conf

xcopy %MP_HOME%\application\lib\extra\*.jar %OX_HOME%\tomcat\lib\*.* /y /s

cd %OX_HOME%\tomcat\bin
call startup.bat

cd %OX_HOME%\workspace\buscacoro
call ant -f mp4openxava-build.xml
call ant

cd %OX_HOME%\workspace\buscacoro
call ant generatePortlets

call explorer http://localhost:8080/buscacoro/xava/homeMenu.jsp

cd %currentdir%
