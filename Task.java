package Task;

public class Task {
	private final String taskID;
	private String taskName;
	private String taskDescription;
	
	public Task(String taskID, String taskName, String taskDescription) {
		if(taskID == null || taskID.length()>10) {
			throw new IllegalArgumentException("Invalid Task ID, must be 1-10 characters in length.");
		}
		if (taskName == null || taskName.length()>20) {
			throw new IllegalArgumentException("Invalid Task Name, must be 1-20 characters in length.");
		}
		if(taskDescription == null || taskDescription.length()>50) {
			throw new IllegalArgumentException("Invalid Description, must be 1-50 characters in length.");
		}
		
		this.taskID = taskID;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
	}
	
	public String getTaskID() {
		return taskID;
	}
	public String getTaskName() {
		return taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}

}
