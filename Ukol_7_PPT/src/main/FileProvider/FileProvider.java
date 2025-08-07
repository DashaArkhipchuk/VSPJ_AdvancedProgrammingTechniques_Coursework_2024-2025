package main.FileProvider;

import java.io.IOException;
import java.util.List;

public interface FileProvider {
    List<String> load(String path) throws IOException;
}