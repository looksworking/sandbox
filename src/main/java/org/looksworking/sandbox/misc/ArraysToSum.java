package org.looksworking.sandbox.misc;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;


// playing around one of Cornel's problem
public class ArraysToSum {

    @Test
    public void arrs(){

        int[] arr1 = {8, 2, 3, 9};
        int[] arr2 = {7, 2, 3, 4, 1};
        int[] result = new int[arr1.length>=arr2.length?arr1.length+1:arr2.length+1];

        IntStream arr1RevStream = IntStream.range(0, arr1.length).map(i -> arr1.length - i);
        IntStream arr2RevStream = IntStream.range(0, arr2.length).map(i -> arr2.length - i);

        IntStream.range(0, Math.max(arr1.length, arr2.length)).forEach( i -> {
            int sum = arr1[arr1.length-i-1] + arr2[arr2.length-i-1];
            if (sum>10){
                result[result.length-i-2]++;
                sum = sum%10;
            }
            result[result.length-i-1]+=sum;
        });
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void sums(){
        double dd = 1%10;
        System.out.println(dd);
    }
}
