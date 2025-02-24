package test;
import Task.Task;
import Task.TaskService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService(); // initialize a new TaskService before each test
    }

    @Test
    public void testAddTask() {
        Task task = new Task("0001", "Task 1", "Description for Task 1");
        taskService.addTask(task);

        // verify the task was added
        Task retrievedTask = taskService.getTaskByID("0001");
        assertEquals("0001", retrievedTask.getTaskID());
        assertEquals("Task 1", retrievedTask.getTaskName());
        assertEquals("Description for Task 1", retrievedTask.getTaskDescription());
    }

    @Test
    public void testAddTaskWithDuplicateID() {
        Task task1 = new Task("0001", "Task 1", "Description for Task 1");
        taskService.addTask(task1);

        Task task2 = new Task("0001", "Task 2", "Description for Task 2");
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task2);
        });
    }

    @Test
    public void testGetTaskByID() {
        Task task = new Task("0001", "Task 1", "Description for Task 1");
        taskService.addTask(task);

        Task retrievedTask = taskService.getTaskByID("0001");
        assertNotNull(retrievedTask);
        assertEquals("0001", retrievedTask.getTaskID());
    }

    @Test
    public void testGetTaskByInvalidID() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.getTaskByID("9999");
        });
    }

    @Test
    public void testUpdateTaskName() {
        Task task = new Task("0001", "Task 1", "Description for Task 1");
        taskService.addTask(task);

        taskService.updateTaskName("0001", "Updated Task Name");

        Task updatedTask = taskService.getTaskByID("0001");
        assertEquals("Updated Task Name", updatedTask.getTaskName());
    }

    @Test
    public void testUpdateTaskNameWithInvalidName() {
        Task task = new Task("0001", "Task 1", "Description for Task 1");
        taskService.addTask(task);

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("0001", null); 
        });

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("0001", "This name is way too long and should fail"); // Name too long
        });
    }

    @Test
    public void testUpdateTaskDescription() {
        Task task = new Task("0001", "Task 1", "Description for Task 1");
        taskService.addTask(task);

        taskService.updateTaskDescription("0001", "Updated Task Description");

        Task updatedTask = taskService.getTaskByID("0001");
        assertEquals("Updated Task Description", updatedTask.getTaskDescription());
    }

    @Test
    public void testUpdateTaskDescriptionWithInvalidDescription() {
        Task task = new Task("0001", "Task 1", "Description for Task 1");
        taskService.addTask(task);

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("0001", null); 
        });

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("0001", "This description is way too long and should fail because it exceeds the maximum length of 50 characters.......................................");
        });
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("0001", "Task 1", "Description for Task 1");
        taskService.addTask(task);

        taskService.deleteTask("0001");

        // verify the task was deleted
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.getTaskByID("0001");
        });
    }

    @Test
    public void testDeleteTaskWithInvalidID() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("9999");
        });
    }
}