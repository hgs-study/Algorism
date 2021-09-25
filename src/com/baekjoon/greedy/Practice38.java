package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 2차원 배열 내림차순
public class Practice38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[][] numbers = new int[count][2];
        for (int i = 0; i < count; i++) {
            numbers[i][0] = scanner.nextInt();
            numbers[i][1] = scanner.nextInt();
        }

        Arrays.sort(numbers, ((o1, o2) -> { // 내림차순
            if(o1[0]==o2[0]) { // [0][0]이 같으면
                return o2[1]-o1[1]; //[1]로 비교
            }
            return o2[0]-o1[0];
        }));

    }
}
