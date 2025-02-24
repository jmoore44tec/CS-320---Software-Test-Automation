package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Task.Task;

class TaskTest {

    @Test
    public void testTaskCreation() {
        Task tasks = new Task("0001", "Java Assignment", "Create a Task service along with appropriate tests");
        assertEquals("0001", tasks.getTaskID());
        assertEquals("Java Assignment", tasks.getTaskName());
        assertEquals("Create a Task service along with appropriate tests", tasks.getTaskDescription());
    }

    @Test
    public void testNullIDValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Java Project", "Create a Task service along with appropriate tests");
        });
    }

    @Test
    public void testInvalidTaskName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("0001", null, "Valid description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("0001", "This task name is way too long and should fail", "Valid description");
        });
    }

    @Test
    public void testInvalidTaskDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("0001", "Valid name", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("0001", "Valid name", "This description is way too long and should fail because it exceeds the maximum allowed length of 50 characters");
        });
    }

    @Test
    public void testInvalidTaskID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Valid name", "Valid description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("This ID is too long", "Valid name", "Valid description");
        });
    }
}