@echo off
javac src\*.java -d classes -encoding utf-8 && jar cfm classes.jar META-INF\MANIFEST.MF -C classes . && java -jar classes.jar