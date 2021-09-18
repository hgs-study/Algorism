package com.baekjoon.greedy;

import java.util.Scanner;

// 1543번, 문서검색
public class Practice20 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        String search = scanner.nextLine();
        int count = 0;

        while (sentence.indexOf(search) > -1){
            count++;
            sentence = sentence.substring(sentence.indexOf(search) +  search.length());
        }

        System.out.println(count);
    }
}
