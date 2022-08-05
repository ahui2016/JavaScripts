package cc.ai42.commands.txz;

import java.io.IOException;

import cc.ai42.fu.Config;
import cc.ai42.fu.Print;
import cc.ai42.fu.TarXZ;

/* 打包压缩 tar.xz
 *
 * 编译方法: mvn compile
 * 执行方法(Windows): java -cp "target\classes\;lib\*" cc.ai42.commands.txz.Main configfiles/txz/cfg.txt
 * 执行方法(Unix): java -cp "target/classes/:lib/*" cc.ai42.commands.txz.Main /path/to/config
 *
 * 从外部文件 files.txt 中读取文件列表，
 * 其中第一个是压缩包的文件名（绝对路径），其余是待压缩文件。
 */

public class Main {

  public static void main(String[] args) {

    boolean dryRun = Config.isDryRun(args);
    var configFile = args[0];

    try {
      if (dryRun) {
        Print.commandInfo(TarXZ.info(), configFile);
        return;
      }
      TarXZ.run(configFile);
    } catch (IOException e) {
      Print.ln(e.toString());
    }
  }
}
