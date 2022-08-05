package cc.ai42.fu;

import java.io.IOException;
import java.util.List;

public class Print {
    public static void ln(String x) {
        System.out.println(x);
    }

    public static void ln() {
        System.out.println();
    }

    public static void commandInfo(String info, String configFile) throws IOException {

        List<String> args = ReadFile.lines(configFile);

        Print.ln();
        Print.ln("现在是 dry run 模式，需要添加 'do' 参数才能正式执行，");
        Print.ln("例如 java cc.ai42.commands.cf.Main /path/to/cfg.txt do");
        Print.ln();
        Print.ln("目的/用途:");
        Print.ln(info);
        Print.ln();
        Print.ln("配置文件路径:\n" + configFile);
        Print.ln();
        Print.ln("配置文件内容:");
        args.forEach(Print::ln);
        Print.ln();
    }
}
