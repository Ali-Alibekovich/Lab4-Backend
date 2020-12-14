package dataBaseWorker;

import models.Point;
import javax.ejb.Stateful;
import java.util.LinkedList;
import java.util.Queue;

@Stateful
public class PointsDataBase {
    //Тут Будет создание и работа с ТАБЛИЦЕЙ ТОЧЕК в БД
    public static Queue<Point> points = new LinkedList<>();

    public static Queue<Point> getPoints() {
        return points;
    }
    //    @EJB
//    private Connector connector;
//
//
//    public void addPointToDataBase(){
//    }
//
//    protected void clearPointsDataBase (){
//    }


}
