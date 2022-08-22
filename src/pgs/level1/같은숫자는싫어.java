package pgs.level1;

import java.util.ArrayList;

/**
 * 2022-08-22
 * PGS
 * 같은 숫자는 싫어
 * level1
 * 10분
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 * int는 ArrayList로 변환시 toArray 메소드를 사용할 수 없다.
 */
public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        ArrayList<Integer> ls = new ArrayList<>();
        // 1번째 값을 미리 넣어줌
        int prev = arr[0];
        // 1번 인덱스부터 끝까지 반복
        for(int i=1; i<arr.length; i++){
            // 이전값과 현재값이 다르면 이전값을 List에 추가함
            if(prev != arr[i]) ls.add(prev);
            // 현재값을 이전값에 대입
            prev = arr[i];
        }
        // 반복이 끝나고 나서 마지막값을 List에 추가함
        ls.add(prev);
        int[] answer = new int[ls.size()];
        for(int i=0; i<ls.size(); i++){
            answer[i] = ls.get(i);
        }
        return answer;
    }
}
