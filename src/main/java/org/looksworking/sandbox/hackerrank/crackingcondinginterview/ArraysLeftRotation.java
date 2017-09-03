package org.looksworking.sandbox.hackerrank.crackingcondinginterview;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

public class ArraysLeftRotation {

    private static int[] leftRotate(int[] arr, int size, int times) {

        int[] result = new int[size];

        for (int i = 0; i < size; i++) {

            int s1 = (i - times) % size;

            if (s1 < 0) {

                s1 = size - Math.abs(s1);
            }

            result[s1] = arr[i];

        }

        return result;
    }

    @Test
    public void ArraysLeftRotationu() {

        ByteArrayInputStream in = new ByteArrayInputStream("5 1 1 2 3 4 5".getBytes());

        Scanner input = new Scanner(in);

        int n = input.nextInt();
        int k = input.nextInt();
        int arr[] = new int[n];

        for (int a_i = 0; a_i < n; a_i++) {
            arr[a_i] = input.nextInt();
        }

        arr = leftRotate(arr, n, k);

        int[] expectedArr = {2, 3, 4, 5, 1};

        assertArrayEquals(expectedArr, arr);

        for (int i : arr) {
            System.out.print(i + " ");

        }
    }

}
