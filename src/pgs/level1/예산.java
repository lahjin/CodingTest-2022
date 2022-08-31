package pgs.level1;

import java.util.Arrays;

/**
 * 2022-08-31
 * PGS
 * 예산
 * level1
 * 5분
 * https://school.programmers.co.kr/learn/courses/30/lessons/12982
 * 정렬과 그리디 알고리즘으로 쉽게 풀린 문제 break문을 추가하면 효율성은 조금 올라갈 듯
 */
class Solution {
    public int solution(int[] d, int budget) {
        int count = 0;
        // 각 부서별 예산 오름차순으로 정렬
        Arrays.sort(d);
        for(int i=0; i<d.length; i++){
            // 전체 예산에 현재 예산을 뺐을때 0 이상이면
            if(budget - d[i] >= 0){
                count++; // 카운트 증가
                budget -= d[i]; // 예산 감소
            }
        }
        return count;
    }
}
