package com.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

// 2750번, 수 정렬하기
public class Practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
