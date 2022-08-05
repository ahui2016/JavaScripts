package cc.ai42.fu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ReadFile {

    public static List<String> lines(String configFile) throws IOException {

        List<String> list;

        try (Stream<String> lines = Files.lines(Path.of(configFile))) {
            list = lines.map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .distinct()
                        .collect(toList());
        }

        if (list.isEmpty()) {
            throw new RuntimeException("文件内容为空: " + configFile);
        }

        return list;
    }

    public static List<File> files(String configFile) throws IOException {

        List<File> allFiles;

        try (Stream<String> lines = Files.lines(Path.of(configFile))) {
            allFiles = lines.map(String::trim)
                         .filter(s -> !s.isEmpty())
                         .distinct()
                         .map(File::new)
                         .collect(toList());
        }

        if (allFiles.isEmpty()) {
            throw new RuntimeException("文件列表为空: " + configFile);
        }

        return allFiles;
    }
}
