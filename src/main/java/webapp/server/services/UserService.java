package webapp.server.services;

import webapp.server.db.Connector;
import webapp.server.db.entities.UserEntity;
import javax.ejb.EJB;
import javax.ejb.Singleton;

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
        if (!connector.getEntityManager().contains(entity.getLogin())){
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
        return connector.getEntityManager().contains(entity);
    }
}
