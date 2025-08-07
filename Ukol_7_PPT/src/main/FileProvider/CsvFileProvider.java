package main.FileProvider;

import main.FileProvider.FileProvider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileProvider implements FileProvider {
    public List<String> load(String path) throws IOException {
        Path p = Paths.get(path);
        if (!Files.exists(p)) throw new FileNotFoundException("File not found: " + path);
        return Files.readAllLines(p);
    }
}
