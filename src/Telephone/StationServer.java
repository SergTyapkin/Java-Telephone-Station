package Telephone;

import Telephone.Cell.Station;
import Telephone.Cell.StationHelper;
import Telephone.Cell.StationPOA;
import Telephone.Cell.TubeCallback;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import java.util.HashMap;
import java.util.Map;

// Класс, реализующий IDL-интерфейс базовой станции
class StationServant extends StationPOA {
    // Вместо представленных ниже двух переменных здесь
    // должен быть список пар "номер - объектная ссылка"
    TubeCallback tubeRef;
    String tubeNum;
    Map<String, TubeCallback> abonents = new HashMap<String,TubeCallback>();

    // Метод регистрации трубки в базовой станции
    public int register (TubeCallback objRef, String phoneNum) {
        tubeRef = objRef;
        tubeNum = phoneNum;
        abonents.put(phoneNum, objRef); // save abonent callback to map
        System.out.println("Client registered: " + tubeNum);
        return (1);
    };

    // Метод пересылки сообщения от трубки к трубке
    public int sendSMS (String fromNum, String toNum, String message) {
        System.out.println("Message from: " + fromNum + " to: " + toNum + " with text: " + message);
        if (!abonents.containsKey(toNum)) {
            tubeRef.sendSMS("_Station_", "Client with name \"" + toNum + "\" doesn't exists");
            return (0);
        }
        TubeCallback ref = abonents.get(toNum); // get abonent callback by his number
        ref.sendSMS(fromNum, message);
        return (1);
    };
};

// Класс, реализующий сервер базовой станции
public class StationServer {
    public static void main(String[] args) {
        try {
            // Создание и инициализация ORB
            ORB orb = ORB.init(args, null);

            // Получение ссылки и активирование POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Создание серванта для CORBA-объекта "базовая станция"
            StationServant servant = new StationServant();

            // Получение объектной ссылки на сервант
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(servant);
            Station sref = StationHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Связывание объектной ссылки с именем
            NameComponent[] path = ncRef.to_name("BaseStation");
            ncRef.rebind(path, sref);

            System.out.println("Server ie ready and waiting for ...");

            // Ожидание обращений от клиентов (трубок)
            orb.run();
        } catch (Exception e) {
            System.err.println("Ошибка: " + e);
            e.printStackTrace(System.out);
        };
    };
};
