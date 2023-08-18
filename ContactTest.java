/* 
Emily Nagorski
CS 320 - X6131
Project 1
*/

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactTest {
    
    Contact contact = new Contact();

    @Test
    public void contactIdCanBeSetAndRetrieved() throws Exception {
        contact.setContactID("abcd12345");
        assertThat(contact.getContactID(), is(equalTo("abcd12345")));
    }

    @Test
    public void contactIdIsNotNull() throws Exception {
        boolean exceptionThrown = false;
        try {
            contact.setContactID(null);
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Contact ID is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void contactIdIsNotEmpty() throws Exception {
        boolean exceptionThrown = false;
        try {
            contact.setContactID("");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Contact ID is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void contactIdIsNotGreaterThanTenCharacters() throws Exception {
        boolean exceptionThrown = false;
        try {
            contact.setContactID("goggy666000");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Contact ID cannot be longer than 10 characters.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void firstNameCanBeSetAndRetrieved() throws Exception {
        contact.setFirstName("Pierogi");
        assertThat(contact.getFirstName(), is(equalTo("Pierogi")));
    }

    @Test
    public void firstNameIsNotNull() throws Exception {
        boolean exceptionThrown = false;
        try {
            contact.setFirstName(null);
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("First name is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void firstNameIsNotEmpty() throws Exception {
        boolean exceptionThrown = false;
        try {
            contact.setFirstName("");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("First name is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void firstNameIsNotGreaterThanTenCharacters() throws Exception {
        boolean exceptionThrown = false;
        try {
            contact.setFirstName("Taylorswift");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("First name cannot be longer than 10 characters.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void lastNameCanBeSetAndRetrieved() throws Exception {
        contact.setLastName("Nags");
        assertThat(contact.getLastName(), is(equalTo("Nags")));
    }

    @Test
    public void lastNameIsNotNull() throws Exception {
        boolean exceptionThrown = false;
        try {
            contact.setLastName(null);
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Last name is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void LastNameIsNotEmpty() throws Exception {
        boolean exceptionThrown = false;
        try {
            contact.setLastName("");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Last name is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void lastNameIsNotGreaterThanTenCharacters() throws Exception {
        boolean exceptionThrown = false;
        try {
            contact.setLastName("Karmaisacat");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Last name cannot be longer than 10 characters.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void phoneNumberCanBeSetAndRetrieved() throws Exception {
        contact.setPhoneNumber("3098881234");
        assertThat(contact.getPhoneNumber(), is(equalTo("3098881234")));
    }

    @Test
    public void phoneNumberIsNotNull() throws Exception {
        boolean exceptionThrown = false;
        try {
            contact.setPhoneNumber(null);
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Phone number is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void phoneNumberIsNotEmpty() throws Exception {
        boolean exceptionThrown = false;
        try {
            contact.setPhoneNumber("");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Phone number is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void phoneNumberIsExactlyTenCharacters() throws Exception {
        boolean exceptionThrown = false;
        try {
            contact.setPhoneNumber("13");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Phone number requires exactly 10 digits.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void homeAddressCanBeSetAndRetrieved() throws Exception {
        contact.setHomeAddress("271 Buffalo Terr");
        assertThat(contact.getHomeAddress(), is(equalTo("271 Buffalo Terr")));
    }

    @Test
    public void homeAddressIsNotNull() throws Exception {
        boolean exceptionThrown = false;
        try {
            contact.setHomeAddress(null);
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Home address is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void homeAddressIsNotEmpty() throws Exception {
        boolean exceptionThrown = false;
        try {
            contact.setHomeAddress("");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Home address is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void homeAddressIsNotGreaterThanThirtyCharacters() throws Exception {
        boolean exceptionThrown = false;
        try {
            contact.setHomeAddress("1728 Pog and Gog Way, Williamsville NY");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Home address cannot be longer than 10 characters.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }
}
