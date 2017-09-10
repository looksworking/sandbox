package org.looksworking.sandbox.hackerrank.algorithms.warmup;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

public class CompareTriplets {

    @Test
    public void CompareTripletsTest() {

        ByteArrayInputStream bis = new ByteArrayInputStream("5 6 7 3 6 10".getBytes());

        Scanner in = new Scanner(bis);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();

        int[] expected = {1, 1};
        int[] actual = solve(a0, a1, a2, b0, b1, b2);

        assertArrayEquals(expected, actual);

    }

    private int[] solve(int a0, int a1, int a2, int b0, int b1, int b2) {


        int[] res = new int[2];
        res[0] = 0;
        res[1] = 0;

        if (a0 > b0) {
            res[0]++;
        } else if (a0 < b0) {
            res[1]++;
        }

        if (a1 > b1) {
            res[0]++;
        } else if (a1 < b1) {
            res[1]++;
        }

        if (a2 > b2) {
            res[0]++;
        } else if (a2 < b2) {
            res[1]++;
        }

        return res;

    }
}
