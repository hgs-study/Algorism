package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 2212번, 센서
public class Practice26 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int center = scanner.nextInt();

        int[] numbers= new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);
        Integer[] distances = new Integer[count -1];
        for (int i = 0; i < count -1; i++) {
            distances[i] = numbers[i+1] - numbers[i];
        }

        Arrays.sort(distances, Collections.reverseOrder());

        int answer = 0;
        for (int i = center - 1; i < distances.length; i++) {
            answer += distances[i];
        }

        System.out.println(answer);
    }
}
