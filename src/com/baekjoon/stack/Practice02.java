package com.baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

// 9012번, 괄호
public class Practice02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            String bracket = scanner.next();
            Stack<Character> stack = new Stack<>();
            for (char c : bracket.toCharArray()) {
                if(c == '(')
                    stack.push('(');
                else
                    if(!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else
                        stack.push(')');
            }

            String answer = "NO";
            if(stack.isEmpty())
                answer = "YES";

            System.out.println(answer);
        }
    }
}
