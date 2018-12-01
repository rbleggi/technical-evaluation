echo off
cls
cd avaliacao-frontend
call %~dp0mvnw install
call %~dp1npm start