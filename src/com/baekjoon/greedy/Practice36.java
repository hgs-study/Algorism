package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

// 14487번, 욱제는 효도쟁이야!!
public class Practice36 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }
        Arrays.sort(numbers);

        int sum =0;
        for (int i = 0; i < count - 1; i++) {
            sum += numbers[i];
        }
        System.out.println(sum);
    }
}
