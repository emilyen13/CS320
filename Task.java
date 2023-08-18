//*********************************************************************
// File: Task.java

// Name: Emily Nagorski

// Section: CS-320-X6131

// Description: task class sets each field with the provided
// information, and verfies that input is within defined parameters
//*********************************************************************

public class Task {
    
    private String taskID;
    private String fullName;
    private String reqDescription;

    public Task() {
    }

    //constructor for setting all fields
    public Task(String taskID, String fullName, String reqDescription) throws Exception {
        setTaskID(taskID);
        setFullName(fullName);
        setReqDescription(reqDescription);
    }

    public String getTaskID() {
        return taskID;
    }

    //setter for task ID field, with error handling for number of characters & blank field
    public void setTaskID(String taskID) throws Exception {
        if (taskID == null || taskID.isBlank()) {
            throw new Exception("Task ID is a required field.");
        } else if (taskID.length() > 10) {
            throw new Exception("Task ID cannot be longer than 10 characters");
        } else {
            this.taskID = taskID;
        } 
    }

    public String getFullName() {
        return fullName;
    }

    //setter for full name, with error handling for number of characters & blank field
    public void setFullName(String fullName) throws Exception {
        if (fullName == null || fullName.isBlank()){
            throw new Exception("Full name is a required field.");
        } else if (fullName.length() > 20) {
            throw new Exception("Full name cannot be longer than 20 characters.");
        } else {
            this.fullName = fullName;
        }
    }

    public String getReqDescription() {
        return reqDescription;
    }

    //setter for description, with error handling for number of characters & blank field
    public void setReqDescription(String reqDescription) throws Exception {
        if (reqDescription == null || reqDescription.isBlank()){
            throw new Exception("Task description is required");
        } else if (reqDescription.length() > 50) {
            throw new Exception("Description cannot be longer than 50 characters.");
        } else {
            this.reqDescription = reqDescription;
        }
    }
}

