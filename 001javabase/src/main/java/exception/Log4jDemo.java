package exception;

public class Log4jDemo {
}
/**
 * 当我们使用Log4j输出一条日志时，Log4j自动通过不同的Appender把同一条日志输出到不同的目的地。例如：
 *
 * console：输出到屏幕；
 * file：输出到文件；
 * socket：通过网络输出到远程计算机；
 * jdbc：输出到数据库
 *

 把一个log4j2.xml的文件放到classpath下就可以让Log4j读取配置文件并按照我们的配置来输出日志

 Commons Logging会自动发现并使用Log4j，所以，把上一节下载的commons-logging-1.2.jar也放到classpath中。

 要打印日志，只需要按Commons Logging的写法写，不需要改动任何代码，就可以得到Log4j的日志输出

 Log4j是一个组件化设计的日志系统，它的架构大致如下：

 log.info("User signed in.");
 │
 │   ┌──────────┐    ┌──────────┐    ┌──────────┐    ┌──────────┐
 ├──>│ Appender │───>│  Filter  │───>│  Layout  │───>│ Console  │
 │   └──────────┘    └──────────┘    └──────────┘    └──────────┘
 │
 │   ┌──────────┐    ┌──────────┐    ┌──────────┐    ┌──────────┐
 ├──>│ Appender │───>│  Filter  │───>│  Layout  │───>│   File   │
 │   └──────────┘    └──────────┘    └──────────┘    └──────────┘
 │
 │   ┌──────────┐    ┌──────────┐    ┌──────────┐    ┌──────────┐
 └──>│ Appender │───>│  Filter  │───>│  Layout  │───>│  Socket  │
 └──────────┘    └──────────┘    └──────────┘    └──────────┘
 */