package pgs.level1;

import java.util.regex.Pattern;

/**
 * 2022-07-14
 * PGS
 * 문자열 다루기 기본
 * level1
 * 5분
 * https://school.programmers.co.kr/learn/courses/30/lessons/12918
 * 프로그래머스 스킬체크 레벨1에서 나온 1번문제
 * 졍규식을 활용하여 비교적 쉽게 풀었다.
 * 길이 역시 정규식으로 비교가 가능하지만 기억이 나지않았음.
 */
class 문자열다루기기본 {
    public boolean solution(String s) {
        String p = "^[0-9]*$";
        if(!Pattern.matches(p,s))
            return false;

        if(s.length() == 4 || s.length() == 6)
            return true;
        return false;
    }
}