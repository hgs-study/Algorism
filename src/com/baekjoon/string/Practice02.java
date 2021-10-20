package com.baekjoon.string;

import java.util.*;

// 1316번, 그룹 단어 체커
public class Practice02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int answer = total;

        for (int i = 0; i < total; i++) {
            String str = scanner.next();
            char[] chars = str.toCharArray();
            int count = 1;
            Map<Character,Integer> map = new HashMap<>();

            while (true){
                if(count == chars.length)
                    break;

                if(chars[count-1] != chars[count]) {
                    if (map.containsKey(chars[count])) {
                        answer -= 1;
                        break;
                    }
                }
                map.put(chars[count -1], 1);

                count++;
            }
        }
        System.out.println(answer);
    }
}
