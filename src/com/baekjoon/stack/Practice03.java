package com.baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

// 12605번, 단어순서 뒤집기
public class Practice03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            Stack<String> stack = new Stack<>();
            String[] strs = scanner.nextLine().split(" ");

            for (int j = 0; j < strs.length; j++) {
                stack.push(strs[j]);
            }

            System.out.print("Case #" + (i+1) + ": ");
            while (!stack.isEmpty()) {
                System.out.print(stack.peek() + " ");
                stack.pop();
            }
            System.out.println();
        }
    }
}
