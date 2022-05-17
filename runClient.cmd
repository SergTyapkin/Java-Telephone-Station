javac -cp lib/corba-api-5.0.1.jar src/Telephone/Tube.java src/Telephone/Cell/*.java

java -cp src Telephone.Tube -ORBInitialPort 1050 -ORBInitialHost localhost
