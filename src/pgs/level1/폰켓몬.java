package pgs.level1;

import java.util.*;

/**
 * 2022-07-12
 * PGS
 * 폰켓몬
 * level1
 * 10분
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 * HashMap으로 생각하다가 HashSet을 이용하여 중복을 제거하는 방법으로 풀이
 */
public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        // 중복 제거를 위한 HashSet 생성
        HashSet<Integer> pk = new HashSet<>();
        for(int n: nums){
            pk.add(n);
        }
        // 선택할수 있는 총 갯수
        int n = nums.length/2;
        // 폰켓몬의 수가 n보다 작으면 폰켓몬의 종류가 최대 선택 갯수이 되고 
        // n보다 크다면 n이 최대 선택 갯수가 된다.
        answer = pk.size() < n ? pk.size() : n;

        return answer;
    }
}
