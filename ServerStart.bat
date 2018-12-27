@java -Xmx512m -XX:+UseParallelGC -XX:MaxGCPauseMillis=100 -XX:ParallelGCThreads=2 -XX:MaxTenuringThreshold=10 -cp l1jserver.jar;lib\c3p0-0.9.1.2.jar;lib\mysql-connector-java-5.1.5-bin.jar;lib\javolution.jar l1j.server.Server
cls
ServerStart.bat
