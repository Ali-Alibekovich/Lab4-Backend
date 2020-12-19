package webapp.server.services;

import javax.ejb.Singleton;

@Singleton
public class AreaChecker {
    public boolean check(double x, double y, double r) {
        if ((x >= 0) && (y <= 0)) return y / 2 - x >= -r / 2;
        else if ((x >= 0) && (y >= 0)) return false;
        else if ((x <= 0) && (y >= 0)) return x * x + y * y <= r * r;
        else if ((x <= 0) && (y <= 0)) return (x >= -r) && (y >= -r);
        else return false;
    }
}
