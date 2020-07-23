package com.example;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @Test
    public void test() {
        int x = 2;
        int y = 20;

        Assert.assertEquals(22, x + y);
        Assert.assertEquals(40, x * y);

    }

    @Test
    public void error() {
        int i = 0;

        Assertions.assertThrows(ArithmeticException.class, () -> getAnInt(i));
    }

    private int getAnInt(int i) {
        return 1/i;
    }

}
