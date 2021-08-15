package com.level_02;

import java.util.*;

public class Sort {

    // 문제 설명
    //0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
    //예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
    //0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
    //
    //제한 사항
    //numbers의 길이는 1 이상 100,000 이하입니다.
    //numbers의 원소는 0 이상 1,000 이하입니다.
    //정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
    //
    //입출력 예
    //numbers	return
    //[6, 10, 2]	"6210"
    //[3, 30, 34, 5, 9]	"9534330"
    public String solution1_1(int[] numbers) {
        String answer = "";
        ArrayList<String> arrayList = new ArrayList<>();
        for (int number : numbers) {
            arrayList.add(String.valueOf(number));
        }

        Collections.sort(arrayList, (a,b) -> (b+a).compareTo(a+b));

        if (arrayList.get(0).startsWith("0"))
            return "0";

        for (String s : arrayList) {
            answer += s;
        }

        return answer;
    }


    //문제 설명
    //H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
    //어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
    //어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
    //
    //제한사항
    //과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
    //논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
    //
    //입출력 예
    //citations	return
    //[3, 0, 6, 1, 5]	3
    public int solution2_1(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }



}
