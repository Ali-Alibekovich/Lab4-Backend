package webapp.server.services;

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

    private ArrayList<PointEntity> points = new ArrayList<>();


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
        connector.getEntityManager().persist(entity);
        points.add(entity);
    }

    public ArrayList<PointEntity> getUserPoints(String owner)
    {
        return (ArrayList<PointEntity>) points.stream().filter(p -> p.getOwner().equals(owner)).collect(Collectors.toList());
    }
}
