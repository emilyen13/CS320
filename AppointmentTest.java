/* 
Emily Nagorski
CS 320 - X6131
Project 1
*/


import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppointmentTest {
    
    Appointment appt = new Appointment();
    private Date apptDate;


    @Test
    public void apptIdCanBeSetAndRetrieved() throws Exception {
        appt.setApptID("horse13");
        assertThat(appt.getApptID(), is(equalTo("horse13")));
    }

    @Test
    public void apptIdIsNotNull() throws Exception {
        boolean exceptionThrown = false;
        try {
            appt.setApptID(null);
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Appointment ID is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void apptIdIsNotEmpty() throws Exception {
        boolean exceptionThrown = false;
        try {
            appt.setApptID("");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Appointment ID is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void apptIdIsNotGreaterThanTenCharacters() throws Exception {
        boolean exceptionThrown = false;
        try {
            appt.setApptID("sheseverythinghesjustken");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Appointment ID cannot be longer than 10 characters")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void apptDateCanBeSetAndRetrieved() throws Exception {
        try {
			apptDate = new SimpleDateFormat("yyyy-MM-dd").parse("2025-08-13");
		} catch (ParseException ex) {
			System.out.println(ex.getMessage());
		}
        appt.setApptDate(apptDate);
        assertThat(appt.getApptDate().toString(), is(equalTo("Wed Aug 13 00:00:00 CDT 2025")));
    }

    @Test
    public void apptDateIsNotNull() throws Exception {
        boolean exceptionThrown = false;
        try {
            appt.setApptDate(null);
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Date is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void apptDateCannotBeInThePast() throws Exception {
        try {
			apptDate = new SimpleDateFormat("yyyy-MM-dd").parse("2023-07-29");
		} catch (ParseException ex) {
			System.out.println(ex.getMessage());
		}
        boolean exceptionThrown = false;
        try {
            appt.setApptDate(apptDate);
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Appointment must be scheduled for a future date.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void apptDescriptionCanBeSetAndRetrieved() throws Exception {
        appt.setApptDescription("Appointment Description");
        assertThat(appt.getApptDescription(), is(equalTo("Appointment Description")));
    }

    @Test
    public void apptDescriptionIsNotNull() throws Exception {
        boolean exceptionThrown = false;
        try {
            appt.setApptDescription(null);
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Appointment description is required")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void apptDescriptionIsNotEmpty() throws Exception {
        boolean exceptionThrown = false;
        try {
            appt.setApptDescription("");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Appointment description is required")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void apptDescriptionIsNotGreaterThanFiftyCharacters() throws Exception {
        boolean exceptionThrown = false;
        try {
            appt.setApptDescription("Karma is the breeze in my hair on the weekend,Karma's a relaxing thought. Aren't you envious that for you it's not? Sweet like honey, karma is a cat, Purring in my lap 'cause it loves me. Flexing like a goddamn acrobat. Me and karma vibe like that");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Description cannot be longer than 50 characters.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }
}
