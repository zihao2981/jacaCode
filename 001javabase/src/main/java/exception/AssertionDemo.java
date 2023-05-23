package exception;

public class AssertionDemo {
    public static void main(String[] args) {
        int x = -1;
        assert x > 0 : "x must >= 0";
//        System.out.println(x);
    }
}
/**
 要执行assert语句，必须给Java虚拟机传递-enableassertions（可简写为-ea）参数启用断言
 java -ea Main.java
 有选择地对特定地类启用断言，命令行参数是：-ea:com.itranswarp.sample.Main，表示只对com.itranswarp.sample.Main这个类启用断言。
 或者对特定地包启用断言，命令行参数是：-ea:com.itranswarp.sample...（注意结尾有3个.），表示对com.itranswarp.sample这个包启动断言
 */