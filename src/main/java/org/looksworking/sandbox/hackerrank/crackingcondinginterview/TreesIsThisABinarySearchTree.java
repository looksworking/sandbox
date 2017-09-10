package org.looksworking.sandbox.hackerrank.crackingcondinginterview;

// https://www.hackerrank.com/challenges/ctci-is-binary-search-tree

import org.junit.Test;

import static org.junit.Assert.*;

public class TreesIsThisABinarySearchTree {

    @Test
    public void TreesIsThisABinarySearchTreeTest(){

        Node root = new Node();
        root.data = 4;

        root.left = new Node();
        root.left.data = 2;
        root.left.left = new Node();
        root.left.left.data = 1;
        root.left.right = new Node();
        root.left.right.data = 3;

        root.right = new Node();
        root.right.data = 6;
        root.right.left = new Node();
        root.right.left.data = 5;
        root.right.right = new Node();
        root.right.right.data = 7;

        boolean expected = true;
        boolean actual = checkBST(root);

        assertEquals(expected, actual);


    }

    boolean checkBST(Node root) {

        return checkBstRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private boolean checkBstRecursive(Node node, int min, int max){

        if (node == null) {
            return true;
        }

        if (node.data <= min || node.data >= max) {
            return false;
        }

        return checkBstRecursive(node.left, min, node.data) && checkBstRecursive(node.right, node.data, max);

    }

    class Node {
        int data;
        Node left;
        Node right;
    }
}
