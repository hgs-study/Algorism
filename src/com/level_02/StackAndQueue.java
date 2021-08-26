package com.level_02;

import java.util.*;

//문제 설명
//프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
//
//또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
//이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
//
//먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
// 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
public class StackAndQueue {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue days = new LinkedList();
        Stack result = new Stack();

        for(int i=0; i<progresses.length; i++){
            days.add((int)Math.ceil((100 - progresses[i]) / (double)speeds[i]));
        }

        int workingDay = 0;
        while(!days.isEmpty()){
            if(workingDay >= (int)days.peek()){
                int temp = (int)result.pop()+1;
                result.push(temp);
            } else {
                result.push(1);
                workingDay = (int)days.peek();
            }
            days.poll();
        }

        answer = new int[result.size()];
        int idx = result.size()-1;
        while(!result.isEmpty()){
            answer[idx] = (int)result.pop();
            idx--;
        }

        return answer;

    }



    //문제 설명
    //짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다. 먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다. 그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다. 이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다.
    //문자열 S가 주어졌을 때, 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성해 주세요. 성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴해주면 됩니다.
    //예를 들어, 문자열 S = baabaa 라면
    //
    //b aa baa → bb aa → aa →
    //
    //의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.
    //
    //제한사항
    //문자열의 길이 : 1,000,000이하의 자연수
    //문자열은 모두 소문자로 이루어져 있습니다.
    //
    //입출력 예
    //s	result
    //baabaa	1
    //cdcd	0
    public int solution2_1(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray())
            if(!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);

        return stack.isEmpty() ? 1 : 0;
    };


    //문제 설명
    //초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
    //
    //제한사항
    //prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
    //prices의 길이는 2 이상 100,000 이하입니다.
    //입출력 예
    //prices	return
    //[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
    public int[] solution3_1(int[] prices) {

        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i+1; j < prices.length; j++) {
                if(j == prices.length -1) {
                    count++;
                    answer[i] = count;
                    break;
                }
                count++;
                if(prices[i] > prices[j]){
                    answer[i] = count;
                    break;
                }
            }
        }
        return answer;
    }
}
