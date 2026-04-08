@echo off
echo Starting Test Execution...

cd /d %~dp0

mvn clean test

echo Test Execution Completed
pause