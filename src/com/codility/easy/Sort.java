package com.codility.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Sort {

    //Write a function
    //
    //class Solution { public int solution(int[] A); }
    //
    //that, given an array A consisting of N integers, returns the number of distinct values in array A.
    //
    //For example, given array A consisting of six elements such that:
    //
    // A[0] = 2    A[1] = 1    A[2] = 1
    // A[3] = 2    A[4] = 3    A[5] = 1
    //the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
    //
    //Write an efficient algorithm for the following assumptions:
    //
    //N is an integer within the range [0..100,000];
    //each element of array A is an integer within the range [−1,000,000..1,000,000].
    //Copyright 2009–2021 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
    //
    //함수 작성
    //
    //클래스 솔루션 { 공개 int 솔루션(int[] A); }
    //
    //N개의 정수로 구성된 배열 A가 주어지면 배열 A의 고유 값 수를 반환합니다.
    //
    //예를 들어 주어진 배열 A는 다음과 같은 6개의 요소로 구성됩니다.
    //
    // A[0] = 2 A[1] = 1 A[2] = 1
    // A[3] = 2 A[4] = 3 A[5] = 1
    //배열 A에 1, 2, 3이라는 3개의 고유한 값이 나타나기 때문에 함수는 3을 반환해야 합니다.
    //
    //다음 가정에 대한 효율적인 알고리즘을 작성하십시오.
    //
    //N은 [0..100,000] 범위 내의 정수입니다.
    //배열 A의 각 요소는 [−1,000,000..1,000,000] 범위의 정수입니다.
    //저작권 2009–2021 by Codility Limited. 판권 소유. 무단 전재, 출판, 공개를 금합니다.
    // 8%
    public int solution1_1(int[] A) {
        // write your code in Java SE 8
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if(map.containsKey(A[i]))
                count++;
            else
                map.put(A[i],0);
        }

        return count;
    }

    //100%
    public int solution1_2(int[] A) {
        // write your code in Java SE 8
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            hashSet.add(A[i]);
        }

        return hashSet.size();
    }
}
