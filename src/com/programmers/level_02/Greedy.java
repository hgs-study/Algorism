package com.programmers.level_02;

import java.util.Arrays;

public class Greedy {

    //큰 수 만들기
    //문제 설명
    //어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
    //예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
    //문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
    //number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
    //
    //제한 조건
    //number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
    //k는 1 이상 number의 자릿수 미만인 자연수입니다.
    //입출력 예
    //number	k	return
    //"1924"	2	"94"
    //"1231234"	3	"3234"
    //"4177252841"	4	"775841"
    public String solution1_1(String number, int k) {
        int idx = 0;
        char max;
        StringBuilder answer = new StringBuilder();

        if(number.charAt(0) == '0')
            return "0";

        for(int i = 0; i < number.length() - k; i++) {
            max = '0';
            for(int j = idx; j <= k + i; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }


    //구명보트
    //문제 설명
    //무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
    //
    //예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
    //
    //구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
    //
    //사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
    //
    //제한사항
    //무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
    //각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
    //구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
    //구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.
    //입출력 예
    //people	limit	return
    //[70, 50, 80, 50]	100	3
    //[70, 80, 50]	100	3
    //
    //내 풀이
    //테케는 맞지만 채점하면 거의 다 틀림
    public int solution2_1(int[] people, int limit) {
        int answer = people.length;
        int gap = 0;
        boolean[] visited = new boolean[people.length];

        for (int i = 0; i < people.length; i++) {
            int index = 0;
            int min = Integer.MAX_VALUE;
            if(!visited[i]) {
                gap = limit - people[i];
                for (int j = 0; j < people.length; j++) {
                    if (i != j && people[j] <= gap) {
                        System.out.println(2222);
                        if(gap - people[j] < min) {
                            min = gap - people[j];
                            index = j;
                        }
                    }
                }
            }
            if(index != 0) {
                visited[index] = true;
                answer -= 1;
            }
        }

        return answer;
    }

    //사람들 풀이
    public static int solution2_2(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }

}
