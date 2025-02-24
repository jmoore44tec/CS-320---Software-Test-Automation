package Task;
import java.util.*;

public class TaskService {
    private final HashMap<String, Task> tasks;

    public TaskService() {
        this.tasks = new HashMap<>();
    }

    public Task getTaskByID(String taskID) {
        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        return tasks.get(taskID);
    }

    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        tasks.put(task.getTaskID(), task);
    }

    public void updateTaskName(String taskID, String taskName) {
        Task task = getTaskByID(taskID);
        if (taskName == null || taskName.length() > 20) {
            throw new IllegalArgumentException("Invalid Task Name, must contain 1-20 characters.");
        }
        Task updatedTask = new Task(task.getTaskID(), taskName, task.getTaskDescription());
        tasks.put(taskID, updatedTask);
    }

    public void updateTaskDescription(String taskID, String taskDescription) {
        Task task = getTaskByID(taskID);
        if (taskDescription == null || taskDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid Task Description, must contain 1-50 characters.");
        }
        Task updatedTask = new Task(task.getTaskID(), task.getTaskName(), taskDescription);
        tasks.put(taskID, updatedTask);
    }

    public void deleteTask(String taskID) {
        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        tasks.remove(taskID);
    }
}
