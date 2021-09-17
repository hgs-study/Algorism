package com.baekjoon.greedy;

import java.util.Scanner;

// 13305번, 주유소
public class Practice13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        long[] distances = new long[count - 1];
        long[] countries = new long[count];

        for (int i = 0; i < count - 1; i++) {
            distances[i] = scanner.nextInt();
        }
        for (int i = 0; i < count; i++) {
            countries[i] = scanner.nextInt();
        }

        long min = 0;
        long sum = 0;
        sum = countries[0] * distances[0];
        min = countries[0];

        for (int i = 1; i < count - 1; i++) {
            if(countries[i] < min){
                min = countries[i];
            }
            sum += (min * distances[i]);
        }

        System.out.println(sum);
    }
}
