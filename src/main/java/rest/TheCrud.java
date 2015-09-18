package main.java.rest;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("thecrud")
public class TheCrud extends Application {

    @Inject
    private Contacts contactsResource;

    @Override
    public Set<Class<?>> getClasses() {
	Set<Class<?>> resources = new HashSet<Class<?>>();
	resources.add(Contacts.class);
	return resources;
    }

    @Override
    public Set<Object> getSingletons() {
	Set<Object> resources = new HashSet<Object>();
	resources.add(contactsResource);
	return resources;
    }

}
