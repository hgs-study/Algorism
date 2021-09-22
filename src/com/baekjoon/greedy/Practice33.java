package com.baekjoon.greedy;

import java.util.Arrays;

import java.util.Collections;
import java.util.Scanner;

// 9237번, 이장님 초대
public class Practice33 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Integer[] trees = new Integer[count];
        for (int i = 0; i < count; i++) {
            trees[i] = scanner.nextInt();
        }

        Arrays.sort(trees, Collections.reverseOrder());

        int max = Integer.MIN_VALUE;
        int day = 1;
        for (int i = 0; i < count; i++) {
            if(day + trees[i] > max){
                max = day + trees[i];
            }
            day++;
        }
        max += 1;

        System.out.println(max);
    }
}
