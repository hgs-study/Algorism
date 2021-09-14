package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

// 16435 스네이크 버드
public class Practice01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int length = scanner.nextInt();
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        for (int number : numbers) {
            if(number <= length)
                length++;
        }

        System.out.println(length);
    }
}
