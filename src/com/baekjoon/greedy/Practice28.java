package com.baekjoon.greedy;

import java.util.Scanner;

// 15904번, UCPC는 무엇의 약자일까?
public class Practice28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int check =0;
        for (char c : str.toCharArray()) {
            if(check == 0 && c == 'U')
                check ++;
            if(check == 1 && c == 'C')
                check ++;
            if(check == 2 && c == 'P')
                check ++;
            if(check == 3 && c == 'C')
                check ++;
        }

        if(check == 4)
            System.out.println("I love UCPC");
        else
            System.out.println("I hate UCPC");
    }
}
