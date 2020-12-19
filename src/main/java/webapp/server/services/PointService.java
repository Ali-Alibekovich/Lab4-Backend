package webapp.server.services;

import webapp.server.controllers.classes.Point;
import webapp.server.db.Connector;
import webapp.server.db.entities.PointEntity;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.ArrayList;

@Singleton
public class PointService {

    @EJB
    Connector connector;

    @EJB
    AreaChecker areaChecker;

    private ArrayList<Point> points = new ArrayList<>();


    /*
        Добавляет объект в базу данных.
     */
    public void addEntity(double x, double y, double r, String owner) {
        PointEntity entity = addEntityInDB(x, y, r, owner);
        addPointInArray(x, y, r, owner, entity);
    }

    public ArrayList<Point> getUserPoints(String owner) {
        return points;
    }


    private PointEntity addEntityInDB(double x, double y, double r, String owner) {
        PointEntity entity = new PointEntity();
        entity.setX(x);
        entity.setY(y);
        entity.setR(r);
        entity.setOwner(owner);
        entity.setHit(areaChecker.check(x, y, r));
        connector.getEntityManager().persist(entity);
        return entity;
    }

    private void addPointInArray(double x, double y, double r, String owner, PointEntity entity) {
        Point point = new Point();
        point.setX(x);
        point.setY(y);
        point.setR(r);
        point.setOwner(owner);
        point.setHit(entity.getHit());
        points.add(point);
    }
}
