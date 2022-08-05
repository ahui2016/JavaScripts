package cc.ai42.fu;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.List;

import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;
import org.apache.commons.compress.utils.IOUtils;

/*
 * 参考 https://commons.apache.org/proper/commons-compress/examples.html
 */

public class TarXZ {

    public static String info() {
        return """
            打包压缩 tar.xz
            从 "配置文件" 中读取文件列表，
            其中第一个是压缩包的文件名（绝对路径），其余是待压缩文件。""";
    }

    public static void run(String configFile) throws IOException {

        List<File> allFiles = ReadFile.files(configFile);

        if (allFiles.size() < 2) {
            Print.ln("内容不可少于两行 (第一行是压缩包的文件名，从第二行开始是待压缩文件)\n" + configFile);
            return;
        }

        var ok = CheckFiles.allAbsolute(allFiles);
        if (!ok) return;

        var zipFile = allFiles.get(0);
        var files = allFiles.subList(1, allFiles.size());

        if (zipFile.exists()) {
            Print.ln("已存在(不可覆盖): " + zipFile);
            return;
        }

        if (files.isEmpty()) {
            Print.ln("文件列表为空 (没有待复制的文件)");
            return;
        }

        ok = CheckFiles.allExist(files);
        if (!ok) return;

        ok = CheckFiles.allAreFiles(files);
        if (!ok) return;

        // 以上是检查阶段
        // 以下是实施阶段

        Print.ln("创建压缩包: " + zipFile + "\n");

        try (OutputStream fo = Files.newOutputStream(zipFile.toPath());
             OutputStream xzo = new XZCompressorOutputStream(fo);
             ArchiveOutputStream output = new TarArchiveOutputStream(xzo)) {

            for (var f: files) {
                Print.ln("塞进压缩包: " + f);
                var entry = output.createArchiveEntry(f, f.getName());
                output.putArchiveEntry(entry);
                var input = Files.newInputStream(f.toPath());
                IOUtils.copy(input, output);
                output.closeArchiveEntry();
            }
            output.finish();
        }

        Print.ln("完成");
    }
}
