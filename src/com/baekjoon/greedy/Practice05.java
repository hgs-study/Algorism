package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

// 11497번, 통나무 건너뛰기
public class Practice05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();

        for (int i = 0; i < testCount; i++) {
            int treeCount = scanner.nextInt();
            int[] trees = new int[treeCount];
            for (int j = 0; j < treeCount; j++) {
                trees[j] = scanner.nextInt();
            }

            Arrays.sort(trees);

            int left = 0;
            int right = treeCount - 1;
            int[] arr = new int[treeCount];

            for (int j = 0; j < treeCount; j++) {
                if(j % 2 == 0) {
                    arr[left] = trees[j];
                    left += 1;
                }
                else{
                    arr[right] = trees[j];
                    right -=1;
                }
            }

            int min = 0;
            for (int j = 1 ; j < arr.length; j++) {
                min = Math.max(min, Math.abs(arr[j]- arr[j-1]));
            }

            System.out.println(min);
        }
    }
}
