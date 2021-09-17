package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 2217번, 로프
public class Practice10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Integer[] ropes = new Integer[count];
        for (int i = 0; i < count; i++) {
            ropes[i] = scanner.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        Arrays.sort(ropes, Collections.reverseOrder());

        for (int i = 0; i < count; i++) {
            if(ropes[i] * (i+1) > max){
                max = ropes[i] * (i+1);
                maxIndex = i;
            }
        }

        System.out.println(max);
    }
}
