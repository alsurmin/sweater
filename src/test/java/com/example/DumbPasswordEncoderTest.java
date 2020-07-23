package com.example;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;


public class DumbPasswordEncoderTest {

    @Test
    public void encode() {
        DumbPasswordEncoder encoder = new DumbPasswordEncoder();

        Assert.assertEquals("secret: 'mypwd'", encoder.encode("mypwd"));
        Assert.assertThat(encoder.encode("mypwd"), containsString("mypwd"));
    }
}