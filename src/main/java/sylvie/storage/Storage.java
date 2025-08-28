package sylvie.storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    /**
     * load Sylvie data from filepath
     * 
     * @return List of line of data stored
     * @throws IOException
     */
    public List<String> load() throws IOException {
        List<String> lines = new ArrayList<>();
        Path path = Paths.get("data", "sylvie.txt");
        Files.createDirectories(path.getParent());
        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }
}
