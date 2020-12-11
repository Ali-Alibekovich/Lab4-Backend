package models;

import lombok.Getter;
import lombok.Setter;

import javax.ejb.Stateless;

@Stateless
@Getter
@Setter
public class User {
    //объект для пользователей
    String login;
    String password;
}
