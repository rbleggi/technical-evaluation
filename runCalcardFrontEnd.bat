echo off
cls
cd calcard-frontend
call  "../mvnw" clean install
call "../node/npm" --scripts-prepend-node-path=true start