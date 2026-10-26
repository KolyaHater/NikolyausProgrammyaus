package edu.course.lab02;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;
public class TaskTest {

    @Test 
    public void testIsCompleted() {
        ProjectTask task = new ProjectTask("1", "Test Task", TaskStatus.NEW, 5);
        assertFalse(task.isCompleted());

        task.changeStatus(TaskStatus.DONE);
        assertTrue(task.isCompleted());
    }

    @Test
    public void testAddEstimatedHours() {
        ProjectTask task = new ProjectTask("1", "Test Task", TaskStatus.NEW, 5);
        int newEstimatedHours = task.addEstimatedHours(3);
        assertEquals(8, newEstimatedHours);
    }

    @Test
    public void testAddEstimatedHoursWithNegativeValue() {
        ProjectTask task = new ProjectTask("1", "Test Task", TaskStatus.NEW, 5);
        assertThrows(IllegalArgumentException.class, () -> task.addEstimatedHours(-3));
    }

    @Test 
    public void invalidTaskCreation() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("", "Test Task", TaskStatus.NEW, 5));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("1", "", TaskStatus.NEW, 5));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("1", "Test Task", TaskStatus.NEW, -5));
    }

}
