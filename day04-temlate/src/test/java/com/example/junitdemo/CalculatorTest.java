package com.example.junitdemo;


import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();
    private final Calculator2 calculator2 = new Calculator2();
    @Test
    void testAdd() {
        // 测试正常情况
//        Assert.assertEquals(5, calculator.add(2, 3), "2 + 3 应该等于 5");

        // 测试负数
        Assert.assertEquals(-1, calculator.add(-3, 2), "-3 + 2 应该等于 -1");

        // 测试零
        Assert.assertEquals(0, calculator.add(0, 0), "0 + 0 应该等于 0");

        // 测试大数
        Assert.assertEquals(999999999, calculator.add(500000000, 499999999), "500000000 + 499999999 应该等于 999999999");
    }

    @Test
    void testAdd2() {
        // 测试正常情况
        Assert.assertEquals(5, calculator2.add(2, 3), "2 + 3 应该等于 5");

        // 测试负数
        Assert.assertEquals(-1, calculator2.add(-3, 2), "-3 + 2 应该等于 -1");

        // 测试零
        Assert.assertEquals(0, calculator2.add(0, 0), "0 + 0 应该等于 0");

        // 测试大数
        Assert.assertEquals(999999999, calculator2.add(500000000, 499999999), "500000000 + 499999999 应该等于 999999999");
    }


}
