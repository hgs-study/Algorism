package com.programmers.level_02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Hash {

    //문제 설명
    //전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
    //전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
    //
    //구조대 : 119
    //박준영 : 97 674 223
    //지영석 : 11 9552 4421
    //
    //전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
    //어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

    //문제 100%, 효율성 0%
    public boolean solution1_1(String[] phone_book) {
        boolean answer = true;

        HashMap<String,Object> map = new HashMap<String, Object>();
        for (String s : phone_book) {
            map.put(s, 0);
        }

        for (int i = 0; i < phone_book.length; i++) {
            String number = phone_book[i].toString();

            for (String s : map.keySet()) {
                if(number.equals(s))
                    continue;
                if(number.length() < s.length()) {
                    if (map.containsKey(s.substring(0, number.length())))
                        answer = false;
                }
            }
        }
        return answer;
    }

    //문제 100%, 효율성 100%
    public boolean solution1_2(String[] phone_book) {
        HashMap<String,Object> map = new HashMap<String, Object>();
        for (String s : phone_book) {
            map.put(s, 0);
        }
        for (String s : phone_book) {
            for (int i = 0; i < s.length(); i++) {
                if(map.containsKey(s.substring(0,i).toString()))
                    return false;
            }
        }
        return true;
    }



    //문제 설명
    //스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
    //
    //예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면
    //다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
    //
    //종류	이름
    //얼굴	동그란 안경, 검정 선글라스
    //상의	파란색 티셔츠
    //하의	청바지
    //겉옷	긴 코트
    //
    //스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
    public int solution2_1(String[][] clothes) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        int answer = 1;

        for (int i = 0; i < clothes.length; i++) {
            if(map.containsKey(clothes[i][1]))
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            else
                map.put(clothes[i][1], 1);
        }

        for (Iterator<Integer> i = map.values().iterator(); i.hasNext(); )
            answer *= i.next() +1;

        return answer - 1;
    }




}
