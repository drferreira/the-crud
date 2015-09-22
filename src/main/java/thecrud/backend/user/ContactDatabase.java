package main.java.thecrud.backend.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ContactDatabase implements Serializable {

    private static final long serialVersionUID = -3802307128945460155L;

    private User user = new User("Diego Santos",
	    "santos.diegoferreira@gmail.com", "123456");
    private Map<Integer, User> users;

    public ContactDatabase() {
	if (users == null) {
	    users = new HashMap<Integer, User>();
	    users.put(1, user);
	}
    }

    public User getById(Integer id) {
	return users.get(id);
    }

    public List<User> getAll() {
	List<User> userList = new ArrayList<User>();

	for (Map.Entry<Integer, User> contact : users.entrySet()) {
	    userList.add(contact.getValue());
	}
	return userList;
    }

    public void deleteById(Integer id) {
	users.remove(id);
    }

}
