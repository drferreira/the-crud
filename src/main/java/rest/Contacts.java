package main.java.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Path("/contacts")
public class Contacts {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
	ContactDatabase db = new ContactDatabase();
	Gson gson = new Gson();
	return gson.toJson(db.getAll());
    }

}
