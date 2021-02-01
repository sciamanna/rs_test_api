package com.sciamanna.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @DisplayName("Tesg get task description")
    @Test
    public void testTaskDescription() {
        Task t = new Task("123", "test task", false);
        assertEquals("test task", t.getDescription(), "Task desc incorrect");

    }
}
