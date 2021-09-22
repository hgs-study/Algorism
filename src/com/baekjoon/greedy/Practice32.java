package com.baekjoon.greedy;

import java.util.Scanner;

// 1343번, 폴리오미노
public class Practice32 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuffer sb = new StringBuffer();

        char[] chars = str.toCharArray();
        boolean[] visited = new boolean[chars.length];
        int xCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'X'){
                xCount++;
            }
            else{
                if (xCount %2 == 1){
                    sb = new StringBuffer();
                    sb.append(-1);
                    System.out.println(sb);
                    return;
                }
                while ( xCount != 0){
                    if(xCount >= 4){
                        sb.append("AAAA");
                        xCount -= 4;
                    }else{
                        sb.append("BB");
                        xCount -= 2;
                    }
                }
                sb.append(".");
            }
        }
        if(xCount != 0) {
            if (xCount % 2 == 1) {
                sb = new StringBuffer();
                sb.append(-1);
                System.out.println(sb);
                return;
            } else {
                while (xCount != 0) {
                    if (xCount >= 4) {
                        sb.append("AAAA");
                        xCount -= 4;
                    } else {
                        sb.append("BB");
                        xCount -= 2;
                    }
                }
            }
        }
        System.out.print(sb.toString());
    }
}
