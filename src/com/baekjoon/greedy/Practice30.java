package com.baekjoon.greedy;

import java.util.Scanner;

// 14659번, 한조서열정리하고옴ㅋㅋ
public class Practice30 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        int killCount = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            killCount = 0;
            for (int j = i+1; j < count; j++) {
                if(numbers[i] > numbers[j]) {
                    killCount++;
                }else
                    break;
            }
            max = Math.max(max, killCount);
        }
        System.out.print(max);
    }
}
