package aqua.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aqua.exception.InvalidArgumentException;
import aqua.exception.StorageException;
import aqua.task.Task;

class StorageTest {
    private static final Path testPath = Paths.get("data", "aqua_test.txt");
    private Storage storage;

    class StubToDo extends aqua.task.Task {
        private String description;

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
        storage = new Storage(testPath);
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(testPath);
    }

    @Test
    public void load_emptyFile_success() throws StorageException {
        Storage storage = new Storage(testPath);
        List<String> lines = storage.load();
        assertEquals(0, lines.size());
    }

    @Test
    public void add_toDoTask_success() throws InvalidArgumentException, StorageException {
        Task todo = new StubToDo("Test task");
        storage.add(todo);
        List<String> lines = storage.load();
        assertEquals(1, lines.size());
        assertEquals(todo.toStorageString(), lines.get(0));
    }

    @Test
    public void remove_toDoTask_success() throws InvalidArgumentException, StorageException {
        Task todo1 = new StubToDo("Task 1");
        Task todo2 = new StubToDo("Task 2");
        storage.add(todo1);
        storage.add(todo2);

        storage.remove(todo1);

        List<String> lines = storage.load();
        assertEquals(1, lines.size());
        assertEquals(todo2.toStorageString(), lines.get(0));
    }

    @Test
    public void updateDoneStatus_toDoTask_success() throws InvalidArgumentException, StorageException {
        Task todo = new StubToDo("Done task");
        storage.add(todo);

        storage.updateDoneStatus(todo, true);

        List<String> lines = storage.load();
        String[] parts = lines.get(0).split("\\|");
        assertEquals("1", parts[1].trim());
    }
}
