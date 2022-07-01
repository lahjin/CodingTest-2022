package pgs.level1;

import java.util.*;

/**
 * 2022-07-01
 * PGS
 * 체육복
 * level1
 * 1시간 20분
 * https://programmers.co.kr/learn/courses/30/lessons/42862
 * lostCount를 계산해 내는 식을 이중 for문 안에서 처리를 할려다가 시간을 많이 소모
 */
public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // 정렬을 하지않는다면 테스트 케이스 13번과 18번 문제를 실패함
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 체육복을 잃어버렸지만 여분이 있는 학생의 배열값과 잃어버린 학생의 배열값을 -1로 지정
        // -1로 지정하는 이유는 앞뒤의 값이 -2와 0이므로 학생번호 1~30까지의 수와 겹칩일이 없다.
        // 다만 배열의 값을 변동하여 그 배열을 다시 탐색하므로 효율성이 떨어짐
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                // 잃어버린 학생의 앞의 학생이 여분이 있는지 확인
                if(lost[i]-1 == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
                // 잃어버린 학생의 뒤의 학생이 여분이 있는지 확인
                else if(lost[i]+1 == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        int lostCount = 0;
        for(int i: lost){
            // lost 배열의 값이 1이상이면 빌리지 못했다는 뜻
            if(i > 0)
                lostCount++;
        }
        
        return n - lostCount;
    }
}