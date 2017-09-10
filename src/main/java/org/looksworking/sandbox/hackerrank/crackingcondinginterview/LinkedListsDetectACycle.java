package org.looksworking.sandbox.hackerrank.crackingcondinginterview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LinkedListsDetectACycle {

    @Test
    public void LinkedListsDetectACycleTest() {

        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();

        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        boolean expected = true;
        boolean actual = hasCycle(node1);

        assertEquals(expected, actual);

    }

    boolean hasCycle(Node head) {

        boolean result = false;

        List<Node> nodes = new ArrayList<>();

        while (head != null && head.next != null) {

            nodes.add(head);

            if (nodes.contains(head.next)) {
                return true;
            }

            head = head.next;
        }

        return result;
    }


    class Node {
        int data;
        Node next;
    }
}
