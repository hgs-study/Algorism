package com.baekjoon.string;

import java.util.Scanner;

// 8958번, OX퀴즈
public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            String str = scanner.next();
            char[] charArr = str.toCharArray();
            int answer = 0;
            int cnt = 0;

            for (int j = 0; j < charArr.length; j++) {
                if(charArr[j] == 'O')
                    cnt++;
                else
                    cnt = 0;

                answer += cnt;
            }
            System.out.println(answer);
        }
    }
}
