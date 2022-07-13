package pgs.level1;

/**
 * 2022-07-13
 * PGS
 * 음양 더하기
 * level1
 * 5분
 * https://school.programmers.co.kr/learn/courses/30/lessons/76501
 * level1 중에서도 아주 쉬운 문제
 */
public class 음양더하기 {
    
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<absolutes.length; i++)
            answer = signs[i] 
            ? answer + absolutes[i] :answer - absolutes[i];
        return answer;
    }
    
}
