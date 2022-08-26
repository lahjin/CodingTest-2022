package pgs.level1;

import java.util.*;

/**
 * 2022-08-26
 * PGS
 * 크레인 인형 뽑기 게임
 * level1
 * 30분
 * https://school.programmers.co.kr/learn/courses/30/lessons/64061
 * 뽑고 난 인형을 0으로 만들어주는 것과 2차원배열의 [row][col] 행과 열은 늘 햇갈린다.
 */
public class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // 크레인으로 뽑은 인형을 저장할 List
        List<Integer> stack = new ArrayList<>();
        // 1. moves의 길이만큼 반복
        for(int i=0; i< moves.length; i++){
            int temp = 0;
            // 2. moves[i] 인덱스의 크레인 작동로직
            for(int j=0; j<board.length; j++){
                // 0이라면 인형이 없는것
                if(board[j][moves[i]-1] == 0) continue;
                // 인형이 존재한다면 temp에 인형을 저장하고 
                temp = board[j][moves[i]-1];
                //기존의 board값을 0으로 바꾸고 반복문 탈출
                board[j][moves[i]-1] = 0;
                break;
            }
            // temp가 0이라면 인형이 그 라인에 존재하지않음
            if(temp == 0) continue;
            // 3. stack에 이전결과값과 비교하여 같은 것인지 체크
            if(stack.size() == 0 || stack.get(stack.size()-1) != temp) stack.add(temp);
            // 4. 같은것이라면 추가하지않고 이전의 값을 지운 후 answer의 값을 늘림
            else if(stack.get(stack.size()-1) == temp) {
                stack.remove(stack.size()-1);
                answer += 2;
            }
        }
        
        return answer;
    }
}