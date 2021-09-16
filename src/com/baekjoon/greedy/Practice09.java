package com.baekjoon.greedy;

import java.util.Scanner;

// 2839번, 설탕배달
public class Practice09 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        while (true) {
            if (n % 5 == 0) {
                answer += n / 5;
                break;
            }

            n = n - 3;
            answer++;

            if (n < 0) {
                answer = -1;
                break;
            }
        }
        System.out.println(answer);
    }
}
