package com.baekjoon.greedy;

import java.util.Scanner;

// 2839번
public class Practice42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputValue = scanner.nextInt();
        int result = 0;

        while (inputValue != 0){
            if(inputValue % 5 == 0){
                result += inputValue / 5;
                break;
            }else if(inputValue < 0){
                result = -1;
                break;
            }
            inputValue -= 3;
            result++;
        }

        System.out.println(result);
    }
}
