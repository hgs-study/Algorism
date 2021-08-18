package com.programmers.level_02;

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
    //일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
    //
    //1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
    //2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
    //3. 그렇지 않으면 J를 인쇄합니다.
    //
    //예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
    //내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
    //현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
    //
    //제한사항
    //현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
    //인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
    //location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
    //
    //입출력 예
    //priorities	location	return
    //[2, 1, 3, 2]	2	1
    //[1, 1, 9, 1, 1, 1]	0	5
    public int solution3_1(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int data : priorities){
            queue.offer(data);
        }
        int answer = 1;
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {
                    if(i == location){
                        return answer;
                    }
                    answer++;
                    queue.poll();
                }
            }
        }
        return answer;
    }
}
