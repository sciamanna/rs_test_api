package com.sciamanna.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @DisplayName("Test get task description")
    @Test
    public void testTaskDescription() {
        Task t = new Task("123", "test task", false);
        assertEquals("test task", t.getDescription(), "Task desc incorrect");

    }
    @DisplayName("Test complete is set by default")
    @Test
    public void testDefaultCompleteStatus() {
        Task t = new Task();
        assertFalse(t.isCompleted(),"Task status was not false by defaut");
    }
}
