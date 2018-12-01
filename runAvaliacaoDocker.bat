echo off
cls
call "%~dp0mvnw" clean package
call docker-compose up