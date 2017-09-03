package org.looksworking.sandbox.hackerrank.crackingcondinginterview;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class HashTablesRansomNote {

    @Test
    public void HashTablesRansomNote() {

        ByteArrayInputStream bis =
                new ByteArrayInputStream("6 4 give me one grand today night\ngive one grand today".getBytes());

        Scanner in = new Scanner(bis);
        int m = in.nextInt();
        int n = in.nextInt();

        String magazine[] = new String[m];
        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            ransom[ransom_i] = in.next();
        }

        String expected = "Yes";

        String actual = doesItFit(magazine, ransom);

        assertEquals(expected, actual);
    }

    private String doesItFit(String[] magazine, String[] ransom) {

        String response = "Yes";

        Map<String, Long> magazineCount = Arrays.stream(magazine)
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));

        Map<String, Long> ransomCount = Arrays.stream(ransom)
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));

        for (String word : ransomCount.keySet()){
            if (!magazineCount.containsKey(word) || magazineCount.get(word) < ransomCount.get(word) ){
                return "No";
            }
        }

        return response;
    }
}
