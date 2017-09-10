package org.looksworking.sandbox.hackerrank.algorithms.warmup;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class AVeryBigSum {

    @Test
    public void AVeryBigSumTest() {

        ByteArrayInputStream bis =
                new ByteArrayInputStream("5 1000000001 1000000002 1000000003 1000000004 1000000005".getBytes());

        Scanner in = new Scanner(bis);
        int n = in.nextInt();
        long[] ar = new long[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextLong();
        }

        long expected = 5000000015L;
        long actual = aVeryBigSum(n, ar);

        assertEquals(expected, actual);
    }

    private long aVeryBigSum(int n, long[] ar) {

        long res = 0;

        for (long num : ar) {
            res += num;
        }

        return res;
    }
}
