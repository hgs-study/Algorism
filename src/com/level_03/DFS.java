package com.level_03;

import java.util.ArrayList;
import java.util.Collections;

// 참고 : https://velog.io/@sukong/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B0%9C%EB%85%90-%EA%B9%8A%EC%9D%B4%EC%9A%B0%EC%84%A0%ED%83%90%EC%83%89DFS
public class DFS {


    //문제 설명
    //네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다. 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
    //컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
    //
    //제한사항
    //컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
    //각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
    //i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
    //computer[i][i]는 항상 1입니다.
    //
    //입출력 예
    //n	computers	return
    //3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
    //3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
    public int solution1_1(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];

        // 전체 컴퓨터 방문
        for (int i = 0; i < n; i++) {
            if(!visit[i]){
                //첫 노드부터 재귀함수 시작
                dfs(n, computers, visit, i);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int n, int[][] computers, boolean[] visit,int index){
        visit[index] = true; //방문 확인

        for (int i = 0; i < n; i++) { // 노드 방문
            // 연결된 노드, 자신 제외, 아직 방문기록이 없는 노드
            if(computers[index][i] != 0 && index != i && !visit[i])
                dfs(n,computers,visit,i);
        }
    }

    //네트워크 다시 풀기 (직접 푼 것)
    //문 11 / 13개 성공
    public int solution1_2(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i= 0; i<n ; i++){
            dfs1_2(n, computers, visited, i);
        }

        boolean isTrueLessThanOne = false;
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == false) {
                count += 1;
            }else if( visited[i] == true && isTrueLessThanOne ==false){
                isTrueLessThanOne = true;
                count += 1;
            }
        }
        return count;
    }

//    private int depth = 0;

    private void dfs1_2(int n, int[][] computers, boolean[] visited, int index){
        for (int j = 0; j < n; j++) {
            if(computers[index][j] ==1 && index!=j && visited[index] == false){
                visited[index] = true;
                dfs1_2(n,computers,visited,index);
            }
        }
    }


    //문제 설명
    //두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
    //1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
    //2. words에 있는 단어로만 변환할 수 있습니다.
    //예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
    //
    //두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
    int answer = Integer.MAX_VALUE;
    public int solution2_1(String begin, String target, String[] words) {
        dfs2_1(new boolean[words.length], 0, begin, target, words);
        if (answer == Integer.MAX_VALUE)
            answer = 0;
        return answer;
    }

    public void dfs2_1(boolean[] visited, int cnt, String begin, String target, String[] words){
        if (begin.equals(target)) {
            answer = Math.min(cnt, answer);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && checkStr(begin, words[i])) {
                visited[i] = true;
                dfs2_1(visited, cnt + 1, words[i], target, words);
                visited[i] = false;
            }
        }

    }

    public boolean checkStr(String tmpStr, String target) {
        int cnt = 0;
        for (int i = 0; i < target.length(); i++) {
            if (tmpStr.charAt(i) != target.charAt(i)) cnt++;
        }

        if (cnt == 1) return true;
        return false;
    }


    //문제 설명
    //주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
    //항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
    //
    //제한사항
    //모든 공항은 알파벳 대문자 3글자로 이루어집니다.
    //주어진 공항 수는 3개 이상 10,000개 이하입니다.
    //tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
    //주어진 항공권은 모두 사용해야 합니다.
    //만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
    //모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
    //
    //입출력 예
    //tickets	return
    //[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
    //[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
    boolean[] visited;                    //방문한지 안한지를 체크하는 visited배열
    ArrayList<String> answers;

    public String[] solution3_1(String[][] tickets) {
        visited = new boolean[tickets.length];
        answers = new ArrayList<String>();
        int count = 0;                                    //몇개의 공항을 들렸는지 알려주는 카운트

        dfs3_1(count, "ICN", "ICN",tickets);

        Collections.sort(answers);                        //답들 중 가장 알파벳순이 빠른 배열들로 정렬
        String[] answer = answers.get(0).split(" ");    //가장 빠른 배열을 뽑아서 String형 배열로 만듬

        return answer;
    }

    private void dfs3_1(int count, String present, String answer, String[][]ticktes) {
        if (count == ticktes.length) {            //모든 공항을 들렸다면
            answers.add(answer);                //answers에 추가
            return;
        }
        for (int i = 0; i < ticktes.length; i++) {
            if (!visited[i] && ticktes[i][0].equals(present)) {        //present와 같고 들리지 않은 공항을 찾고
                visited[i] = true;                                    //해당 공항을 들린걸로 만듬.
                dfs3_1(count + 1, ticktes[i][1], answer + " " + ticktes[i][1], ticktes);    //카운트 +1 도착 공항을 present로 넣어주고 answer에 도착공항을 추가해준다.
                visited[i] = false;
            }
        }
        return;
    }

}

