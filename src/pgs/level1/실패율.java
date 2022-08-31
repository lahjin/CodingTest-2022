package pgs.level1;

import java.util.*;

/**
 * 2022-08-31
 * PGS
 * 실패율
 * level1
 * 1시간 40분
 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
 * 새로운 클래스를 만들어서 재정렬하는 것과 
 * 스테이지에 도달한 사람이 0명일때의 예외처리를 하지 못해서 오래걸림
 */
class Solution {
    
    // 각 스테이지별로 실패율을 저장하는 클래스
    class Rate {
        int stage;
        double rate;
        
        public Rate(int stage, double rate) {
            this.stage = stage;
            this.rate = rate;
        }
    }

    public int[] solution(int N, int[] stages) {
        // 정답을 넣을 변수
        int[] answer = new int[N];
        // 정답 넣을 인덱스 변수
        int idx = 0;
        // 각 스테이지에 도달한 플레이어 수 (편의성을 위해서 배열의 길이를 +2 했음) 
        int[] reachCnt = new int[N+2];
        // 각 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 (편의성을 위해서 배열의 길이를 +2 했음)
        int[] failCnt = new int[N+2];
        // 각 스테이지와 실패율을 저장할 리스트
        List<Rate> rates = new ArrayList<>();

        for(int n : stages){
            failCnt[n]++; // n스테이지를 클리어 못한 플레이어수를 +1
            // 1스테이지부터 n스테이지까지 도달한 플레이어수를 +1
            for(int i=1; i<=n; i++){
                reachCnt[i]++;
            }
        }
        
        // 각 배열의 0은 어떠한 값도 들어올수 없고 
        // N+1 배열은 모든 스테이지를 클리어한 인원이므로 체크할 필요가 없다.
        for(int i=1; i<=N; i++){
            /*
                자바에서 ? / 0 을 할때 ?가 int형이면 Exception 에러가 나고
                ?가 double 형이면 ?에 값에 따라 결과가 달라진다.
                ?가 0.0 = NaN 양수 = Infinity 음수 = -Infinity
                따라서 0일때는 rate를 0으로 객체를 생성한다.
            */ 
            if(reachCnt[i] == 0)
                rates.add(new Rate(i, 0));
            else
                rates.add(new Rate(i, (double) failCnt[i] / reachCnt[i]));    
        }

        // 내림차순 정렬
        Collections.sort(rates, ((o1, o2) -> Double.compare(o2.rate, o1.rate)));

        for(Rate r : rates){
            answer[idx++] = r.stage;
        }
        
        return answer;
    }

}