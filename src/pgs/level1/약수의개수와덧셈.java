package pgs.level1;

/**
 * 2022-08-31
 * PGS
 * 약수의 개수와 덧셈
 * level1
 * 5분
 * https://school.programmers.co.kr/learn/courses/30/lessons/77884
 * 크게 어려울것 없는 문제
 */
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        // left부터 right까지 반복
        for(int i=left; i<= right; i++){
            // 모든수는 1을 약수로 가지고 있기에 count는 1부터 시작
            int count = 1;
            for(int j=2; j<=i; j++){
                // 나누어 떨어지면 약수임
                if(i%j == 0) count++;
            }
            // count가 짝수면 더하고 홀수면 빼기
            answer = count % 2 == 0 ? answer+i : answer-i;
        }
        return answer;
    }
}
