package main.java.thecrud.backend;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.Produces;

import main.java.thecrud.backend.contact.ContactDatabase;
import main.java.thecrud.backend.user.User;

@SessionScoped
public class SessionContext implements Serializable {

    private static final long serialVersionUID = -1433179043318154613L;

    @Inject
    private ContactDatabase db;
    private User loggedUser;

    public ContactDatabase getDb() {
	return db;
    }

    @Produces
    @LoggedUser
    public User getLoggedUser() {
	return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
	this.loggedUser = loggedUser;
    }

}
