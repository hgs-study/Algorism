package com.baekjoon.greedy;

import java.util.Scanner;

// 1789번, 수들의 합
public class Practice12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long s = scanner.nextLong();
        int count = 0;
        long total = 0;

        while (true){
            count++;
            total += count;

            if(total > s)
                break;
        }
        System.out.println(count - 1);
    }
}
