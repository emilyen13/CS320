//*********************************************************************
// File: ContactService.java

// Name: Emily Nagorski

// Section: CS-320-X6131

// Description: task service creates and houses a list of 
// tasks created by clients, and allows them to add
// edit and remove tasks
//*********************************************************************

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    
    //establishing list to add tasks to
    private List<Task> taskList = new ArrayList<Task>();

    //adding task information to list
    public List<Task> add(String taskID, String fullName, String reqDescription) throws Exception {

        //check if task ID exists within list to resolve potential duplicate IDs
        if (taskList.size() > 0) {
            for (Task task : taskList) {
                if(task.getTaskID() == taskID) {
                    throw new Exception("TaskID cannot be updated.");
                }
            }
        }
        //creating task from provided information
        Task newTask = new Task(taskID, fullName, reqDescription);
        taskList.add(newTask);

        return taskList;
    }

    //delete entry if ID matches or exists within list
    public void delete(String taskID) {
        taskList.removeIf(task -> (task.getTaskID() == taskID));
    }

    public void update(String taskID, String field, String value) throws Exception {

        //switch case for updating specified fields
        for (Task task : taskList) {
            if(task.getTaskID() == taskID) {
                switch (field) {
                    case "fullName":
                        task.setFullName(value);
                        break;
                    case "reqDescription":
                        task.setReqDescription(value);
                        break;
                    default:
                        throw new Exception("The field " + field + " cannot be updated.");
                }
            }
        }
    }

}
