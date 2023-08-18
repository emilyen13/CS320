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

public class TaskServiceTest {
    
    TaskService task = new TaskService();
    String taskID = "Pierogi13";
    String fullName = "Emily Nags";
    String reqDescription = "Sos please someone help me - rihanna";
    List<Task> taskList = new ArrayList<Task>();

    @Test
    public void canAddTaskToList() throws Exception {
        taskList = task.add(taskID, fullName, reqDescription);
        assertThat(taskList.size(), is(equalTo(1)));
    }

    @Test
    public void canDeleteTaskFromList() throws Exception {
        taskList = task.add(taskID, fullName, reqDescription);
        assertThat(taskList.size(), is(equalTo(1)));
        task.delete(taskID);
        assertThat(taskList.size(), is(equalTo(0)));
    }

    @Test
    public void canEditFullName() throws Exception {
        taskList = task.add(taskID, fullName, reqDescription);
        task.update(taskID, "fullName", "Greg Schwo");
        assertThat(taskList.get(0).getFullName(), is(equalTo("Greg Schwo")));
    }

    @Test
    public void canEditReqDescription() throws Exception {
        taskList = task.add(taskID, fullName, reqDescription);
        task.update(taskID, "reqDescription", "Oh this is an S.O.S. Don't wanna second guess.");
        assertThat(taskList.get(0).getReqDescription(), is(equalTo("Oh this is an S.O.S. Don't wanna second guess.")));
    }

    @Test
    public void cannotUpdateRestrictedFields() throws Exception {
        taskList = task.add(taskID, fullName, reqDescription);
        boolean exceptionThrown = false;
        try {
            task.update(taskID, "taskID", "gloopy");
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("The field taskID cannot be updated.")));
        }
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void cannotDuplicateTaskID() throws Exception {
        taskList = task.add(taskID, fullName, reqDescription);
        boolean exceptionThrown = false;
        try {
            taskList = task.add(taskID, fullName, reqDescription);
        } catch (Exception e) {
            exceptionThrown = true;
            assertThat(e.getMessage(), is(equalTo("TaskID cannot be updated.")));
        }
        assertThat(taskList.size(), is(equalTo(1)));
        assertThat(exceptionThrown, is(equalTo(true)));
    }

    @Test
    public void doesNothingIfNoIDMatchInDelete() throws Exception {
        taskList = task.add(taskID, fullName, reqDescription);
        assertThat(taskList.size(), is(equalTo(1)));
        task.delete("notexist");
        assertThat(taskList.size(), is(equalTo(1)));
    }
}
