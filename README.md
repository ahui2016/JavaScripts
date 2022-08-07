# Java Scripts

一些 Java 小工具，把 Java 当作脚本语言来用。

## 缘起

多年以前我看到一篇神奇的文章 [Java for Everything](https://www.teamten.com/lawrence/writings/java-for-everything.html),
其中提出了一个大胆的想法：就连脚本小工具都用 Java 来写。

我读了这篇文章，但并没有立即使用 Java, 而是写了一段时间 Go, 又写了一段时间 Python, 有点腻了就想起这篇文章来，因此把 [dev.java](https://dev.java)
读了一遍，开始尝试用 Java 来写些小脚本，因此本项目名为 Java Scripts. *(不是 JavaScript)*

## 安装与使用

```shell
git clone https://github.com/ahui2016/JavaScripts.git
cd JavaScripts
mvn complie
```

执行以上命令即可下载源码，并进行编译（只需要编译一次），然后就可以开始使用了。

本项目包含多个不同功能的脚本，比如执行

```shell
java -cp "target/classes/:lib/*" cc.ai42.commands.cf.Main configfiles/cf/cfg.txt
#注意：如果是 Windows, 上面命令中的冒号改为分号 "target\classes\;lib\*"
```

可以得到类似这样的提示：

```txt
现在是 dry run 模式，需要添加 'do' 参数才能正式执行，
例如 java cc.ai42.commands.cf.Main /path/to/cfg.txt do

目的/用途:
逐个复制文件到指定文件夹。
从 "配置文件" 中读取文件列表，其中第一个是目标文件夹，其余是待复制文件。

配置文件路径:
configfiles/cf/cfg.txt

配置文件内容:
D:/LenovoFiles/data_folder/waiting/
```

可见，程序并没有真正执行，而是提供了详细说明，包括该命令的用途、配置文件位置、配置文件内容等。

需要使用参数 'do' 才能正式执行，比如：

```shell
java -cp "target/classes/:lib/*" cc.ai42.commands.cf.Main configfiles/cf/cfg.txt do
```

## 扩展

- 你也可以参考 src/main/java/cc/ai42/commands 里的代码，自己在该文件夹里添加代码，制作自己的 Java 脚本。
- 添加代码后执行 `mvn complie` 编译后即可使用。

## Python 版本

本项目参考了我以前用 Python 做的一个工具：
[ffe: 可轻松地用 Python 来写插件的文件操作工具](https://github.com/ahui2016/ffe/)
