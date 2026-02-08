package edu.touro.las.mcon364.taskmanager;

public class TaskManager {

    private final TaskRegistry registry;

    public TaskManager(TaskRegistry registry) {
        this.registry = registry;
    }

    // TODO: Students must refactor this using pattern-matching switch
    // Current implementation uses old-style instanceof checks
    public void run(Command command) {
        if (command instanceof AddTaskCommand) {
            command.execute();
        } else if (command instanceof RemoveTaskCommand) {
            command.execute();
        } else if (command instanceof UpdateTaskCommand) {
            command.execute();
        } else {
            throw new IllegalArgumentException("Unknown command type");
        }
    }
}
