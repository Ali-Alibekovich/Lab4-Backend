package сonnectionDB;

import entities.PointEntity;
import service.Connector;
import javax.ejb.EJB;


public class PointsDataBase {
    //Тут Будет создание и работа с ТАБЛИЦЕЙ ТОЧЕК в БД

    @EJB
    private Connector connector;


    public void addPointToDataBase(){
    }

    protected void clearPointsDataBase (){
    }


}
