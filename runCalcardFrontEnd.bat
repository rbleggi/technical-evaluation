echo off
cls
cd calcard-frontend
call %~dp0mvnw clean install
call %~dp1npm start