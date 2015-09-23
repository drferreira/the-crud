package main.java.thecrud.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.thecrud.backend.SessionContext;
import main.java.thecrud.backend.user.User;
import main.java.thecrud.backend.user.UserDatabase;

import com.google.gson.Gson;

@Path("/user")
public class UserResource {

    @Inject
    private SessionContext sessionContext;
    @Inject
    private UserDatabase userDatabase;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(String loginData) {
	Gson gson = new Gson();
	User userToLogin = gson.fromJson(loginData, User.class);
	
	User loggedUser = userDatabase.getByLogin(userToLogin.getUsername(), userToLogin.getPassword());
	sessionContext.setLoggedUser(loggedUser);
	
	return gson.toJson(sessionContext.getLoggedUser());
    }

}
