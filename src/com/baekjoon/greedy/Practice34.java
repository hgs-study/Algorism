package com.baekjoon.greedy;

import java.util.Scanner;

// 12904번, A와B
public class Practice34 {
//    dfs로 풂, 테케 정답으로 나오지만 시간초과 ( S -> T)
//    private static int answer = 0;
//
//    private static int dfs(String S, String T, String sum, int depth){
//        if(depth == T.length() +1)
//            return 0;
//
//        if(depth == T.length() && sum.equals(T)) {
//            return 1;
//        }else{
//            dfs(S,T,sum+"A",depth+1);
//            dfs(S,T,new StringBuffer(sum).reverse().toString() + "B",depth+1);
//        }
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String S = scanner.next();
//        String T = scanner.next();
//
//        answer = Math.max(answer, dfs(S,T,S,1));
//        System.out.println(answer);
//    }

//( T -> S)
    private static int answer = 0;

    private static int dfs(String S, String T, String sum, int depth){
        if(depth == S.length() -1)
            return answer;

        if(depth == S.length() && sum.equals(S)) {
            answer = 1;
            return answer;
        }

        if(sum.charAt(sum.length() - 1) == 'A'){
            dfs(S,T,sum.substring(0, sum.length() -1), depth -1);
        }
        else if(sum.charAt(sum.length() -1) == 'B'){
            sum = sum.substring(0, sum.length() -1);
            dfs(S,T,new StringBuffer(sum).reverse().toString() , depth-1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        String T = scanner.next();

        answer = Math.max(answer, dfs(S,T,T,T.length()));
        System.out.println(answer);
    }

}
