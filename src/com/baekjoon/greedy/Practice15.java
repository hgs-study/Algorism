package com.baekjoon.greedy;

import java.util.Scanner;

//4796번, 캠핑
public class Practice15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] camping1 = new int[3];
        int[] camping2 = new int[3];

        int caseNumber = 1;
        StringBuffer stringBuffer = new StringBuffer();

        while (true){
            int openDate = scanner.nextInt();
            int periodDate = scanner.nextInt();
            int vacation = scanner.nextInt();

            if(openDate == 0)
                break;

            int answer = 0;
            answer = (vacation / periodDate) * openDate;

            if(vacation % periodDate < openDate)
                answer += vacation % periodDate;
            else
                answer += openDate;

            stringBuffer.append("Case ");
            stringBuffer.append(caseNumber);
            stringBuffer.append(": ");
            stringBuffer.append(answer);
            stringBuffer.append("\n");

            caseNumber++;
        }

        System.out.println(stringBuffer);
    }
}
