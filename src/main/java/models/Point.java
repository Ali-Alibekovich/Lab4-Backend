package models;

import lombok.Getter;
import lombok.Setter;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
@Getter
@Setter
public class Point implements Serializable {
    //Объект для точек
    double coordinateX;
    double coordinateY;
    double radiusR;
    boolean isHit;
}
