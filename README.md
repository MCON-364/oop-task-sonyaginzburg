# MCON 364 – Modern Java OOP Refactoring

This GitHub Classroom assignment focuses on refactoring an existing Java OOP system
using **modern Java features (Java 8–21)**.

---

## Part 1: In-Class Exercise (45 minutes)

You are provided with an existing task-management system that uses object-oriented design and Java collections. Your goal is to refactor this system using modern Java features **without changing its behavior**.

### Step 1: Convert a Data Class to a Record
- Replace the existing `Task` class with a `record`
- Remove unnecessary boilerplate
- Ensure the program still compiles and runs

### Step 2: Seal the Command Hierarchy
- Make the `Command` interface sealed
- Explicitly list the permitted implementations
- Discuss how this improves safety and clarity

### Step 3: Improve Exception Handling
- Replace null checks with `Optional`
- Use `orElseThrow` where appropriate
- Create meaningful domain-specific exceptions

### Step 4: Run and Reflect
- Run the demo program
- Verify behavior is unchanged
- Discuss what became simpler or safer

---

## Part 2: Homework Assignment

### Part A: Extend the Command System
- Add a new command (for example, changing task priority)
- Ensure it fits into the sealed hierarchy

### Part B: Exception Design
- Add at least one new custom exception
- Use `Optional` instead of returning null

### Part C: Collections Practice
Add a method that groups tasks by priority:
```java
Map<Priority, List<Task>> getTasksByPriority();
```
This method should use collections and modern Java features cleanly and safely.

---

## Submission Requirements
- All tests must pass
- Code must compile without errors
- Behavior of the original system must be preserved
