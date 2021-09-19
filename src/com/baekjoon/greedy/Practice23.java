package com.baekjoon.greedy;

import java.util.Scanner;

// 2810번, 컵홀더
public class Practice23 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count= scanner.nextInt();
        String str = scanner.next();

        int sum = 0;
        for (char c : str.toCharArray()) {
            if(c =='L')
                sum++;
        }
        sum /= 2;
        if(sum>0)
            sum -= 1;

        System.out.println(count - sum);
    }
}
