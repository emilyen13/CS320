//*********************************************************************
// File: ContactService.java

// Name: Emily Nagorski

// Section: CS-320-X6131

// Description: contact service creates and houses a list of 
// contacts created by clients, and allows them to add
// edit and remove these contacts
//*********************************************************************

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    //establishing list to add contacts to
    private List<Contact> contactList = new ArrayList<Contact>();

    //adding contact information to list
    public List<Contact> add(String contactID, String firstName,
            String lastName, String phoneNumber, String homeAddress) throws Exception {
        
        //check if contact ID exists within list to resolve potential duplicate IDs
        if (contactList.size() > 0) {
            for (Contact contact : contactList) {
                if(contact.getContactID() == contactID) {
                    throw new Exception("ContactID cannot be updated.");
                }
            }
        }
        //creating contact from provided information
        Contact newContact = new Contact(contactID, firstName, lastName, phoneNumber, homeAddress);
        contactList.add(newContact);

        return contactList;
    }

    //delete entry if ID matches or exists within list
    public void delete(String contactID) {
        contactList.removeIf(contact -> (contact.getContactID() == contactID));
    }

    
    public void update(String contactID, String field, String value) throws Exception {

        //switch case for updating specified fields
        for (Contact contact : contactList) {
            if(contact.getContactID() == contactID) {
                switch (field) {
                    case "firstName":
                        contact.setFirstName(value);
                        break;
                    case "lastName":
                        contact.setLastName(value);
                        break;
                    case "phoneNumber":
                        contact.setPhoneNumber(value);
                        break;
                    case "homeAddress":
                        contact.setHomeAddress(value);
                        break;
                    default: 
                        throw new Exception("The field " + field + " cannot be updated.");
                }
            }
        }

    }
}
