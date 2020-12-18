package webapp.server.services;

import webapp.server.controllers.classes.Point;
import webapp.server.db.Connector;
import webapp.server.db.entities.PointEntity;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

@Singleton
public class PointService {

    @EJB
    Connector connector;

    private ArrayList<Point> points = new ArrayList<>();


    /*
        Добавляет объект в базу данных.
     */
    public void addEntity(double x, double y, double r, String owner)
    {
        PointEntity entity = new PointEntity();
        entity.setX(x);
        entity.setY(y);
        entity.setR(r);
        entity.setCreationTime(new Date());
        entity.setOwner(owner);
        entity.setHit(true);
        connector.getEntityManager().persist(entity);
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        point.setR(r);
        point.setOwner(owner);
        point.setDate(entity.getCreationTime());
        point.setHit(entity.getHit());
        points.add(point);
    }

    public ArrayList<Point> getUserPoints(String owner)
    {
        System.out.println("Это логин " + owner);
        return points;
    }
}
