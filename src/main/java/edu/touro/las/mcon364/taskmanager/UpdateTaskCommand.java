package edu.touro.las.mcon364.taskmanager;

public final class UpdateTaskCommand implements Command {
    private final TaskRegistry registry;
    private final String taskName;
    private final Priority newPriority;

    public UpdateTaskCommand(TaskRegistry registry, String taskName, Priority newPriority) {
        this.registry = registry;
        this.taskName = taskName;
        this.newPriority = newPriority;
    }

    public void execute() {
        // NOTE: This demonstrates old-style null checking
        // Students should refactor to use Optional and custom exceptions
        // Currently just silently fails - should throw a custom exception!
        Task existing = registry.get(taskName)
                .orElseThrow(() -> new TaskNotFoundException("Task '" + taskName + "' not found"));

        // Create a new task with updated priority (tasks are immutable)
        Task updated = new Task(existing.name(), newPriority);
        registry.add(updated);
    }
}
