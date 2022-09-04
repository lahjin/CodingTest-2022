package pgs.level1;

/**
 * 2022-09-04
 * PGS
 * 가운데 글자 가져오기
 * level1
 * 5분
 * https://school.programmers.co.kr/learn/courses/30/lessons/12903
 * 프로그래머스 연습문제는 난이도가 낮은듯
 * substring() 사용해도 되었을듯
 */
class Solution {
    public String solution(String s) {
        String answer = "";
        if(s.length() % 2 == 0)
            answer += s.charAt(s.length() / 2 -1);
        answer += s.charAt(s.length() / 2);
        return answer;
    }
}
