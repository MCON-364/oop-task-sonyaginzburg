# Test Suite for Task Management System

This test suite helps you verify that your refactoring preserves the original behavior of the system.

## Test Files Overview

### 1. **DemoMainTest.java** (22 tests)
Tests for the demonstration methods in `DemoMain`:
- `testDemonstrateAddingTasks()` - Verifies 5 tasks are added with correct priorities
- `testDemonstrateRetrievingTask()` - Tests retrieving existing tasks
- `testDemonstrateRetrievingNonExistentTask()` - Tests null return for missing tasks
- `testDemonstrateUpdatingTask()` - Verifies priority updates work correctly
- `testDemonstrateUpdatingNonExistentTask()` - Tests update behavior on missing tasks
- `testDemonstrateRemovingTask()` - Verifies task removal
- `testDemonstrateNullReturn()` - Tests null return pattern (to be refactored to Optional)
- `testFullDemoRun()` - Ensures the complete demo runs without exceptions
- Additional tests for Task equality, Command pattern, and TaskManager integration

### 2. **TaskTest.java** (7 tests)
Tests for the `Task` class:
- Task creation with name and priority
- Equality based on name and priority
- HashCode consistency
- All priority levels (LOW, MEDIUM, HIGH)

**Important**: After converting `Task` to a record, all these tests should still pass!

### 3. **TaskRegistryTest.java** (7 tests)
Tests for the `TaskRegistry` class:
- Adding and retrieving tasks
- Task replacement when adding duplicate names
- Removing tasks
- Getting all tasks
- Null returns for non-existent tasks

**Refactoring Note**: When you add Optional support, you'll need to update tests that expect null.

### 4. **CommandTest.java** (10 tests)
Tests for all Command implementations:
- `AddTaskCommand` functionality
- `RemoveTaskCommand` functionality
- `UpdateTaskCommand` functionality
- Edge cases (non-existent tasks, priority changes)

**Important**: After sealing the Command interface, these tests verify the permitted implementations work correctly.

### 5. **TaskManagerTest.java** (5 tests)
Tests for the `TaskManager` class:
- Executing different command types via `run()`
- Sequential command execution
- Shared registry instance

**Refactoring Note**: After implementing pattern-matching switch, all these tests should still pass!

## Running the Tests

### Run all tests:
```bash
mvn test
```

### Run a specific test class:
```bash
mvn test -Dtest=DemoMainTest
mvn test -Dtest=TaskTest
mvn test -Dtest=CommandTest
```

### Run a specific test method:
```bash
mvn test -Dtest=DemoMainTest#testDemonstrateAddingTasks
```

## Refactoring Workflow

### Step 1: Convert Task to Record
1. Run all tests first: `mvn test` (should pass)
2. Convert `Task` class to a record
3. Run tests again - **all TaskTest tests should still pass**
4. Fix any compilation issues in other tests

### Step 2: Seal the Command Interface
1. Make `Command` interface sealed
2. List permitted implementations: `AddTaskCommand`, `RemoveTaskCommand`, `UpdateTaskCommand`
3. Run tests - **all CommandTest tests should still pass**

### Step 3: Improve Exception Handling
1. Create custom exceptions (e.g., `TaskNotFoundException`)
2. Update `TaskRegistry.get()` to return `Optional<Task>`
3. Update tests that expect null to use `Optional.empty()`
4. Use `orElseThrow()` in `UpdateTaskCommand`
5. Run tests and update assertions as needed

### Step 4: Pattern-Matching Switch
1. Refactor `TaskManager.run()` to use pattern-matching switch
2. Run tests - **all TaskManagerTest tests should still pass**
3. Remove the `instanceof` checks

## Expected Test Results

Before refactoring:
```
Tests run: 51, Failures: 0, Errors: 0, Skipped: 0
```

After each refactoring step, you should see the same results (though some tests may need minor updates for Optional).

## Tips

- **Run tests frequently** - after each small change
- **Green to green** - keep tests passing throughout refactoring
- **One step at a time** - complete one refactoring step before moving to the next
- **Update tests carefully** - when changing from null to Optional, update test assertions

## Common Issues

### Issue: Tests fail after converting Task to record
**Solution**: Make sure the record has the same field names (`name`, `priority`) and the constructor signature matches.

### Issue: Tests fail after sealing Command
**Solution**: Ensure all existing Command implementations are listed in the `permits` clause.

### Issue: Tests fail after adding Optional
**Solution**: Update assertions from `assertNull(...)` to `assertTrue(optional.isEmpty())` and from `assertNotNull(...)` to `assertTrue(optional.isPresent())`.

## Success Criteria

 All 51 tests pass before refactoring  
 All tests pass after converting Task to record  
 All tests pass after sealing Command interface  
 Tests updated and passing after adding Optional  
 All tests pass after implementing pattern-matching switch  
 Demo still produces the same output  

Happy refactoring! 

