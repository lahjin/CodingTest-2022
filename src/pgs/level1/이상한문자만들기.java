package pgs.level1;

/**
 * 2022-08-30
 * PGS
 * 이상한 문자 만들기
 * level1
 * 20분
 * https://school.programmers.co.kr/learn/courses/30/lessons/12930
 * 제한사항을 꼼꼼히 확인하여 예외 케이스를 언제나 생각하는 버릇을 키우자
 */
class Solution {
    public String solution(String s) {
        // 답을 저장할 sb
        StringBuilder sb = new StringBuilder();
        // 공백을 기준으로 나눔 => -1이 없는 경우 빈문자열로 끝나는 경우를 무시함 (이문제의 핵심포인트)
        String[] words = s.split(" ",-1);
        
        for(int i=0; i< words.length; i++){
            String[] sts = words[i].split("");
            for(int j=0; j<sts.length; j++){
                String st = toUpperAndLowerCase(sts[j], j);
                sb.append(st);
            }
            if(i < words.length-1) sb.append(" ");
        }
        
        return sb.toString();
    }
        
    public String toUpperAndLowerCase(String s, int index){
        return index % 2 == 0 ? s.toUpperCase() : s.toLowerCase();
    }
}