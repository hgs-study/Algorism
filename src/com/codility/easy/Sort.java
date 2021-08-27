package com.codility.easy;

import java.util.Arrays;
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


    //A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
    //
    //For example, array A such that:
    //
    //  A[0] = -3
    //  A[1] = 1
    //  A[2] = 2
    //  A[3] = -2
    //  A[4] = 5
    //  A[5] = 6
    //contains the following example triplets:
    //
    //(0, 1, 2), product is −3 * 1 * 2 = −6
    //(1, 2, 4), product is 1 * 2 * 5 = 10
    //(2, 4, 5), product is 2 * 5 * 6 = 60
    //Your goal is to find the maximal product of any triplet.
    //
    //Write a function:
    //
    //class Solution { public int solution(int[] A); }
    //
    //that, given a non-empty array A, returns the value of the maximal product of any triplet.
    //
    //For example, given array A such that:
    //
    //  A[0] = -3
    //  A[1] = 1
    //  A[2] = 2
    //  A[3] = -2
    //  A[4] = 5
    //  A[5] = 6
    //the function should return 60, as the product of triplet (2, 4, 5) is maximal.
    //
    //Write an efficient algorithm for the following assumptions:
    //
    //N is an integer within the range [3..100,000];
    //each element of array A is an integer within the range [−1,000..1,000].

    //N개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다. 삼중항(P, Q, R)의 곱은 A[P] * A[Q] * A[R]과 같습니다(0 ≤ P < Q < R < N).
    //
    //예를 들어, 다음과 같은 배열 A:
    //
    //   A[0] = -3
    //   A[1] = 1
    //   A[2] = 2
    //   A[3] = -2
    //   A[4] = 5
    //   A[5] = 6
    //다음 예제 삼중항이 포함되어 있습니다.
    //
    //(0, 1, 2), 곱은 −3 * 1 * 2 = −6
    //(1, 2, 4), 제품은 1 * 2 * 5 = 10
    //(2, 4, 5), 제품은 2 * 5 * 6 = 60
    //당신의 목표는 모든 삼중항의 최대 곱을 찾는 것입니다.
    //
    //함수 작성:
    //
    //클래스 솔루션 { 공개 int 솔루션(int[] A); }
    //
    //비어 있지 않은 배열 A가 주어지면 모든 삼중항의 최대 곱 값을 반환합니다.
    //
    //예를 들어, 주어진 배열 A는 다음과 같습니다.
    //
    //   A[0] = -3
    //   A[1] = 1
    //   A[2] = 2
    //   A[3] = -2
    //   A[4] = 5
    //   A[5] = 6
    //함수는 3중항(2, 4, 5)의 곱이 최대이므로 60을 반환해야 합니다.
    //
    //다음 가정에 대한 효율적인 알고리즘을 작성하십시오.
    //
    //N은 [3..100,000] 범위 내의 정수입니다.
    //배열 A의 각 요소는 [−1,000..1,000] 범위의 정수입니다.
    public int solution2_1(int[] A) {
        Arrays.sort(A);

        int li = A.length - 1;
        int number = A[li];
        int leftNum = number * A[li -1] * A[li -2];
        int rightNum = number * A[0] * A[1];
        return Math.max(leftNum,rightNum);
    }
}
