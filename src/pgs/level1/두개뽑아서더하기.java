package pgs.level1;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 2022-08-31
 * PGS
 * 두 개 뽑아서 더하기
 * level1
 * 5분
 * https://school.programmers.co.kr/learn/courses/30/lessons/68644
 * Tree를 이용하면 정렬하면서 자료를 넣는것이 가능하니 유용하게 쓰자.
 */
class Solution {
    public int[] solution(int[] numbers) {
        // TreeSet은 Set의 구조와 같지만 값을 추가할 때 마다 자동으로 정렬해준다.
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i=0; i<numbers.length-1; i++)
            for(int j=i+1; j<numbers.length; j++)
                set.add(numbers[i] + numbers[j]);
        
        ArrayList<Integer> list = new ArrayList<>(set);
        int[] answer = new int[list.size()];
        for(int i=0; i< list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}