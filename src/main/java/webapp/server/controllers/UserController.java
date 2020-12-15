package webapp.server.controllers;

import webapp.server.controllers.classes.User;
import webapp.server.services.UserService;

import javax.ejb.EJB;
import javax.ws.rs.*;

@Path("/user-controller")
public class UserController {

    @EJB
    UserService service;

    @POST
    @Path("/add-user")
    @Consumes("application/json")
    public boolean addUserResponse(User user){
        return service.addEntity(user.getLogin(), user.getPassword());
    }

    @POST
    @Path("/check-user")
    @Consumes("application/json")
    public boolean checkUserResponse(User user){
        return service.checkEntity(user.getLogin(),user.getPassword());
    }

//    @GET
//    @Path("/test-user")
//    @Consumes("application/json")
//    public User testGet(@QueryParam("login") String login){
//        User user = new User();
//        user.setLogin(login);
//        user.setPassword("123456787");
//        service.addEntity(user.getLogin(), user.getPassword());
//        return user;
//    }
}
