package webapp.server.controllers;


import webapp.server.controllers.classes.Point;
import webapp.server.services.PointService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/point-controller")
public class PointController {

    @EJB
    PointService service;

    @POST
    @Path("/add-point")
    @Consumes("application/json")
    public Response addUserResponse(Point point)
    {
        service.addEntity(point.getX(),point.getY(),point.getR(),point.getOwner());
        return Response.ok(service.getUserPoints(point.getOwner())).build();
    }

    @GET
    @Path("/get-points")
    @Consumes("application/json")
    public ArrayList<Point> getPoints(@QueryParam("login") String login){
        return service.getUserPoints(login);
    }



}
