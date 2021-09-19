package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

// 15903번, 카드 합체 놀이
public class Practice24 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        long mix = scanner.nextInt();
        long[] numbers = new long[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        long sum = 0;
        for (long i = 0; i < mix; i++) {
            Arrays.sort(numbers);

            sum = numbers[0] + numbers[1];
            numbers[0] = sum;
            numbers[1] = sum;
        }


        long answer = 0;
        for (long number : numbers) {
            answer += number;
        }

        System.out.print(answer);
    }
}
