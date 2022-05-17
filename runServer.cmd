javac -cp lib/corba-api-5.0.1.jar src/Telephone/StationServer.java src/Telephone/App/*.java

java -cp src Telephone.StationServer -ORBInitialPort 1050 -ORBInitialHost localhost
