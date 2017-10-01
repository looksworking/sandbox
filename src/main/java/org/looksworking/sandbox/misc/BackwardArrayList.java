package org.looksworking.sandbox.misc;

import org.junit.Test;

public class BackwardArrayList {

    class Node {

        public Node(){
        }
        public Node(int data){
            this.data = data;
        }

        int data;
        Node next;
    }

    public int calc(Node head) {
        int count = 0;

        if (head == null) {
            return count;
        }

        count++;

        while (head.next != null){

            count++;
            head = head.next;
        }

        return count;
    }

    public Node rewind(Node head){

        Node reverse = null;

        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = reverse;
            reverse = current;
            current = next;
        }

        head = reverse;
        return head;
    }

    @Test
    public void test(){

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);


        System.out.println("nodes: " + calc(head));

        System.out.println(head.data);

        System.out.println(rewind(head).data);



    }

}
