package org.looksworking.sandbox.hackerrank.algorithms.warmup;

// https://www.hackerrank.com/challenges/diagonal-difference

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class DiagonalDifference {

    @Test
    public void DiagonalDifferenceTest() {

        ByteArrayInputStream bis = new ByteArrayInputStream("3 11 2 4 4 5 6 10 8 -12".getBytes());

        Scanner scanner = new Scanner(bis);

        int arrLength = scanner.nextInt();
        Integer[][] arr = new Integer[arrLength][arrLength];
        for (int i = 0; i < arrLength; i++) {
            for (int k = 0; k < arrLength; k++) {
                arr[i][k] = scanner.nextInt();
            }
        }

        int[] diag1 = new int[arrLength];
        int[] diag2 = new int[arrLength];

        int sumx = 0;
        int sumy = 0;

        for (int i = 0; i < arrLength; i++) {
            for (int k = 0; k < arrLength; k++) {
                if (i == k) {
                    sumx = sumx + arr[i][k];
                }
                if (k == arrLength - i - 1) {
                    sumy = sumy + arr[i][k];
                }
            }
        }

        int expected = 15;
        int actual = Math.abs(sumx - sumy);

        assertEquals(expected, actual);
    }
}