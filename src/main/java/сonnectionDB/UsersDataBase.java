package сonnectionDB;

import service.Connector;

import javax.ejb.EJB;

public class UsersDataBase {
    //Тут Будет создание и работа с ТАБЛИЦЕЙ ПОЛЬЗОВАТЕЛЕЙ в БД

    @EJB
    private Connector connector;

    public void addUserToDataBase(){
    }

    protected void clearUsersDataBase (){
    }
}
