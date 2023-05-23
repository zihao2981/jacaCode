package exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JDemo {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(SLF4JDemo.class);
        int score = 99;

        logger.info("Set score {} for Person {} ok.", score, score);
    }
}

/**
 SLF4J的日志接口传入的是一个带占位符的字符串，用后面的变量自动替换占位符，所以看起来更加自然。

 需要一个Logback的配置文件

 */