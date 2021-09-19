package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

// 11497번, 통나무 건너뛰기
public class Practice27 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for (int i = 0; i < total; i++) {
            int count = scanner.nextInt();
            long[] numbers = new long[count];

            for (int j = 0; j < count; j++) {
                numbers[j] = scanner.nextLong();
            }

            Arrays.sort(numbers);
            int left = 0;
            int right = numbers.length - 1;

            long[] changeNumbers = new long[count];

            for (int j = 0; j < count; j++) {
                if(j %2 ==0) {
                    changeNumbers[left] = numbers[j];
                    left++;
                }
                else {
                    changeNumbers[right] = numbers[j];
                    right--;
                }
            }

            long max = Long.MIN_VALUE;
            for (int j = 0; j < count; j++) {
                if( j == count -1)
                    break;
                if(Math.abs(changeNumbers[j+1] - changeNumbers[j]) > max)
                    max = Math.abs(changeNumbers[j+1] - changeNumbers[j]);
            }

            System.out.println(max);
        }
    }
}
