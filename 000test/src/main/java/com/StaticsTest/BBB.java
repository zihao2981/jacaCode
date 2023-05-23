package  com.StaticsTest;

import static com.StaticsTest.AAAA.aaa2;
import static com.StaticsTest.AAAA.aaa3;

public class BBB {
    public void test(){
        System.out.println(aaa2);
        System.out.println(aaa3);
        System.out.println("测试成功");
        aaa2="bbbbb";
        System.out.println(aaa2);
        aaa3++;
        System.out.println(aaa3);
    }
}
