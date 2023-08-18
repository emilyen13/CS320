/* 
Emily Nagorski
CS 320 - X6131
Project 1
*/

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactServiceTest {

    ContactService service = new ContactService();
    String contactID = "George13";
    String firstName = "Emily";
    String lastName = "Blue";
    String phoneNumber = "3095550123";
    String homeAddress = "271 Blue House St";
    List<Contact> contactList = new ArrayList<Contact>();

    @Test
    public void canAddContactToList() throws Exception {
        contactList = service.add(contactID, firstName, lastName, phoneNumber, homeAddress);
        assertThat(contactList.size(), is(equalTo(1)));
    }

    @Test
    public void canDeleteContactFromList() throws Exception {
        contactList = service.add(contactID, firstName, lastName, phoneNumber, homeAddress);
        assertThat(contactList.size(), is(equalTo(1)));
        service.delete(contactID);
        assertThat(contactList.size(), is(equalTo(0)));
    }

    @Test
    public void canEditFirstName() throws Exception {
        contactList = service.add(contactID, firstName, lastName, phoneNumber, homeAddress);
        service.update(contactID, "firstName", "Greg");
        assertThat(contactList.get(0).getFirstName(), is(equalTo("Greg")));
    }

    @Test
    public void canEditLastName() throws Exception {
        contactList = service.add(contactID, firstName, lastName, phoneNumber, homeAddress);
        service.update(contactID, "lastName", "Button");
        assertThat(contactList.get(0).getLastName(), is(equalTo("Button")));
    }

    @Test
    public void canEditPhoneNumber() throws Exception {
        contactList = service.add(contactID, firstName, lastName, phoneNumber, homeAddress);
        service.update(contactID, "phoneNumber", "7163339999");
        assertThat(contactList.get(0).getPhoneNumber(), is(equalTo("7163339999")));
    }

    @Test
    public void canEditHomeAddress() throws Exception {
        contactList = service.add(contactID, firstName, lastName, phoneNumber, homeAddress);
        service.update(contactID, "homeAddress", "13 Shes Fine St");
        assertThat(contactList.get(0).getHomeAddress(), is(equalTo("13 Shes Fine St")));
    }

    @Test
    public void cannotUpdateRestrictedFields() throws Exception {
        contactList = service.add(contactID, firstName, lastName, phoneNumber, homeAddress);
        boolean exceptionThrown = false;
        try {
            service.update(contactID, "contactID", "gloopy");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("The field contactID cannot be updated.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void cannotDuplicateContactID() throws Exception {
        contactList = service.add(contactID, firstName, lastName, phoneNumber, homeAddress);
        boolean exceptionThrown = false;
        try {
            contactList = service.add(contactID, firstName, lastName, phoneNumber, homeAddress);
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("ContactID cannot be updated.")));
        }
        assertThat(contactList.size(), is(equalTo(1)));
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void doesNothingIfNoIDMatchInDelete() throws Exception {
        contactList = service.add(contactID, firstName, lastName, phoneNumber, homeAddress);
        assertThat(contactList.size(), is(equalTo(1)));
        service.delete("notexist");
        assertThat(contactList.size(), is(equalTo(1)));
    }
}
