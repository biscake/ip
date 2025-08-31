package sylvie.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import sylvie.task.Task;
import sylvie.ui.Textbox;

public class Storage {
    private final Path path;

    public Storage(Path path) {
        this.path = path;
    }
        
    
    /**
     * load Sylvie data from filepath
     * 
     * @return List of line of data stored
     * @throws IOException
     */
    public List<String> load() throws IOException {
        List<String> lines = new ArrayList<>();
        Files.createDirectories(path.getParent());
        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line.trim());
            }
        }

        return lines;
    }

    public void add(Task task) {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            writer.write(task.toStorageString());
            writer.newLine();
        } catch (IOException e) {
            new Textbox("Failed to save data.").print();
        }
    }
    
    public void remove(Task task) {
        try {
            Path tempPath = this.path.getParent().resolve("temp.txt");
            Files.createDirectories(tempPath.getParent());
            Files.deleteIfExists(tempPath);
            Files.createFile(tempPath);

            try (
                    BufferedReader reader = Files.newBufferedReader(path);
                    BufferedWriter writer = Files.newBufferedWriter(tempPath);
            ) {
                String line;

                while ((line = reader.readLine()) != null) {
                    if (line.equals(task.toStorageString())) {
                        continue;
                    }

                    writer.write(line.trim());
                    writer.newLine();
                }
            }

            Files.move(tempPath, path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            new Textbox("Failed to save data.").print();
        }
    }
    
    public void updateDoneStatus(Task task, boolean isDone) {
        try {
            Path tempPath = Paths.get("data", "temp.txt");
            Files.createDirectories(tempPath.getParent());
            Files.deleteIfExists(tempPath);
            Files.createFile(tempPath);

            try (
                    BufferedReader reader = Files.newBufferedReader(path);
                    BufferedWriter writer = Files.newBufferedWriter(tempPath);
            ) {
                String line;

                while ((line = reader.readLine()) != null) {
                    if (line.trim().equals(task.toStorageString())) {
                        String[] parts = line.split("\\|");
                        for (int i = 0; i < parts.length; i++) {
                            parts[i] = parts[i].trim();
                        }
                        
                        parts[1] = isDone ? "1" : "0";
                        line = String.join(" | ", parts);
                    }
                    writer.write(line.trim());
                    writer.newLine();
                }
            }

            Files.move(tempPath, path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            new Textbox("Failed to save data.").print();
        }
    }
}
