package entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class PointEntity {

    @Id
    String owner;
    double x;
    double y;
    double r;
    boolean isHit;
    Date date;
}
