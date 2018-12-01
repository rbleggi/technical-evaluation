echo off
cls

set PATH_JAVA_HOME=C:\Program Files\Java\jdk1.8.0_191

if not defined JAVA_HOME (
	call setx -m JAVA_HOME "%PATH_JAVA_HOME%"
	call setx -m PATH "%Path%;%PATH_JAVA_HOME%\bin"
)