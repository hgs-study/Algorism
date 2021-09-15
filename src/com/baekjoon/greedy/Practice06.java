package com.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

// 16953번,  A->B
public class Practice06 {

    private long answer=Integer.MAX_VALUE;
    private long count = Integer.MAX_VALUE;

    private long dfs(long end, long result,long depth){
        if(end == result) {
            count = depth;
            return count;
        }

        if(end < result)
            return Integer.MAX_VALUE;

        dfs(end, result * 2,depth +1);
        dfs(end,(result * 10) + 1,depth +1);

        return count;
    }

    public static void main(String[] args) {
        Practice06 practice06 = new Practice06();
        Scanner scanner = new Scanner(System.in);
        long start = scanner.nextInt();
        long end = scanner.nextInt();

        long result = 0;
        if( Math.min(practice06.count, practice06.dfs(end, start, 1)) == Integer.MAX_VALUE)
            result = -1;
        else
            result = Math.min(practice06.count, practice06.dfs(end, start, 1));

        System.out.print(result);
    }
}
