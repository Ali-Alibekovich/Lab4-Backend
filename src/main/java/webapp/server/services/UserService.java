package webapp.server.services;

import webapp.server.db.Connector;
import webapp.server.db.entities.UserEntity;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.persistence.Query;

@Singleton
public class UserService {

    @EJB
    Connector connector;

    /*
        Добавляет объект в базу данных,
        Не добавляет объект, если с таким логином уже существует пользователь.
     */
    public boolean addEntity(String login, String password)
    {
        boolean state = false;

        UserEntity entity = new UserEntity();
        entity.setLogin(login);
        entity.setPassword(password);
        //TODO:тоже так понимаю не будет из-за contains
        if (connector.getEntityManager().find(entity.getClass(),entity.getLogin()) == null){
            connector.getEntityManager().persist(entity);
            state = true;
        }
        return state;
    }

    /*
        Проверяет сходство объекта из БД с объектом из запроса.
     */
    public boolean checkEntity(String login, String password)
    {

        UserEntity entity = new UserEntity();
        entity.setLogin(login);
        entity.setPassword(password);
        //TODO:не работает
        Query query = connector.getEntityManager().createQuery("SELECT entity FROM UserEntity entity WHERE login=:log and password=:pass");
        query.setParameter("log",login);
        query.setParameter("pass", password);

        return  !query.getResultList().isEmpty();
    }

}
