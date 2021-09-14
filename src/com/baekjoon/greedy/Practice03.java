package com.baekjoon.greedy;

import java.util.Scanner;

// 5585번 거스름돈
public class Practice03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        int change, answer = 0;
        int[] money = {500,100,50,10,5,1};
        change = 1000 - count;

        for (int i : money) {
            answer += change / i;
            change %= i;
        }
        System.out.println(answer);
    }
}
