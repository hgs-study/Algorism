package com.level_03;

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

    private void dfs1_2(int n, int[][] computers, boolean[] visited, int index){
        for (int j = 0; j < n; j++) {
            if(computers[index][j] ==1 && index!=j && visited[index] == false){
                visited[index] = true;
                dfs1_2(n,computers,visited,index);
            }
        }
    }

}
