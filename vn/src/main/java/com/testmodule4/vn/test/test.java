package com.testmodule4.vn.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int[] arr = { 13, 7, 6, 45, 21, 9, 101, 102 };

        // Applying sort() method over to above array
        // by passing the array as an argument
        Arrays.sort(arr);
        System.out.println(arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
