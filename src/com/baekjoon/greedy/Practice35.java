package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

// 2012번, 등수 매기기
public class Practice35 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += Math.abs(numbers[i-1]-i);
        }
        System.out.print(sum);
    }
}
