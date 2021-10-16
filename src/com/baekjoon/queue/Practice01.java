package com.baekjoon.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 2164번, 카드2
public class Practice01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= number; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1){
            queue.poll();
            int addNumber =  queue.poll();
            queue.offer(addNumber);
        }

        System.out.println(queue.peek());
    }
}
