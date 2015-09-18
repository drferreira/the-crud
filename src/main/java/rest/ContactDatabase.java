package main.java.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactDatabase {

    private Contact contact2 = new Contact(1, "Amanda Silveira",
	    "(51) 98409692");
    private Contact contact6 = new Contact(2, "Carolina Nery", "(51) 96124050");
    private Contact contact3 = new Contact(3, "Diogo Ferreira", "(51) 93034655");
    private Contact contact1 = new Contact(4, "Diego Santos", "(51) 92898863");
    private Contact contact5 = new Contact(5, "Emanoel Vianna", "(51) 96124050");
    private Contact contact4 = new Contact(6, "Fagner Schuwalm",
	    "(51) 85310598");

    private Map<Integer, Contact> contacts;

    public ContactDatabase() {
	contacts = new HashMap<Integer, Contact>();
	contacts.put(1, contact1);
	contacts.put(2, contact2);
	contacts.put(3, contact3);
	contacts.put(4, contact4);
	contacts.put(5, contact5);
	contacts.put(6, contact6);
    }

    public Contact getById(Integer id) {
	return contacts.get(id);
    }

    public List<Contact> getAll() {
	List<Contact> contactList = new ArrayList<Contact>();

	for (Map.Entry<Integer, Contact> contact : contacts.entrySet()) {
	    contactList.add(contact.getValue());
	}
	return contactList;
    }

}
