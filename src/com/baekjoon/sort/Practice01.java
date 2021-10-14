package com.baekjoon.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 10814번, 나이순 정렬
public class Practice01 {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int count = scanner.nextInt();
        List<People> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new People(scanner.nextInt(),scanner.next()));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).age+" "+ list.get(i).name);
        }

    }

    private static class People implements Comparable<People>{
        int age;
        String name;

        public People(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(People o) {
            return age - o.age;
        }
    }
}