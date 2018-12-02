echo off
cls
cd calcard-frontend
call %~dp0mvnw install
call %~dp1npm start