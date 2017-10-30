package org.looksworking.sandbox.hackerrank.data_structures;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/2d-array
public class TwoDArraysDS {

    @Test
    public void test() {
        ByteArrayInputStream bis =
                new ByteArrayInputStream((
                        "1 1 1 0 0 0 " +
                                "0 1 0 0 0 0 " +
                                "1 1 1 0 0 0 " +
                                "0 0 2 4 4 0 " +
                                "0 0 0 2 0 0 " +
                                "0 0 1 2 4 0").getBytes());
        Scanner in = new Scanner(bis);
        int arr[][] = new int[6][6];
        for (int arr_i = 0; arr_i < 6; arr_i++) {
            for (int arr_j = 0; arr_j < 6; arr_j++) {
                arr[arr_i][arr_j] = in.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 4; k++) {
                int sum = arr[i][k] + arr[i][k + 1] + arr[i][k + 2] +
                        +arr[i + 1][k + 1] + arr[i + 2][k] + arr[i + 2][k + 1] + arr[i + 2][k + 2];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
