package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 11508번, 2+1 세일
public class Practice37 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Integer[] numbers = new Integer[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers, Collections.reverseOrder());

        long sum = 0;
        for (int i = 0; i < count; i++) {
           if((i+1) % 3 != 0)
               sum += numbers[i];
        }

        System.out.println(sum);
    }

}
