package exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsLogging {

    public static void main(String[] args) {
        Log log = LogFactory.getLog(CommonsLogging.class);
        log.info("start...");
        log.warn("end.");
    }

}
/**
 *
 Commons Logging定义了6个日志级别：

 FATAL
 ERROR
 WARNING
 INFO
 DEBUG
 TRACE
 默认级别是INFO

 */