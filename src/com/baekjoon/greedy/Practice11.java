package com.baekjoon.greedy;

import java.util.Scanner;


// 10162번, 전자레인지
public class Practice11 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int total = scanner.nextInt();
        int[] change = new int[3];

        if(total >= 300) {
            change[0] += total / 300;
            total %= 300;
        }

        if(total >= 60) {
            change[1] += total / 60;
            total %= 60;
        }

        if(total >= 10){
            change[2] += total / 10;
            total %= 10;
        }


        if(total == 0 ){
            for (int i = 0; i < change.length; i++) {
                System.out.print(change[i] + " ");
            }
        }
        else{
            System.out.print("-1");
        }
    }
}
