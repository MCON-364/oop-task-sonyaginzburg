package edu.touro.las.mcon364.taskmanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskRecordTest {

    @Test
    void taskMustBeRecord() {
        assertTrue(
                Task.class.isRecord(),
                "Task must be implemented as a record"
        );
    }

    @Test
    void taskIsImmutable() {
        assertEquals(
                2,
                Task.class.getRecordComponents().length,
                "Task record should have exactly two components"
        );
    }
}
