package com.level_01;

import java.util.*;
import java.util.stream.Stream;

public class FullSearch {



    //문제 설명
    //수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
    //
    //1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    //2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    //3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
    //
    //1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
    //
    //제한 조건
    //시험은 최대 10,000 문제로 구성되어있습니다.
    //문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
    //가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
    //
    //입출력 예
    //answers	return
    //[1,2,3,4,5]	[1]
    //[1,3,2,4,2]	[1,2,3]

    //문제 (2/15)개 통과
    public int[] solution1_1(int[] answers) {
        int[] answer = {};

        int[] firstStudent = {1,2,3,4,5};
        int[] secondStudent = {2,1,2,3,2,4,2,5};
        int[] thirdStudent = {3,3,1,1,2,2,4,4,5,5};

        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;

        for (int i = 0; i < answers.length; i++) {
            firstCount = (firstStudent[i] == answers[i]) ? firstCount + 1 : firstCount;
            secondCount = (secondStudent[i] == answers[i]) ? secondCount + 1 : secondCount;
            thirdCount = (thirdStudent[i] == answers[i]) ? thirdCount + 1 : thirdCount;
        }

        Integer[] result = {firstCount,secondCount,thirdCount};

        Arrays.sort(result, Comparator.reverseOrder());

        if(result[0] == result[1] &&  result[1] ==result[2])
            answer = new int[] {1,2,3};
        else if (result[0] == result[1])
            answer = new int[] {1,2};
        else
            answer = new int[] {1};

        return answer;
    }


    public int[] solution1_2(int[] answers) {
        int[] firstStudent = {1,2,3,4,5};
        int[] secondStudent = {2,1,2,3,2,4,2,5};
        int[] thirdStudent = {3,3,1,1,2,2,4,4,5,5};

        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;

        for (int i = 0; i < answers.length; i++) {
            firstCount = (firstStudent[i%5] == answers[i]) ? firstCount + 1 : firstCount;
            secondCount = (secondStudent[i%8] == answers[i]) ? secondCount + 1 : secondCount;
            thirdCount = (thirdStudent[i%10] == answers[i]) ? thirdCount + 1 : thirdCount;
        }

        int max = Math.max(Math.max(firstCount,secondCount),thirdCount);

        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max==firstCount) list.add(1);
        if(max==secondCount) list.add(2);
        if(max==thirdCount) list.add(3);

        Collections.sort(list);

        return list.stream().mapToInt(i -> i).toArray();
    }

}
