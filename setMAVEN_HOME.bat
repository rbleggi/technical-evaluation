echo off
cls

set PATH_MAVEN_HOME=C:\Desenvolvimento\apache-maven-3.5.4

if not defined MAVEN_HOME (
	call setx -m MAVEN_HOME "%PATH_MAVEN_HOME%"
	call setx -m PATH "%Path%;%PATH_MAVEN_HOME%\bin"
)
