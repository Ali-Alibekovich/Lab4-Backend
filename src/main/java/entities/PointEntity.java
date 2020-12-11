package entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@Stateless
public class PointEntity {

    @Id
    String owner;
    double coordinateX;
    double coordinateY;
    double radiusR;
    boolean isHit;
    Date date;

}
