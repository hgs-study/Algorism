package com.baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

// 3986번, 좋은단어
public class Practice05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        int answer = 0;
        for (int i = 0; i < count; i++) {
            Stack<Character> stack = new Stack<>();
            String str = scanner.next();

            for (char c : str.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                if (stack.peek() == c)
                    stack.pop();
                else
                    stack.push(c);
            }

            if (stack.isEmpty())
                answer += 1;
        }

        System.out.println(answer);
    }
}
