package main.java.thecrud.backend;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import main.java.thecrud.rest.ContactsResource;
import main.java.thecrud.rest.UserResource;

@ApplicationPath("thecrud-backend")
public class TheCrud extends Application {

    @Inject
    private ContactsResource contactsResource;
    @Inject
    private UserResource userResource;

    @Override
    public Set<Class<?>> getClasses() {
	Set<Class<?>> resources = new HashSet<Class<?>>();
	resources.add(ContactsResource.class);
	resources.add(UserResource.class);
	return resources;
    }

    @Override
    public Set<Object> getSingletons() {
	Set<Object> resources = new HashSet<Object>();
	resources.add(contactsResource);
	resources.add(userResource);
	return resources;
    }

}
