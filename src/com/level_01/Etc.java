package com.level_01;

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
}
