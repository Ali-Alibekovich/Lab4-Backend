package units;

import lombok.Getter;
import lombok.Setter;
import сonnectionDB.PointsDataBase;
import сonnectionDB.UsersDataBase;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Getter
@Setter
public class User {
    //Массив юзеров
    @Inject
    private UsersDataBase dataBase;

    String login;
    String password;


}
