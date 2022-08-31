package pgs.level1;


/**
 * 2022-08-30
 * PGS
 * 숫자 문자열과 영단어
 * Level1
 * 10분
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301
 * zero 빼먹어서 런타임 에러 뜬거 말고는 특별히 어려울 것 없는 문제
 */
class Solution {
    public int solution(String s) {
        String[] numbers = {"zero","one", "two", "three" , "four", "five",
                                "six", "seven", "eight", "nine"};
        for(int i=0; i<numbers.length; i++)
            s = s.replaceAll(numbers[i], String.valueOf(i));
        return Integer.parseInt(s);
    }
}
