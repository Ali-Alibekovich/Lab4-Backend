package dataBaseWorker;

import service.Connector;
import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class PointsDataBase {
    //Тут Будет создание и работа с ТАБЛИЦЕЙ ТОЧЕК в БД

    @EJB
    private Connector connector;


    public void addPointToDataBase(){
    }

    protected void clearPointsDataBase (){
    }


}
