package aqua.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aqua.exception.IllegalDataException;
import aqua.exception.InvalidArgumentException;
import aqua.exception.StorageException;

public class TaskListTest {
    private static final Path testPath = Path.of("data", "tasklist_test.txt");
    private TaskList taskList;

    class StubToDo extends aqua.task.Task {
        private String tempDescription;

        public StubToDo(String description) throws InvalidArgumentException {
            super(description);
            this.tempDescription = description;
        }

        @Override
        public String toString() {
            return "T | 0 | " + tempDescription;
        }

        @Override
        public String toStorageString() {
            return "T | 0 | " + tempDescription;
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
    public void loadFromStorage_emptyFile_success() throws StorageException, IllegalDataException {
        taskList.loadFromStorage();
        assertEquals(0, taskList.size());
    }

    @Test
    public void add_toDoTask_success() throws InvalidArgumentException, StorageException {
        Task todo = new StubToDo("Test task");
        taskList.add(todo);
        assertEquals(1, taskList.size());
    }
}
