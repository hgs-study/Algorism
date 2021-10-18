package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 1026번, 보물
public class Practice40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        String[] aStrArr = a.split(" ");
        String[] bStrArr = b.split(" ");

        Integer[] aArr = new Integer[count];
        Integer[] bArr = new Integer[count];

        for (int i = 0; i < count; i++) {
            aArr[i] = Integer.valueOf(aStrArr[i]);
            bArr[i] = Integer.valueOf(bStrArr[i]);
        }

        Arrays.sort(aArr);
        Arrays.sort(bArr, Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < count; i++) {
            answer += aArr[i] * bArr[i];
        }

        System.out.println(answer);
    }
}
