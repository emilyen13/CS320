//*********************************************************************
// File: AppointmentService.java

// Name: Emily Nagorski

// Section: CS-320-X6131

// Description: appointment service creates and houses a list of 
// appointments scheduled by clients, and allows them to add
// edit and remove appointments
//*********************************************************************

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class AppointmentService{

    //establishing list to add appointments to
    private List<Appointment> apptList = new ArrayList<Appointment>();

    //adding appointment information to list
    public List<Appointment> add(String apptID, Date apptDate, String apptDescription) throws Exception {
 
        //check if appointment ID exists within list to resolve potential duplicate IDs
        if (apptList.size() > 0) {
            for (Appointment appointment : apptList) {
                if(appointment.getApptID() == apptID) {
                    throw new Exception("ApptID cannot be updated.");
                }
            }
        }
        //creating appointment from provided information
        Appointment newAppt = new Appointment(apptID, apptDate, apptDescription);
        apptList.add(newAppt);
 
        return apptList;
    }
 
    //delete entry if ID matches or exists within list
    public void delete(String apptID) {
        apptList.removeIf(appointment -> (appointment.getApptID() == apptID));
    }
 
    public void update(String apptID, String field, String value) throws Exception {
 
         //switch case for updating specified fields
        for (Appointment appointment : apptList) {
            if(appointment.getApptID() == apptID) {
                switch (field) {
                    case "apptDate":
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date apptDate = formatter.parse(value);
                        appointment.setApptDate(apptDate);
                        break;
                    case "apptDescription":
                        appointment.setApptDescription(value);
                        break;
                    default:
                        throw new Exception("The field " + field + " cannot be updated.");
                }
            }
        }
    }
}
