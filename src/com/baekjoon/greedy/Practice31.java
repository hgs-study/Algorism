package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// 13904번, 과제
public class Practice31 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        int[][] works = new int[count][2];
        boolean[] visited = new boolean[count];
        for (int i = 0; i < count; i++) {
            works[i][0] = scanner.nextInt();
            works[i][1] = scanner.nextInt();
        }

        Arrays.sort(works, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1],o1[1]);
            }
        });

        int[] scores = new int[1001];	// 정수 N의 범위 - 1~1000
        for(int i=0; i<count; i++) {		// 과제 점수가 높은 순
            for(int j=works[i][0]; j>0; j--) {	// 과제의 마감일로부터 최대한 늦게 과제 하기
                if(scores[j] == 0) {
                    scores[j] = works[i][1];
                    break;
                }
            }
        }
        int maxScores = 0;
        for(int i=0; i<scores.length; i++)
            maxScores += scores[i];

        System.out.println(maxScores);
    }
}
