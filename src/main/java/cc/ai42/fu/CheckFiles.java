package cc.ai42.fu;

import java.io.File;
import java.util.List;

public class CheckFiles {

    /**
     * 当全部文件都采用绝对路径时，返回 true.
     */
    public static boolean allAbsolute(List<File> files) {
        boolean ok = true;
        for (var file: files) {
            if (!file.isAbsolute()) {
                Print.ln("不是绝对路径: " + file);
                ok = false;
            }
        }
        return ok;
    }

    /**
     * 当全部文件都采用绝对路径，并且都存在时，返回 true.
     */
    public static boolean allAbsoluteExist(List<File> files) {
        boolean ok = true;
        for (var file: files) {
            if (!file.isAbsolute()) {
                Print.ln("不是绝对路径: " + file);
                ok = false;
                continue;
            }
            if (!file.exists()) {
                Print.ln("不存在: " + file);
                ok = false;
            }
        }
        return ok;
    }

    /**
     * 当全部文件都是文件（其中没有文件夹）时返回 true.
     */
    public static boolean allAreFiles(List<File> files) {
        boolean ok = true;
        for (var file: files) {
            if (!file.isFile()) {
                Print.ln("不是文件: " + file);
                ok = false;
            }
        }
        return ok;
    }

    /**
     * 当全部文件都存在时返回 true.
     */
    public static boolean allExist(List<File> files) {
        boolean ok = true;
        for (var file: files) {
            if (!file.exists()) {
                Print.ln("不存在: " + file);
                ok = false;
            }
        }
        return ok;
    }

    /**
     * 当全部文件都不存在时返回 true.
     */
    public static boolean allNotExist(List<File> files) {
        boolean ok = true;
        for (var file: files) {
            if (file.exists()) {
                Print.ln("已存在: " + file);
                ok = false;
            }
        }
        return ok;
    }
}
