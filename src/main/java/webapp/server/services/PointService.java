package webapp.server.services;

import webapp.server.controllers.classes.Point;
import webapp.server.db.Connector;
import webapp.server.db.entities.PointEntity;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        updatePointsList();
        PointEntity entity = addEntityInDB(x, y, r, owner);
        addPointInArray(x, y, r, owner, entity);
    }

    public ArrayList<Point> getUserPoints(String owner) {
        return points.stream().filter(o -> o.getOwner().equals(owner)).collect(Collectors.toCollection(ArrayList::new));
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

    public void updatePointsList(){
        Query query = connector.getEntityManager().createQuery("SELECT entity FROM PointEntity entity");
        List<PointEntity> pointEntityList = query.getResultList();
        points.clear();
        for (PointEntity pointEntity : pointEntityList) {
            Point point = new Point();
            point.setX(pointEntity.getX());
            point.setY(pointEntity.getY());
            point.setR(pointEntity.getR());
            point.setOwner(pointEntity.getOwner());
            point.setHit(pointEntity.getHit());
            points.add(point);
        }
    }
}
