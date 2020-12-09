package service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
public class Connector {

    @PersistenceContext(unitName = "PointsDataBase")
    private EntityManager DataBaseManager;

    public EntityManager getEntityManager() {
        return DataBaseManager;
    }
}
