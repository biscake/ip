package sylvie.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sylvie.exception.InvalidArgumentException;

public class TaskListTest {
    private static final Path testPath = Path.of("data", "tasklist_test.txt");
    private TaskList taskList;

    class StubToDo extends sylvie.task.Task {
        String description;

        public StubToDo(String description) throws InvalidArgumentException {
            super(description);
            this.description = description;
        }

        @Override
        public String toString() {
            return "T | 0 | " + description;
        }

        @Override
        public String toStorageString() {
            return "T | 0 | " + description;
        }
    }

    @BeforeEach
    public void setUp() throws IOException {
        Files.createDirectories(testPath.getParent());
        Files.deleteIfExists(testPath);
        Files.createFile(testPath);
        taskList = new TaskList(testPath);
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(testPath);
    }

    @Test
    public void loadFromStorage_emptyFile_success() {
        taskList.loadFromStorage();
        assertEquals(0, taskList.size());
    }

    @Test
    public void add_ToDoTask_success() throws InvalidArgumentException {
        Task todo = new StubToDo("Test task");
        taskList.add(todo);
        assertEquals(1, taskList.size());
    }
}