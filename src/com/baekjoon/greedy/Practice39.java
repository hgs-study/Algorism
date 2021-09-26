package com.baekjoon.greedy;

import java.util.Scanner;

// 3135번, 라디오
public class Practice39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int[] moves = new int[n];
        for (int i = 0; i < n; i++) {
            moves[i] = scanner.nextInt();
        }

        int gap = Math.abs(b - a);
        int moveGap = 0;
        for (int i = 0; i < n; i++) {
            moveGap = 1;
            moveGap += Math.abs(moves[i] - b);
            if(gap > moveGap){
                gap = moveGap;
            }
        }

        System.out.println(gap);
    }
}
