package org.looksworking.sandbox.hackerrank.crackingcondinginterview;

// https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class QueuesATaleOfTwoStacks {

    @Test
    public void QueuesATaleOfTwoStacksTest(){

        MyQueue<Integer> queue = new MyQueue<Integer>();

        ByteArrayInputStream bis =
                new ByteArrayInputStream("10 1 42 2 1 14 3 1 28 3 1 60 1 78 2 2".getBytes());

        Scanner scan = new Scanner(bis);
        int n = scan.nextInt();

        int[] peeked = new int[2];
        int peekedIndex = 0;

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) {
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) {
                queue.dequeue();
            } else if (operation == 3) {
                peeked[peekedIndex++] = queue.peek();
            }
        }
        scan.close();

        int expected = 14;

        assertEquals(expected, peeked[0]);
        assertEquals(expected, peeked[1]);
    }

    class MyQueue<T>{

        private Stack<T> fifo = new Stack<>();
        private Stack<T> lifo = new Stack<>();

        public void enqueue(T element){
            lifo.push(element);
        }

        public void dequeue(){
            prepareNewStack();
            fifo.pop();

        }

        public T peek(){
            prepareNewStack();
            return fifo.peek();

        }

        private void prepareNewStack(){
            if (fifo.empty()){
                while (!lifo.empty()){
                    fifo.push(lifo.pop());
                }
            }
        }
    }
}