/* 
Emily Nagorski
CS 320 - X6131
Project 1
*/

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TaskTest {
    
    Task task = new Task();

    @Test
    public void taskIdCanBeSetAndRetrieved() throws Exception {
        task.setTaskID("abcd12345");
        assertThat(task.getTaskID(), is(equalTo("abcd12345")));
    }

    @Test
    public void taskIdIsNotNull() throws Exception {
        boolean exceptionThrown = false;
        try {
            task.setTaskID(null);
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Task ID is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void taskIdIsNotEmpty() throws Exception {
        boolean exceptionThrown = false;
        try {
            task.setTaskID("");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Task ID is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void taskIdIsNotGreaterThanTenCharacters() throws Exception {
        boolean exceptionThrown = false;
        try {
            task.setTaskID("goggy666000");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Task ID cannot be longer than 10 characters")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void fullNameCanBeSetAndRetrieved() throws Exception {
        task.setFullName("Pierogi");
        assertThat(task.getFullName(), is(equalTo("Pierogi")));
    }

    @Test
    public void fullNameIsNotNull() throws Exception {
        boolean exceptionThrown = false;
        try {
            task.setFullName(null);
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Full name is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void fullNameIsNotEmpty() throws Exception {
        boolean exceptionThrown = false;
        try {
            task.setFullName("");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Full name is a required field.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void fullNameIsNotGreaterThanTwentyCharacters() throws Exception {
        boolean exceptionThrown = false;
        try {
            task.setFullName("Taylor mf-ing Alison Swift");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Full name cannot be longer than 20 characters.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void reqDescriptionCanBeSetAndRetrieved() throws Exception {
        task.setReqDescription("Hey this is a description of a task");
        assertThat(task.getReqDescription(), is(equalTo("Hey this is a description of a task")));
    }

    @Test
    public void reqDescriptionIsNotNull() throws Exception {
        boolean exceptionThrown = false;
        try {
            task.setReqDescription(null);
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Task description is required")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void reqDescriptionIsNotEmpty() throws Exception {
        boolean exceptionThrown = false;
        try {
            task.setReqDescription("");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Task description is required")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void reqDescriptionIsNotGreaterThanFiftyCharacters() throws Exception {
        boolean exceptionThrown = false;
        try {
            task.setReqDescription("Karma is the breeze in my hair on the weekend,Karma's a relaxing thought. Aren't you envious that for you it's not? Sweet like honey, karma is a cat, Purring in my lap 'cause it loves me. Flexing like a goddamn acrobat. Me and karma vibe like that");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("Description cannot be longer than 50 characters.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }
}
