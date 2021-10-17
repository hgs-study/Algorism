package com.baekjoon.sort;

import java.util.*;

// 10867번, 중복 빼고 정렬하기
public class Practice03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < count; i++) {
            set.add(scanner.nextInt());
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
