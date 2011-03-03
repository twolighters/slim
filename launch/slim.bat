@echo off

rem This line assumes %OS%=="Windows_NT"
set SLIM_HOME=%~dp0

set JAVA_COMMAND=%JAVA_HOME%\bin\java
if "%JAVA_COMMAND%" == "\bin\java" set JAVA_COMMAND=java

%JAVA_COMMAND% -jar %SLIM_HOME%slim.jar %*