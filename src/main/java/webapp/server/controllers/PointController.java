package webapp.server.controllers;


import webapp.server.controllers.classes.Point;
import webapp.server.db.entities.PointEntity;
import webapp.server.services.PointService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.ArrayList;

@Path("/point-controller")
public class PointController {

    @EJB
    PointService service;

    @POST
    @Path("/add-point")
    @Consumes("application/json")
    public ArrayList<PointEntity> addUserResponse(Point point)
    {
        service.addEntity(point.getX(),point.getY(),point.getR(),point.getOwner());
        return service.getUserPoints(point.getOwner());
    }



}
