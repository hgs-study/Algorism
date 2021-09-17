package com.baekjoon.greedy;

import java.util.Scanner;


// 10162번, 전자레인지
public class Practice11 {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int total = scanner.nextInt();
        int sum = total;
        int[] change = new int[3];

        if(500 <= total) {
            change[0] += total / 300;
            total %= 300;
        }
        if(60 <= total) {
            change[1] += total / 60;
            total %= 60;
        }

        change[2] += total / 10;
        total %= 10;

        if(change[0]*500 + change[1]*60 + change[2]*10 == sum )
            System.out.print(change[0] + " " + change[1] + " " +change[2] );
        else
            System.out.print(-1);
    }
}
