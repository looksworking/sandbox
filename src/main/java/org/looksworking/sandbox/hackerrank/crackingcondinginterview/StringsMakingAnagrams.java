package org.looksworking.sandbox.hackerrank.crackingcondinginterview;

// https://www.hackerrank.com/challenges/ctci-making-anagrams

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class StringsMakingAnagrams {

    @Test
    public void StringsMakingAnagramsTest() {

        ByteArrayInputStream inputStream = new ByteArrayInputStream("cde abc".getBytes());
        Scanner scanner = new Scanner(inputStream);
        String str1 = scanner.next();
        String str2 = scanner.next();

        int expected = 4;
        int actual = countDeletions(str1, str2);

        assertEquals(expected, actual);
    }


    private int countDeletions(String str1, String str2) {

        int[] alphabet = new int[26];

        str1.chars().forEach(c -> alphabet[c - 'a']++);
        str2.chars().forEach(c -> alphabet[c - 'a']--);

        return Arrays.stream(alphabet).reduce(0, (c, d) -> Math.abs(c) + Math.abs(d));

    }

}
