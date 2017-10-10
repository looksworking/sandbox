package org.looksworking.sandbox.lafore_dsa.ch01_arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

public class Tests {

    @Test
    public void OrderedArrayTest(){

        IntArray ordArr = new OrderedIntArray();
        Assert.assertEquals(0, ordArr.size());
        IntStream ints = new Random().ints(100, 0, 1000);
        ints.forEach(ordArr::insert);
        Assert.assertEquals(100, ordArr.size());
        System.out.println(ordArr);
        int low = ordArr.get(0);
        int high = ordArr.get(99);
        int middle = ordArr.get(49);
        int far = ordArr.get(33);

        Assert.assertEquals(0, ordArr.find(low));
        Assert.assertEquals(99, ordArr.find(high));
        Assert.assertEquals(49, ordArr.find(middle));

        Assert.assertEquals(33, ordArr.find(far));

        Assert.assertEquals(100, ordArr.find(1001));

        Assert.assertFalse(ordArr.delete(1001));
        Assert.assertTrue(ordArr.delete(far));
        Assert.assertEquals(99, ordArr.size());
        Assert.assertEquals(99, ordArr.find(far));
        Assert.assertFalse(ordArr.delete(far));
    }
}
