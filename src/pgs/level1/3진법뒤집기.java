package pgs.level1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 2022-08-30
 * PGS
 * 3진법 뒤집기
 * Level1
 * 30분
 * https://school.programmers.co.kr/learn/courses/30/lessons/68935
 * 진법 변환 while의 조건을 햇갈렸고 StringBuilder와 List 고민
 * Integer.parseInt() 메서드는 진법 변환도 해준다는걸 알았다면 StringBuilder 사용했을듯
 */
class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        // 3진법 변환
        while(n > 0){
            list.add(n%3);
            n /= 3;
        }
        // List 역으로 정렬
        Collections.reverse(list);
        for(int i=0; i<list.size(); i++){
            answer += list.get(i) * Math.pow(3, i);
        }
        return answer;
    }
}