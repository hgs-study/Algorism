package com.baekjoon.greedy;

import java.util.ArrayList;
import java.util.Scanner;

// 1439번, 뒤집기
public class Practice16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        ArrayList<Integer> zeros = new ArrayList<>();
        ArrayList<Integer> ones = new ArrayList<>();

        for (int i = 0; i < str.toCharArray().length; i++) {
            if(str.toCharArray()[i] == '0')
                zeros.add(i);
            else
                ones.add(i);
        }

        long zeroCount = 1;
        long oneCount = 1;
        for (int i = 1; i < zeros.size(); i++) {
            if(zeros.get(i) - zeros.get(i-1) != 1)
                zeroCount++;
        }
        for (int i = 1; i < ones.size(); i++) {
            if(ones.get(i) - ones.get(i-1) != 1)
                oneCount++;
        }

        if(zeros.size() == 0 || ones.size() ==0)
            System.out.println(0);
        else
            System.out.println(Math.min(zeroCount,oneCount));
    }
}
