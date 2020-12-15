package webapp.client;

import webapp.server.controllers.classes.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@RequestScoped
@ManagedBean
public class UserBean {
    private String login;
    private String password;
    private String message;

    public void sendToServer(){
        Client client = ClientBuilder.newClient();
        User o = client.target("http://localhost:8080/web_4-1.0/userService/test-user")
                .queryParam("login", login).request().get(User.class);
        System.out.println(o);
        setMessage(o.toString());
    }



    public void sentPost(){

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
