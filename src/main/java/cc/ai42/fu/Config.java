package cc.ai42.fu;

public class Config  {
    public static boolean isDryRun(String[] args) {
        if (args.length == 0) throw new RuntimeException("请指定配置文件");
        if (args.length > 2) throw new RuntimeException("参数个数不可大于2");
        if (args.length == 1) return true;
        // 至此, args.length 必然等于 2
        return !args[1].equals("do");
    }
}
