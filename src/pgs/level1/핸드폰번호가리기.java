package pgs.level1;

/**
 * 2022-09-06
 * PGS
 * 핸드폰 번호 가리기
 * level1
 * 3분
 * https://school.programmers.co.kr/learn/courses/30/lessons/12948
 * 연습문제는 대부분이 너무 간단한 문제이다.
 */
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        while(answer.length() < phone_number.length() -4){
            answer += "*";
        }
        answer += phone_number.substring(phone_number.length() -4);
        return answer;
    }
}