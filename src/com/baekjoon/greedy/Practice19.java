package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// 1449번, 수리공 항승
public class Practice19 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int length = scanner.nextInt();
        int realLength = length;

        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        int answer = 0;
        for(int i=0; i<count; i++) {
            if(i == count-1) {
                answer++;
                break;
            }
            length = realLength;
            while(count > i+1) {
                if(numbers[i+1] - numbers[i] + 1 <= length) {
                    length -= numbers[i+1] - numbers[i] ;
                    i++;
                }
                else {
                    break;
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}
