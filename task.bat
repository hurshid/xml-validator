@ECHO OFF
set PATH=%PATH%;%JAVA_HOME%\bin
ECHO Running Java Class
java -jar Task.jar
ECHO Successfully ran Java Class
ECHO - 
ECHO -
ECHO Example: java App elementCount c:\test.xml staff OR java App scanxml c:\config.xml c:\config.xsd