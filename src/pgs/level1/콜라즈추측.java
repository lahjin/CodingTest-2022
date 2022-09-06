package pgs.level1;

/**
 * 2022-09-06
 * PGS
 * 콜라즈 추측
 * level1
 * 5분
 * https://school.programmers.co.kr/learn/courses/30/lessons/12943
 * 어려운 문제인줄 알았는데 간단한 연습문제
 */
class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = num;
        while(n != 1){
            if(answer == 500){
                answer = -1;
                break;
            }
            n = n % 2 == 0 ? n/2 : n*3+1;
            answer++;
        }
        return answer;
    }
}
