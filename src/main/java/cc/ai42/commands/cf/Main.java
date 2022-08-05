package cc.ai42.commands.cf;

import java.io.IOException;

import cc.ai42.fu.CollectFiles;
import cc.ai42.fu.Config;
import cc.ai42.fu.Print;

/* 逐个复制文件到指定文件夹
 *
 * 编译方法: mvn compile
 * 执行方法(Windows): java -cp "target\classes\;lib\*" cc.ai42.commands.cf.Main configfiles/cf/cfg.txt
 * 执行方法(Unix): java -cp "target/classes/:lib/*" cc.ai42.commands.cf.Main /path/to/config
 * 
 * 从 configFile 中读取文件列表，其中第一个是目标文件夹，其余是待复制文件。
 */

public class Main {

  public static void main(String[] args) {

    boolean dryRun = Config.isDryRun(args);
    var configFile = args[0];

    try {
      if (dryRun) {
        Print.commandInfo(CollectFiles.info(), configFile);
        return;
      }
      CollectFiles.run(configFile);
    } catch (IOException e) {
      Print.ln(e.toString());
    }
  }
}
