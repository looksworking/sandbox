package org.looksworking.sandbox.lafore_dsa.ch01_arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OrderedIntArray implements IntArray {

    int[] array;
    int size;

    public OrderedIntArray() {
        array = new int[100];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int find(int element) {

        // binary
        int lower = 0;
        int upper = size - 1;
        int index;
        while (true){

            if (lower > upper) {
                return size;
            }

            index = (upper + lower)/2;
            if (array[index] == element){
                return index;
            }
            if (element > array[index]) {
                lower = index+1;
            }
            if (element < array[index]) {
                upper = index-1;
            }
        }

    }

    @Override
    public int insert(int element) {

        //linear
        int index;
        for (index = 0 ; index < size ; index ++){
            if (array[index] > element){
                break;
            }
        }
        for (int i = size ; i > index ; i--){
            array[i] = array[i-1];
        }
        array[index] = element;
        size++;
        return index;
    }

    @Override
    public boolean delete(int element) {
        int index = find(element);
        if (index == size) {
            return false;
        }
        while (index < size-1 ){
            array[index] = array[index+1];
            index++;
        }
        size--;
        return true;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Elements:");
        for (int i = 0 ; i < size ; i++){
            sb.append(" array[").append(i).append("]=").append(array[i]);
        }
        return sb.toString();
    }


}