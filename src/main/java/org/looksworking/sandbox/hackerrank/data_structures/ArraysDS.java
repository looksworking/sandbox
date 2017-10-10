package org.looksworking.sandbox.hackerrank.data_structures;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class ArraysDS {

    @Test
    public void test() {

        ByteArrayInputStream bis = new ByteArrayInputStream("5 1 2 3 4 5".getBytes());
        Scanner input = new Scanner(bis);
        int arraySize = input.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0 ; i < arraySize ; i ++){
            array[i] = input.nextInt();
        }

        StringBuilder output = new StringBuilder();
        for (int i = arraySize -1; i>=0 ; i--){
            output.append(array[i]).append(" ");
        }

        System.out.println(output.toString().trim());
    }

}
