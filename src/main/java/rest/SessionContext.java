package main.java.rest;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@SessionScoped
public class SessionContext implements Serializable {

    private static final long serialVersionUID = -1433179043318154613L;

    @Inject
    private ContactDatabase db;

    public ContactDatabase getDb() {
	return db;
    }

}
