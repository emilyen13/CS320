//*********************************************************************
// File: Contact.java

// Name: Emily Nagorski

// Section: CS-320-X6131

// Description: contact class sets each field with the provided
// information, and verfies that input is within defined parameters
//*********************************************************************

public class Contact {

    private String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String homeAddress;

    public Contact() {
    }

    //constructor for setting all fields
    public Contact(String contactID, String firstName,
    String lastName, String phoneNumber, String homeAddress) throws Exception {
        setContactID(contactID);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setHomeAddress(homeAddress);
    }

    public String getContactID() {
        return contactID;
    }

    //setter for Contact ID field, with error handling for number of characters & blank field
    public void setContactID(String contactID) throws Exception {
        if (contactID == null || contactID.isBlank()){
            throw new Exception("Contact ID is a required field.");
        } else if (contactID.length() > 10) {
            throw new Exception("Contact ID cannot be longer than 10 characters.");
        } else {
            this.contactID = contactID; 
        } 
    }

    public String getFirstName() {
        return firstName;
    }

    //setter for first name, with error handling for number of characters & blank field
    public void setFirstName(String firstName) throws Exception {
        if (firstName == null || firstName.isBlank()){
            throw new Exception("First name is a required field.");
        } else if (firstName.length() > 10) {
            throw new Exception("First name cannot be longer than 10 characters.");
        } else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    //setter for last name, with error handling for number of characters & blank field
    public void setLastName(String lastName) throws Exception {
        if (lastName == null || lastName.isBlank()){
            throw new Exception("Last name is a required field.");
        } else if (lastName.length() > 10) {
            throw new Exception("Last name cannot be longer than 10 characters.");
        } else {
            this.lastName = lastName;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //setter for phone number, with error handling for number of characters & blank field
    public void setPhoneNumber(String phoneNumber) throws Exception {
        if (phoneNumber == null || phoneNumber.isBlank()){
            throw new Exception("Phone number is a required field.");
        } else if (phoneNumber.length() != 10) {
            throw new Exception("Phone number requires exactly 10 digits.");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    //setter for home address, with error handling for number of characters & blank field
    public void setHomeAddress(String homeAddress) throws Exception {
        if (homeAddress == null || homeAddress.isBlank()){
            throw new Exception("Home address is a required field.");
        } else if (homeAddress.length() > 30) {
            throw new Exception("Home address cannot be longer than 10 characters.");
        } else {
            this.homeAddress = homeAddress;
        }
    }
}
