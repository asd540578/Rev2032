@java -Xmx1024m -Xms1024m -Xmn384m -Xss128k -XX:+UseParallelGC -XX:MaxGCPauseMillis=100 -XX:ParallelGCThreads=2 -XX:+UseAdaptiveSizePolicy -XX:MaxTenuringThreshold=0 -cp l1jserver.jar;lib\c3p0-0.9.1.2.jar;lib\mysql-connector-java-5.1.5-bin.jar;lib\javolution.jar l1j.server.Server
@pausel1jserver.jar
cls
ServerStart2.bat