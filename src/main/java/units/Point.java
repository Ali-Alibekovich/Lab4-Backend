package units;

import lombok.Getter;
import lombok.Setter;
import units.interfaces.PointInterface;
import сonnectionDB.PointsDataBase;


import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;

@Stateless
@Getter
@Setter
public class Point implements Serializable {
    //Массив точек

    @Inject
    private PointsDataBase dataBase;

    double x;
    double y;
    double r;
    boolean hit;


}
