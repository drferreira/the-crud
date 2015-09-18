package main.java.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("thecrud")
public class TheCrud extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public TheCrud() {
	singletons.add(new Contacts());
    }

    @Override
    public Set<Object> getSingletons() {
	return singletons;
    }

}
