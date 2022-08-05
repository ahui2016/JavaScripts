# Java Scripts

一些 Java 小工具，把 Java 当作脚本语言来用。

## 缘起

多年以前我看到一篇神奇的文章 [Java for Everything](https://www.teamten.com/lawrence/writings/java-for-everything.html),
其中提出了一个大胆的想法：就连脚本小工具都用 Java 来写。

我读了这篇文章，但并没有立即使用 Java, 而是写了一段时间 Go, 又写了一段时间 Python, 有点腻了就想起这篇文章来，因此把 [dev.java](https://dev.java)
读了一遍，开始尝试用 Java 来写些小脚本，因此本项目名为 Java Scripts. *(不是 JavaScript)*

## 编译方法

```shell
mvn complie
```

## 使用方法

- 需要使用 `-cp` 参数。

```shell
cd /path/to/scripts
java -cp "target/classes/:lib/*" cc.ai42.commands.cf.Main /path/to/cfg.txt
```

如果是 Windows, 上面的冒号改为分号 `"target\classes\;lib\*"`

## Python 版本

本项目参考了我以前用 Python 做的一个工具：
[ffe: 可轻松地用 Python 来写插件的文件操作工具](https://github.com/ahui2016/ffe/)
