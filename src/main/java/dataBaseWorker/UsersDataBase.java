package dataBaseWorker;

import service.Connector;

import javax.ejb.EJB;
import javax.ejb.Stateful;


@Stateful
public class UsersDataBase {
    //Тут Будет создание и работа с ТАБЛИЦЕЙ ПОЛЬЗОВАТЕЛЕЙ в БД

    @EJB
    private Connector connector;

    public void addUserToDataBase(){
    }

    protected void clearUsersDataBase (){
    }

}
