package edu.touro.las.mcon364.taskmanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatternMatchingDispatchTest {

    @Test
    void runMustDispatchAddCommand() {
        TaskRegistry registry = new TaskRegistry();
        TaskManager manager = new TaskManager(registry);

        Command add = new AddTaskCommand(registry, new Task("X", Priority.HIGH));
        assertDoesNotThrow(() -> manager.run(add));
    }
}
