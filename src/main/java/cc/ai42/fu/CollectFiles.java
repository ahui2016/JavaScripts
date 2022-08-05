package cc.ai42.fu;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CollectFiles {

    public static String info() {
        return """
            逐个复制文件到指定文件夹。
            从 "配置文件" 中读取文件列表，其中第一个是目标文件夹，其余是待复制文件。""";
    }

    public static void run(String configFile) throws IOException {

        List<File> allFiles = ReadFile.files(configFile);

        if (allFiles.size() < 2) {
            Print.ln("内容不可少于两行 (第一行是目标文件夹，从第二行开始是待复制文件)\n" + configFile);
            return;
        }

        var ok = CheckFiles.allAbsoluteExist(allFiles);
        if (!ok) return;

        var targetFolder = allFiles.get(0);
        var files = allFiles.subList(1, allFiles.size());

        if (!targetFolder.isDirectory()) {
            Print.ln("目标文件夹不是文件夹: " + targetFolder);
            return;
        }
        if (files.isEmpty()) {
            Print.ln("文件列表为空 (没有待复制的文件)");
            return;
        }

        ok = CheckFiles.allAreFiles(files);
        if (!ok) return;

        final var folder = targetFolder.toPath();

        List<File> targetFiles = files.stream()
                .map(f -> folder.resolve(f.toPath().getFileName()).toFile())
                .collect(toList());

        ok = CheckFiles.allNotExist(targetFiles);
        if (!ok) return;

        // 以上是检查阶段
        // 以下是实施阶段

        Print.ln("复制文件到 " + folder);
        for (var f: files) {
            Print.ln("copy " + f);
            var source = f.toPath();
            var target = folder.resolve(source.getFileName());
            Files.copy(source, target);
        }
    }
}
