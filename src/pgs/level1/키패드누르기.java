package pgs.level1;

/**
 * 2022-07-01
 * PGS
 * 키패드 누르기
 * level1
 * 2시간
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 * keypad의 배열 선언에서 8번째 인덱스가 {2,0}으로 시작하여야 하는데 {2,1} 로 작성하여 헤맴
 */
public class 키패드누르기 {
    // 숫자 패드의 좌표 저장 10은 * 11은 #으로 지정
    int[][] keypad = {{3,1},{0,0},{0,1},{0,2},{1,0},
    {1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,2}};

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int lp = 10; // 왼손의 위치
        int rp = 11; // 오른손의 위치

        for(int i: numbers){
            if(i == 1 || i == 4 || i == 7){
                lp = i;
                answer += 'L';
            }else if(i == 3 || i == 6 || i == 9){
                rp = i;
                answer += 'R';
            }else{
                int ld = distance(lp,i); //왼손과 누를 키패드간의 거리
                int rd = distance(rp,i); //오른손과 누를 키패드간의 거리

                if(ld == rd){
                    if(hand.equals("left")){
                        lp = i;
                        answer += 'L';
                    }else{
                        rp = i;
                        answer += 'R';
                    }
                }else if(ld > rd){
                    rp = i;
                    answer += 'R';
                }else{
                    lp = i;
                    answer += 'L';
                }
        }
    }
        return answer;
    }

    public int distance(int handPos, int number){
        int distance;
        int x_distance = Math.abs(keypad[handPos][0] - keypad[number][0]);
        int y_distance = Math.abs(keypad[handPos][1] - keypad[number][1]);
        distance = x_distance + y_distance;
        return distance;
    }
}
