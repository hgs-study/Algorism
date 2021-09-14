package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

// 11399번 ATM
public class Practice02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }
        Arrays.sort(numbers);

        int sum = 0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j <= i; j++) {
                sum += numbers[j];
            }
        }
        System.out.println(sum);
    }
}
