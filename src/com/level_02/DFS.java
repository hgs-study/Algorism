package com.level_02;

public class DFS {

    //문제 설명
    //n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
    //
    //-1+1+1+1+1 = 3
    //+1-1+1+1+1 = 3
    //+1+1-1+1+1 = 3
    //+1+1+1-1+1 = 3
    //+1+1+1+1-1 = 3
    //
    //사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int depth, int sum) {
        int matchCount = 0;

        if (depth == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        matchCount += dfs(numbers, target, depth + 1, sum + numbers[depth]);
        matchCount += dfs(numbers, target, depth + 1, sum - numbers[depth]);
        return matchCount;
    }

    //직접 풀어보기 dfs (타겟넘버)
    private int count =0;
    public int solution2_1(int[] numbers, int target) {
        dfs2_1(numbers,target, 0, 0);
        return count;
    }

    public void dfs2_1(int[] numbers, int target, int depth, int sum){

        if(depth == numbers.length) {
            if (target == sum) {
                count++;
            }
            return;
        }

        dfs2_1(numbers,target,depth + 1 , sum + numbers[depth]);
        dfs2_1(numbers,target,depth +1, sum - numbers[depth]);
    }

}
