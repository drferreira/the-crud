package main.java.thecrud.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.thecrud.backend.SessionContext;
import main.java.thecrud.backend.contact.Contact;
import main.java.thecrud.backend.contact.ContactDatabase;

import com.google.gson.Gson;

@Path("/contacts")
public class ContactsResource {

    @Inject
    private SessionContext sessionContext;

    @GET
    @Path("/list")
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

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String add(String newContactJson) {
	Gson gson = new Gson();
	Contact newContact = gson.fromJson(newContactJson, Contact.class);
	
	sessionContext.getDb().insert(newContact);

	return gson.toJson(sessionContext.getLoggedUser());
    }

}
