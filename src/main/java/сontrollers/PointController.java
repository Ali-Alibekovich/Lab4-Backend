package сontrollers;


import models.Point;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static dataBaseWorker.PointsDataBase.points;

@Path("points")
@Consumes(MediaType.APPLICATION_JSON)
public class PointController {

    @POST
    public Response point(Point point) {
        points.add(point);
        return Response.ok(points).build();
    }

    @GET
    public Response points() {
        return Response.ok(points).build();
    }
}
