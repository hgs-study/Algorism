package com.baekjoon.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

// 1715번, 카드 정렬하기(우선순위큐)
public class Practice14{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < count; i++) {
            priorityQueue.add(scanner.nextLong());
        }

        long num = 0;
        //우선순위 큐에 2개 이상 들어있어야 비교 가능
        while(priorityQueue.size() > 1){
            long temp1 = priorityQueue.poll();
            long temp2 = priorityQueue.poll();

            num += temp1 + temp2;
            priorityQueue.add(temp1 + temp2); //합한 묶음 다시 넣기
        }
        System.out.print(num);
    }
}
