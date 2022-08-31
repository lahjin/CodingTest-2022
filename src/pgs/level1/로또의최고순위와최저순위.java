package pgs.level1;

import java.util.HashSet;

/**
 * 2022-08-29
 * PGS
 * 로또의 최고 순위와 최저 순위
 * level1
 * 40분
 * https://school.programmers.co.kr/learn/courses/30/lessons/77484
 * Level1 문제는 어렵게 생각하지말고 기본적으로 일단 생각하자
 * 2중 for문으로도 충분히 해결가능한 문제다.
 */
public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int unknown = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int n: win_nums) set.add(n);
        for(int n: lottos){
            set.remove(n);
            if(n == 0) unknown++;
        } 
        answer[0] = set.size() == 0 ? 1 : lottosRank(set.size()-unknown);
        answer[1] = lottosRank(set.size());
        return answer;
    }

    public int lottosRank(int count){
        switch(count){
            case 0: return 1;
            case 1: return 2;
            case 2: return 3;
            case 3: return 4;
            case 4: return 5;
            default: return 6;
        }
    }
}
