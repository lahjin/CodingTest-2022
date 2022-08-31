package pgs.level1;

import java.util.HashSet;

/**
 * 2022-08-29
 * PGS
 * 없는 숫자 더하기
 * level1
 * 5분
 * https://school.programmers.co.kr/learn/courses/30/lessons/86051
 * Hash는 만능이지만 다른사람이 풀이는 더 만능이다.
 */
public class 없는숫자더하기 {
    public int solution(int[] numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        // 0~9까지 Set 생성
        for(int i=0; i<10; i++) set.add(i);
        // numbers[i]의 값이 중복이 없으니 제거
        for(int i=0; i<numbers.length; i++) set.remove(numbers[i]);
        // 나머지 값을 더함
        for(Integer n : set) answer += n;
        return answer;
    }
}