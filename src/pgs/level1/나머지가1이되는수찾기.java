package pgs.level1;

/**
 * 2022-09-01
 * PGS
 * 나머지가 1이 되는 수 찾기
 * level1
 * 3분
 * https://school.programmers.co.kr/learn/courses/30/lessons/87389
 */
class Solution {
    public int solution(int n) {
        for(int i=2; i<n; i++){
            if(n%i == 1) return i;
        }
        return 0;
    }
}