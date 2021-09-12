package com.programmers.level_01;

public class Greedy {

    public int solution1_1(int n, int[] lost, int[] reserve) {
        int answer = n -lost.length;
        boolean[] visitedI = new boolean[lost.length];
        boolean[] visitedJ = new boolean[reserve.length];

        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] == lost[j]) {
                    visitedJ[j] = true;
                    visitedI[i] = true;
                    answer += 1;
                    break;
                }
            }
        }

        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {

                if(!visitedJ[j] && !visitedI[i])
                    if((reserve[i] - 1) == lost[j] || (reserve[i] + 1) == lost[j]) {
                        visitedJ[j] = true;
                        visitedI[i] = true;
                        answer += 1;
                        break;
                    }
            }
        }

        return answer;
    }

    public int solution1_2(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int lost1 = 0;
        int count = 0;

        //여벌 옷을 가지고 있는 학생이 도난 당하면 빌려줄 수 없도록 만든다.
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i]==reserve[j]) {
                    lost1++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        //옷을 빌려주고 -1로 만들어 뒤의 학생에게 빌려주지 않게 한다.
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i]==reserve[j]+1 || lost[i]==reserve[j]-1) {
                    count++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        //answer은 전체 학생수에서 잃어버린 학생 수를 뺀다.
        //후에 여벌옷을 가진 학생이 도난 당했으면 그 수만큼 더해주고 옷을 빌려준 학생 수 만큼 다시 더해준다.
        answer = n - lost.length + lost1 + count;

        return answer;
    }

}
