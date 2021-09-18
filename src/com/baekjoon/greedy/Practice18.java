package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

// 2437번, 저울
public class Practice18 {

    //답은 나오지만 시간초과..
//    private static int min = 0;
//
//    public static void main(String[] args) {
//        Practice18 practice18 = new Practice18();
//        Scanner scanner = new Scanner(System.in);
//        int count = scanner.nextInt();
//        int[] numbers = new int[count];
//        for (int i = 0; i < count; i++) {
//            numbers[i] = scanner.nextInt();
//        }
//
//        practice18.dfs(numbers, 0, 0);
//
//        System.out.println(min);
//    }
//
//    private void dfs(int[] numbers, int depth, int sum){
//        if(sum == min && depth !=0) {
//            min++;
//            dfs(numbers, 0, 0);
//        }
//
//        if(numbers.length == depth)
//            return;
//
//        dfs(numbers,depth +1, sum);
//        dfs(numbers,depth +1, sum + numbers[depth]);
//    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr = new int[N];
        int sum = 1;
        for(int i=0; i<N; i++)
            arr[i] = scan.nextInt();

        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++) {
            if(sum < arr[i])
                break;
            sum += arr[i];
        }

        System.out.println(sum);
        scan.close();
    }
}
