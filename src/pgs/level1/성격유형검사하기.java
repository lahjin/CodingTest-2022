package pgs.level1;

import java.util.HashMap;

/**
 * 2022-08-22
 * PGS
 * 성격 유형 검사하기
 * level1
 * 1시간
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 * 초기값을 설정해주는 부분에서 고민을 오래하지말자
 */
public class 성격유형검사하기 {
    HashMap<Character,Integer> type = new HashMap<>();

    public void init(){
        type.put('R', 0);
        type.put('T', 0);
        type.put('C', 0);
        type.put('F', 0);
        type.put('J', 0);
        type.put('M', 0);
        type.put('A', 0);
        type.put('N', 0);
    }
    
    public void question(String survey, int choices){
        switch(choices){
            case 1: type.put(survey.charAt(0), type.get(survey.charAt(0))+3); break;
            case 2: type.put(survey.charAt(0), type.get(survey.charAt(0))+2); break;
            case 3: type.put(survey.charAt(0), type.get(survey.charAt(0))+1); break;
            case 5: type.put(survey.charAt(1), type.get(survey.charAt(1))+1); break;
            case 6: type.put(survey.charAt(1), type.get(survey.charAt(1))+2); break;
            case 7: type.put(survey.charAt(1), type.get(survey.charAt(1))+3); break;
        }
    }
    
    public String result(){
        StringBuilder sb = new StringBuilder();

        if(type.get('R') >= type.get('T')) sb.append('R');
        else sb.append('T');

        if(type.get('C') >= type.get('F')) sb.append('C');
        else sb.append('F');

        if(type.get('J') >= type.get('M')) sb.append('J');
        else sb.append('M');

        if(type.get('A') >= type.get('N')) sb.append('A');
        else sb.append('N');

        return sb.toString();
    }

    public String solution(String[] survey, int[] choices) {
        init();
        for(int i=0; i<survey.length; i++){
            question(survey[i], choices[i]);
        }
        return result();
    }

}
