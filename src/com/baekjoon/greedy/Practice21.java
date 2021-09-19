package com.baekjoon.greedy;

import java.util.Scanner;

//2702번, 세탁소 사장 동혁
public class Practice21 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        int loopCount = 0;
        while (loopCount !=count){
            int total = numbers[loopCount];

            int answerA = 0;
            int answerB = 0;
            int answerC = 0;
            int answerD = 0;

            answerA += total / 25;
            total %= 25;

            answerB += total / 10;
            total %= 10;

            answerC += total / 5;
            total %= 5;

            answerD += total / 1;
            total %= 1;

            System.out.println(answerA+" "+ answerB+ " "+ answerC+ " "+answerD+" ");
            loopCount++;
        }
    }
}
