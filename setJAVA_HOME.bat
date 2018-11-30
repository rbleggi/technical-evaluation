echo off
cls

set PATH_JAVA_HOME=C:\Desenvolvimento\jdk1.8.0_181

if not defined JAVA_HOME (
	call setx -m JAVA_HOME "%PATH_JAVA_HOME%"
	call setx -m PATH "%Path%;%PATH_JAVA_HOME%\bin"
)