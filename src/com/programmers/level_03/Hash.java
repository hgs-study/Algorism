package com.programmers.level_03;

import java.util.*;

public class Hash {

    //베스트앨범
    //문제 설명
    //스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
    //
    //속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    //장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    //장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    //노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
    //
    //제한사항
    //genres[i]는 고유번호가 i인 노래의 장르입니다.
    //plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
    //genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
    //장르 종류는 100개 미만입니다.
    //장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
    //모든 장르는 재생된 횟수가 다릅니다.

    //입출력 예
    //genres	plays	return
    //["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
    public int[] solution1_1(String[] genres, int[] plays) {
        HashMap<String, Object> genresMap = new HashMap<String, Object>();      //<장르, 곡 정보>
        HashMap<String, Integer> playMap = new HashMap<String, Integer>(); //<장르, 총 장르 재생수>
        ArrayList<Integer> resultAL = new ArrayList<Integer>();

        for(int i = 0; i < genres.length; i++){
            String key = genres[i];
            HashMap<Integer, Integer> infoMap;       // 곡 정보 : <곡 고유번호, 재생횟수>

            if(genresMap.containsKey(key)){
                infoMap = (HashMap<Integer, Integer>)genresMap.get(key);
            }
            else {
                infoMap = new HashMap<Integer, Integer>();
            }

            infoMap.put(i, plays[i]);
            genresMap.put(key, infoMap);

            //재생수
            if(playMap.containsKey(key)){
                playMap.put(key, playMap.get(key) + plays[i]);
            }
            else {
                playMap.put(key, plays[i]);
            }
        }

        int mCnt = 0;
        Iterator it = sortByValue(playMap).iterator();

        while(it.hasNext()){
            String key = (String)it.next();
            Iterator indexIt = sortByValue((HashMap<Integer, Integer>)genresMap.get(key)).iterator();
            int playsCnt = 0;

            while(indexIt.hasNext()){
                resultAL.add((int)indexIt.next());
                mCnt++;
                playsCnt++;
                if(playsCnt > 1) break;
            }
        }

        int[] answer = new int[resultAL.size()];

        for(int i = 0; i < resultAL.size(); i++){
            answer[i] = resultAL.get(i).intValue();
        }

        return answer;
    }

    private ArrayList sortByValue(Map map){
        ArrayList<Object> keyList = new ArrayList();
        keyList.addAll(map.keySet());

        Collections.sort(keyList, new Comparator(){
            public int compare(Object o1, Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v2).compareTo(v1);
            }
        });

        return keyList;
    }
}
