package entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id
    String login;
    String password;

}
