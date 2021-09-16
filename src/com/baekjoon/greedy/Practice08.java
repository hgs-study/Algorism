package com.baekjoon.greedy;

import java.util.ArrayList;
import java.util.Scanner;

// 14487번, 욱제는 효도쟁이야
public class Practice08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(scanner.nextInt());
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) > max) {
                max = numbers.get(i);
                maxIndex = i;
            }
        }
        numbers.remove(maxIndex);
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.print(sum);
    }
}
