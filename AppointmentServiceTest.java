/* 
Emily Nagorski
CS 320 - X6131
Project 1
*/


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AppointmentServiceTest {
    
    private Date apptDate;
    
    AppointmentService appointment = new AppointmentService();
    String apptID = "Pierogi13";
    String apptDescription = "Sos please someone help me - rihanna";
    List<Appointment> apptList = new ArrayList<Appointment>();

    @Test
    public void canAddApptToList() throws Exception {
        try {
			apptDate = new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01");
		} catch (ParseException ex) {
			System.out.println(ex.getMessage());
		}
        apptList = appointment.add(apptID, apptDate, apptDescription);
        assertThat(apptList.size(), is(equalTo(1)));
    }

    @Test
    public void canDeleteApptFromList() throws Exception {
        try {
			apptDate = new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01");
		} catch (ParseException ex) {
			System.out.println(ex.getMessage());
		}
        apptList = appointment.add(apptID, apptDate, apptDescription);
        assertThat(apptList.size(), is(equalTo(1)));
        appointment.delete(apptID);
        assertThat(apptList.size(), is(equalTo(0)));
    }

    @Test
    public void canEditApptDate() throws Exception {
        try {
			apptDate = new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01");
		} catch (ParseException ex) {
			System.out.println(ex.getMessage());
		}
        apptList = appointment.add(apptID, apptDate, apptDescription);
        appointment.update(apptID, "apptDate", "2024-02-13");
        assertThat(apptList.get(0).getApptDate().toString(), is(equalTo("Tue Feb 13 00:00:00 CST 2024")));
    }

    @Test
    public void canEditApptDescription() throws Exception {
        try {
			apptDate = new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01");
		} catch (ParseException ex) {
			System.out.println(ex.getMessage());
		}
        apptList = appointment.add(apptID, apptDate, apptDescription);
        appointment.update(apptID, "apptDescription", "Do you have your rollerblades?");
        assertThat(apptList.get(0).getApptDescription(), is(equalTo("Do you have your rollerblades?")));
    }

    @Test
    public void cannotUpdateRestrictedFields() throws Exception {
        try {
			apptDate = new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01");
		} catch (ParseException ex) {
			System.out.println(ex.getMessage());
		}
        apptList = appointment.add(apptID, apptDate, apptDescription);
        boolean exceptionThrown = false;
        try {
            appointment.update(apptID, "apptID", "gloopy");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("The field apptID cannot be updated.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void cannotDuplicateApptID() throws Exception {
        try {
			apptDate = new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01");
		} catch (ParseException ex) {
			System.out.println(ex.getMessage());
		}
        apptList = appointment.add(apptID, apptDate, apptDescription);
        boolean exceptionThrown = false;
        try {
            apptList = appointment.add(apptID, apptDate, apptDescription);
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("ApptID cannot be updated.")));
        }
        assertThat(apptList.size(), is(equalTo(1)));
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void doesNothingIfNoIDMatchInDelete() throws Exception {
        try {
			apptDate = new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01");
		} catch (ParseException ex) {
			System.out.println(ex.getMessage());
		}
        apptList = appointment.add(apptID, apptDate, apptDescription);
        assertThat(apptList.size(), is(equalTo(1)));
        appointment.delete("notexist");
        assertThat(apptList.size(), is(equalTo(1)));
    }
}
