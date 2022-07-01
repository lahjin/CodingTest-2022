package pgs.level1;

import java.util.*;
/**
 * 2022-07-01
 * PGS
 * 다트게임
 * level1
 * 40분
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 */
public class 다트게임 {
    public int solution(String dartResult) {
        int answer = 0;
        // 3회의 점수를 기록할 리스트
        List<Integer> ls = new ArrayList<>();
        // 현재 리스트의 index 번호
        int index = -1;
        
        // 한글자씩 순회
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            
            // 첫글자가 1이면 10을 고려해야만 한다.
            if(c == '1'){
                if(dartResult.charAt(i+1) == '0'){
                    ls.add(10);
                    i++; // 다음글자가 0이므로 다음 문자는 스킵
                    index++;
                    continue;
                }
            }
            
            if( c >= '0' && c <= '9'){
                ls.add(Character.getNumericValue(c));
                index++;
            }else if ( c == 'D'){
                int prevVal = ls.get(index);
                ls.set(index,prevVal * prevVal);
            }else if ( c == 'T'){
                int prevVal = ls.get(index);
                ls.set(index,prevVal * prevVal * prevVal);
            }else if ( c == '*'){
                if(index == 0)
                    ls.set(0, ls.get(0) *2);
                else{
                    ls.set(index-1, ls.get(index-1) *2);
                    ls.set(index, ls.get(index) *2);
                }
            }else if ( c == '#'){
                ls.set(index, ls.get(index)* -1);
            }
            
        }
        
        for(Integer i : ls)
            answer += i;
        return answer;
    }
}
