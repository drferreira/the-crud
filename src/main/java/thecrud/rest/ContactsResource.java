package main.java.thecrud.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.thecrud.backend.ContactDatabase;
import main.java.thecrud.backend.SessionContext;

import com.google.gson.Gson;

@Path("/contacts")
public class ContactsResource {

    @Inject
    private SessionContext sessionContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
	ContactDatabase db = sessionContext.getDb();
	Gson gson = new Gson();
	return gson.toJson(db.getAll());
    }

    @GET
    @Path("/delete/{id}")
    public void deleteContact(@PathParam("id") Integer id) {
	ContactDatabase db = sessionContext.getDb();
	db.deleteById(id);
    }

}
