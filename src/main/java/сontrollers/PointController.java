package сontrollers;


import models.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
public class PointController {
    @POST
    public Response insertUser(User user) {
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        return Response.ok("Вы успешно зарегистрированы").build();
    }

}
