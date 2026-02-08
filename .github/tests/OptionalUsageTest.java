package edu.touro.las.mcon364.taskmanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionalUsageTest {

    @Test
    void missingTaskMustThrowExceptionNotReturnNull() {
        TaskRegistry registry = new TaskRegistry();

        Exception ex = assertThrows(
                RuntimeException.class,
                () -> registry.get("nonexistent"),
                "Looking up a missing task must throw an exception, not return null"
        );

        assertNotNull(ex.getMessage(), "Exception should have a meaningful message");
    }
}
