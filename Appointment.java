//*********************************************************************
// File: Appointment.java

// Name: Emily Nagorski

// Section: CS-320-X6131

// Description: appointment class sets each field with the provided
// information, and verfies that input is within defined parameters
//*********************************************************************


import java.util.Date;

public class Appointment {

    private String apptID;
    private Date apptDate;
    private String apptDescription;

    public Appointment() {
    }

    //constructor for setting all fields
    public Appointment(String apptID, Date apptDate, String apptDescription) throws Exception {
        setApptID(apptID);
        setApptDate(apptDate);
        setApptDescription(apptDescription);
    }

    public String getApptID() {
        return apptID;
    }

    //setter for task ID field, with error handling for number of characters & blank field
    public void setApptID(String apptID) throws Exception {
        if (apptID == null || apptID.isBlank()) {
            throw new Exception("Appointment ID is a required field.");
        } else if (apptID.length() > 10) {
            throw new Exception("Appointment ID cannot be longer than 10 characters");
        } else {
            this.apptID = apptID;
        } 
    }

    public Date getApptDate() {
        return apptDate;
    }

    //setter for full name, with error handling for number of characters & blank field
    public void setApptDate(Date apptDate) throws Exception {
        if (apptDate == null){
            throw new Exception("Date is a required field.");
        } else if (apptDate.before(new Date())) {
            throw new Exception("Appointment must be scheduled for a future date.");
        } else {
            this.apptDate = apptDate;
        }
    }

    public String getApptDescription() {
        return apptDescription;
    }

    //setter for description, with error handling for number of characters & blank field
    public void setApptDescription(String apptDescription) throws Exception {
        if (apptDescription == null || apptDescription.isBlank()){
            throw new Exception("Appointment description is required");
        } else if (apptDescription.length() > 50) {
            throw new Exception("Description cannot be longer than 50 characters.");
        } else {
            this.apptDescription = apptDescription;
        }
    }
}