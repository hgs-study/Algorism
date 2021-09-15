package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//11047번, 동전 0
public class Practice04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count  = scanner.nextInt();
        int totalMoney = scanner.nextInt();

        Integer[] money = new Integer[count];
        for (int i = 0; i < count; i++) {
            money[i] = scanner.nextInt();
        }

        Arrays.sort(money, Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < count; i++) {
            answer += totalMoney / money[i];
            totalMoney %= money[i];
        }

        System.out.println(answer);
    }
}
