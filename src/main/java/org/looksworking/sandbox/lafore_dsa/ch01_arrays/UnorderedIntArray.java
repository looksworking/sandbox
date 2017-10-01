package org.looksworking.sandbox.lafore_dsa.ch01_arrays;

import org.junit.Assert;
import org.junit.Test;

public class UnorderedIntArray implements IntArray {

    int size;
    int[] array;

    public UnorderedIntArray(){
        array = new int[100];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int find(int element) {

        for (int i = 0 ; i < size ; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return size;
    }

    @Override
    public int insert(int element) {
        array[size] = element;
        size++;
        return size - 1;
    }

    @Override
    public boolean delete(int element) {
        int index = find(element);
        if (index == size) {
            return false;
        }
        while (index != size) {
            array[index] = array[++index];
        }
        size--;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Elements:");
        for (int i = 0; i< size ; i++) {
            sb.append(" ").append(array[i]);
        }
        return sb.toString();
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Test
    public void unorderedArrayTest(){
        IntArray unordArr = new UnorderedIntArray();

        Assert.assertEquals(0, unordArr.size());
        Assert.assertEquals(0, unordArr.insert(22));
        Assert.assertEquals(1, unordArr.insert(99));
        Assert.assertEquals(2, unordArr.insert(11));
        Assert.assertEquals(3, unordArr.insert(55));
        Assert.assertEquals(4, unordArr.insert(88));
        Assert.assertEquals(5, unordArr.insert(44));
        Assert.assertEquals(6, unordArr.insert(77));
        Assert.assertEquals(7, unordArr.insert(66));
        Assert.assertEquals(8, unordArr.insert(33));

        Assert.assertEquals(9, unordArr.size());

        Assert.assertEquals(4, unordArr.find(88));

        Assert.assertTrue(unordArr.delete(11));

        Assert.assertEquals(8, unordArr.size());

        Assert.assertFalse(unordArr.delete(11));
        System.out.println(unordArr);
    }
}