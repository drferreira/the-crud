package main.java.thecrud.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.thecrud.backend.SessionContext;
import main.java.thecrud.backend.user.User;

import com.google.gson.Gson;

@Path("/user")
public class UserResource {

    @Inject
    private SessionContext sessionContext;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(String loginData) {
	System.out.println(loginData);

	Gson gson = new Gson();
	User userToLogin = gson.fromJson(loginData, User.class);
	sessionContext.setLoggedUser(userToLogin);
	
	return gson.toJson("{ loginStatus: 'logged'}");
    }

    @GET
    @Path("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
	sessionContext.setLoggedUser(null);
	return "{ logout: 'true' }";
    }

}
