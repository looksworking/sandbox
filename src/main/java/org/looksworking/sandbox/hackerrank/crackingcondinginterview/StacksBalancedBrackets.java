package org.looksworking.sandbox.hackerrank.crackingcondinginterview;

// https://www.hackerrank.com/challenges/ctci-balanced-brackets

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class StacksBalancedBrackets {

    @Test
    public void StacksBalancedBracketsTest() throws IOException, URISyntaxException {

        Path inPath = Paths.get(getClass().getClassLoader()
                .getResource("hackerrank/crackingcodinginterview/StacksBalancedBrackets.in").toURI());
        Path outPath = Paths.get(getClass().getClassLoader()
                .getResource("hackerrank/crackingcodinginterview/StacksBalancedBrackets.out").toURI());

        String expected = new String(Files.readAllBytes(outPath));

        Scanner in = new Scanner(inPath);
        int t = in.nextInt();
        StringBuilder actualStringBuilder = new StringBuilder();

        for (int i = 0; i < t; i++) {
            actualStringBuilder.append((isBalanced(in.next()) ? "YES" : "NO")).append("\n");
        }

        assertEquals(expected, actualStringBuilder.toString());
    }

    boolean isBalanced(String brackets) {


        char[] chars = brackets.toCharArray();

        if (chars.length % 2 != 0) {
            return false;
        }

        Stack<Character> characterStack = new Stack<>();


        for (char ch1 : chars) {

            if (ch1 == '{' || ch1 == '[' || ch1 == '(') {

                characterStack.push(ch1);

            } else {
                try {
                    char ch = characterStack.pop();
                    if (ch == '[' && ch1 != ']') {
                        return false;
                    }
                    if (ch == '{' && ch1 != '}') {
                        return false;
                    }
                    if (ch == '(' && ch1 != ')') {
                        return false;
                    }
                } catch (EmptyStackException e) {
                    return false;
                }
            }
        }

        return characterStack.empty();
    }
}
