package com.baekjoon.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 1744번, 수 묶기
public class Practice17 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Long[] numbers = new Long[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextLong();
        }

        ArrayList<Long> plusNumbers = new ArrayList<>();
        ArrayList<Long> minusNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] >= 0)
                plusNumbers.add(numbers[i]);
            else
                minusNumbers.add(numbers[i]);
        }

        Collections.sort(plusNumbers,Collections.reverseOrder());
        Collections.sort(minusNumbers);

        long answer = 0;
        boolean[] plusVisited = new boolean[plusNumbers.size()];
        boolean[] minusVisited = new boolean[minusNumbers.size()];
        boolean zeroYn = false;

        for (int i = 0; i < plusNumbers.size(); i++) {
            if(!plusVisited[i]) {
                if(plusNumbers.get(i) == 0) {
                    zeroYn = true;
                    continue;
                }
                if(i != plusNumbers.size() -1){
                    if(plusNumbers.get(i) != 0 && plusNumbers.get(i+1) !=0 &&
                       plusNumbers.get(i) * plusNumbers.get(i + 1) > plusNumbers.get(i) + plusNumbers.get(i + 1)) {
                        answer += plusNumbers.get(i) * plusNumbers.get(i + 1);
                        plusVisited[i] = true;
                        plusVisited[i + 1] = true;
                    }else{
                        answer += plusNumbers.get(i);
                        plusVisited[i] = true;
                    }
                }
                else {
                    answer += plusNumbers.get(i);
                    plusVisited[i] = true;
                }
            }
        }

        for (int i = 0; i < minusNumbers.size(); i++) {
            if(!minusVisited[i]) {
                if(i != minusNumbers.size() -1){
                    if(minusNumbers.get(i) * minusNumbers.get(i + 1) > minusNumbers.get(i) + minusNumbers.get(i + 1)) {
                        answer += minusNumbers.get(i) * minusNumbers.get(i + 1);
                        minusVisited[i] = true;
                        minusVisited[i + 1] = true;
                    }
                    else{
                        answer += minusNumbers.get(i);
                        minusVisited[i] = true;
                    }
                }
                else {
                    if (!zeroYn) {
                        answer += minusNumbers.get(i);
                        minusVisited[i] = true;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
