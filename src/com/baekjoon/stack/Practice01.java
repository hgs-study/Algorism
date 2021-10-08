package com.baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

// 10773번, 제로
public class Practice01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Stack<Integer> stack = new Stack();
        int max = 0;

        for (int i = 0; i < count; i++) {
            int number = scanner.nextInt();

            if(number != 0)
                stack.push(number);
            else
                stack.pop();
        }

        while (!stack.isEmpty()){
            max += stack.peek();
            stack.pop();
        }

        System.out.println(max);
    }
}
