@echo off
set JAVA_HOME=C:\PROGRA~1\JAVA\JDK-25
set M2_HOME=c:\tools\apache-maven
pushd %cd%
cd ..
call %M2_HOME%\bin\mvn dependency:tree
call %M2_HOME%\bin\mvn dependency:resolve -Dclassifier=javadoc
call %M2_HOME%\bin\mvn dependency:resolve -Dclassifier=sources
call %M2_HOME%\bin\mvn javadoc:javadoc
pause
popd
