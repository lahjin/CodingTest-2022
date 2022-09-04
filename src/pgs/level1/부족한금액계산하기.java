package pgs.level1;

/**
 * 2022-09-04
 * PGS
 * 부족한 금액 계산하기
 * level1
 * 5분
 * https://school.programmers.co.kr/learn/courses/30/lessons/82612
 * 프로그래머스의 오래된 문제는 Level1이라도 난이도가 상당히 낮은듯 하다.
 * 등차수열의 합 공식을 알았다면 if else로 분기하지않아도 되었을듯
 * 아니면 단순 for문으로 빼기를 해도 맞았을듯
 */
class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = price + (price * count);
        if(count % 2 == 0)
            answer = sum * (count / 2) - money;
        else
            answer = sum * (count / 2) + price * (count / 2 + 1) - money;

        return answer < 0 ? 0 : answer;
    }
}
