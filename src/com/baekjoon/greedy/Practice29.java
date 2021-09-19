package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 14241번, 슬라임 합치기
public class Practice29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Integer[] numbers = new Integer[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers,Collections.reverseOrder());

        int sum = 0;
        int score = 0;
        for (int i = 0; i < numbers.length ; i++) {
            score = score + sum * numbers[i];
            sum = sum + numbers[i];
        }

        System.out.println(score);
    }
}
