package com.baekjoon.greedy;

import java.util.Scanner;

// 14916번, 거스름돈
public class Practice25 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();

        int answer = 0;
        while (true){
            if(total % 5 == 0){
                answer += total / 5;
                break;
            }
            total -= 2;
            answer++;
            if(total < 0){
                answer = -1;
                break;
            }
        }
        System.out.println(answer);
    }
}
