package junitTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorialJunitTest {

    @Test
    public void testFact() {
        assertEquals(1, Factorial.fact(1));
        assertEquals(2, Factorial.fact(2));
        assertEquals(6, Factorial.fact(3));
        assertEquals(3628800, Factorial.fact(10));
        assertEquals(2432902008176640000L, Factorial.fact(20));
    }
}
/**
 它在Assertion类中定义。Assertion还定义了其他断言方法，例如：

 assertTrue(): 期待结果为true
 assertFalse(): 期待结果为false
 assertNotNull(): 期待结果为非null
 assertArrayEquals(): 期待结果为数组并与期望数组每个元素的值均相等

 */