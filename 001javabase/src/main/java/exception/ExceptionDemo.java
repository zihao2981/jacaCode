package exception;

public class ExceptionDemo  {

    public static void main(String[] args) throws Exception {

        Exception origin = null;
        try {

            //异常缺失原始信息
//            process1();
            //异常原始信息传递
//            process3();
            System.out.println(Integer.parseInt("abc"));
        } catch (Exception e) {
            origin = e;
            throw e;
        } finally {
            Exception e = new IllegalArgumentException();
            if (origin != null) {
                e.addSuppressed(origin);
            }
            throw e;
        }
    }




    static void process1() {
        try {
            process2();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static void process3() {
        try {
            process2();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    static void process2() {
        throw new NullPointerException();
    }

}
/**
 ##java的异常是class

 ┌───────────┐
 │  Object   │
 └───────────┘
 ▲
 │
 ┌───────────┐
 │ Throwable │
 └───────────┘
 ▲
 ┌─────────┴─────────┐
 │                   │
 ┌───────────┐       ┌───────────┐
 │   Error   │       │ Exception │
 └───────────┘       └───────────┘
 ▲                   ▲
 ┌───────┘              ┌────┴──────────┐
 │                      │               │
 ┌─────────────────┐    ┌─────────────────┐┌───────────┐
 │OutOfMemoryError │... │RuntimeException ││IOException│...
 └─────────────────┘    └─────────────────┘└───────────┘
 ▲
 ┌───────────┴─────────────┐
 │                         │
 ┌─────────────────────┐ ┌─────────────────────────┐
 │NullPointerException │ │IllegalArgumentException │...
 └─────────────────────┘ └─────────────────────────┘

 ##Java规定：
 必须捕获的异常，包括Exception及其子类，但不包括RuntimeException及其子类，这种类型的异常称为Checked Exception。
 不需要捕获的异常，包括Error及其子类，RuntimeException及其子类。

 Java标准库定义的常用异常包括：

 Exception
 │
 ├─ RuntimeException
 │  │
 │  ├─ NullPointerException
 │  │
 │  ├─ IndexOutOfBoundsException
 │  │
 │  ├─ SecurityException
 │  │
 │  └─ IllegalArgumentException
 │     │
 │     └─ NumberFormatException
 │
 ├─ IOException
 │  │
 │  ├─ UnsupportedCharsetException
 │  │
 │  ├─ FileNotFoundException
 │  │
 │  └─ SocketException
 │
 ├─ ParseException
 │
 ├─ GeneralSecurityException
 │
 ├─ SQLException
 │
 └─ TimeoutException

 */