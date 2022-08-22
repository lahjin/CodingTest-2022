package pgs.level1;

/**
 * 2022-08-22
 * PGS
 * 최소직사각형
 * level1
 * 5분
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 * Math.Max ? Math.Min 함수를 활용하면 좀더 효율적인 코드가 가능함
 */
public class 최소직사각형 {
    public int solution(int[][] sizes) {
        // 가로 세로 초기화
        int verMax = 0, horMax = 0;
        // 전체 배열 탐색
        for(int i=0; i< sizes.length; i++){
            // 작은값을 verMax와 비교하기위한 조건문
            if(sizes[i][0] >= sizes[i][1]) {
                if(sizes[i][0] > horMax) horMax = sizes[i][0];
                if(sizes[i][1] > verMax) verMax = sizes[i][1];
            }else{
                if(sizes[i][1] > horMax) horMax = sizes[i][1];
                if(sizes[i][0] > verMax) verMax = sizes[i][0];
            }
        }
        return verMax * horMax;
    }
}