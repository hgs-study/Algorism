package com.programmers.level_01;

public class Etc {


    //문제 설명
    //함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
    //
    //제한 조건
    //x는 -10000000 이상, 10000000 이하인 정수입니다.
    //n은 1000 이하인 자연수입니다.
    //
    //입출력 예
    //x	n	answer
    //2	5	[2,4,6,8,10]
    //4	3	[4,8,12]
    //-4	2	[-4, -8]
    public long[] solution1_1(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] =  Long.valueOf(x) * (i+1);
        }
        return answer;
    }

    //문제 설명
    //프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
    //전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.
    //
    //제한 조건
    //s는 길이 4 이상, 20이하인 문자열입니다.
    //
    //입출력 예
    //phone_number	return
    //"01033334444"	"*******4444"
    //"027778888"	"*****8888"
    public String solution1_2(String phone_number) {
        String answer = "";
        String[] splitPhoneNumber = phone_number.split("");
        for (int i = 0; i < phone_number.length() - 4; i++) {
            splitPhoneNumber[i] = "*";
            answer += splitPhoneNumber[i];
        }
        answer += phone_number.substring(phone_number.length()-4);
        return answer;
    }

    //음양 더하기
    //문제 설명
    //어떤 정수들이 있습니다. 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다. 실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.
    //
    //제한사항
    //absolutes의 길이는 1 이상 1,000 이하입니다.
    //absolutes의 모든 수는 각각 1 이상 1,000 이하입니다.
    //signs의 길이는 absolutes의 길이와 같습니다.
    //signs[i] 가 참이면 absolutes[i] 의 실제 정수가 양수임을, 그렇지 않으면 음수임을 의미합니다.
    //입출력 예
    //absolutes	signs	result
    //[4,7,12]	[true,false,true]	9
    //[1,2,3]	[false,false,true]	0
    //입출력 예 설명
    //입출력 예 #1
    //
    //signs가 [true,false,true] 이므로, 실제 수들의 값은 각각 4, -7, 12입니다.
    //따라서 세 수의 합인 9를 return 해야 합니다.
    //입출력 예 #2
    //
    //signs가 [false,false,true] 이므로, 실제 수들의 값은 각각 -1, -2, 3입니다.
    //따라서 세 수의 합인 0을 return 해야 합니다.
    public int solution2_1(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < signs.length; i++) {
            if(signs[i])
                answer += absolutes[i];
            else
                answer -= absolutes[i];
        }

        return answer;
    }
}
