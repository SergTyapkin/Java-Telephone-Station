# Моделирование работы системы сотовой связи
### Включает базовую станцию и имитаторы абонентов

-----
## Запуск
### служба разрешения имен orbd:
```shell
orbd -ORBInitialPort 1050 -ORBInitialHost localhost
```
### сервер:
```shell
javac -cp lib/corba-api-5.0.1.jar src/Telephone/StationServer.java src/Telephone/Cell/*.java && java -cp src Telephone.StationServer -ORBInitialPort 1050 -ORBInitialHost localhost
```
### клиент:
```shell
javac -cp lib/corba-api-5.0.1.jar src/Telephone/Tube.java src/Telephone/Cell/*.java && java -cp src Telephone.Tube "<client_name>" -ORBInitialPort 1050 -ORBInitialHost localhost
```
