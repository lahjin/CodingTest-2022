package pgs.level1;

/**
 * 2022-09-05
 * PGS
 * 햐사드 수
 * level1
 * 15분
 * https://school.programmers.co.kr/learn/courses/30/lessons/12947
 * 각 자리수 구하기 알고리즘이 햇갈렸음
 * sum에 +=을 =으로 해서 오답이 나옴
 */
class Solution {
    public boolean solution(int x) {
        int num = x;
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return x % sum == 0 ? true : false;
    }
}