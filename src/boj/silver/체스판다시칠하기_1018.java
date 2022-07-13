package boj.silver;

import java.io.*;

/**
 * 2022-07-13
 * BOJ 1018
 * 체스판 다시 칠하기
 * 실버4
 * 2시간 30분
 * https://www.acmicpc.net/problem/1018
 */
public class 체스판다시칠하기_1018{
    // 칠해야 하는 최소 갯수를 지정하는 변수 
    // (최대 색칠해야 하는 갯수는 8x8이므로 초기값은 64)
    static int count = 64;

    // 전체 보드를 저장하는 변수
    static String[][] board;
    
    // 2. 체스판을 잘라 낼수 있는 모든 경우
    static void chess(int r, int c){ // r은 시작 row c는 시작 column
        // 왼쪽 최상단이 흰색일 경우를 담아둔 배열
        String[][] white = {{"W","B","W","B","W","B","W","B"},{"B","W","B","W","B","W","B","W"}};
        // 현재 보드의 칠해야 하는 칸의 갯수
        int paintCount = 0;

        // 8x8의 체스판을 체크하는 이중 루프
        for(int i=0; i<8; i++){ // 시작 행부터 8번 반복한다.
            int row = r+i;
            for(int j=0; j<8; j++){ // 시작 열부터 8번 반복한다.
                int col = c+j;
                // 현재의 열이 기존보드의 값과 일치하지않으면 새로 색칠해야함
                if(!board[row][col].equals(white[i%2][j%2])) paintCount++;
            }
        }
        // paintCount는 왼쪽 최상단이 흰색일때의 값으로 구하였고 
        // 왼쪽 최상단이 검정색일때 갯수는 64에서 paintCount를 뺀 값이 된다.
        // 두 값중 작은값을 현재의 count와 비교하여 작은 값을 count에 대입한다.  
        paintCount = 64-paintCount > paintCount ? paintCount : 64-paintCount;
        if(paintCount < count) count = paintCount; // 3. 체스판을 칠하는 최소 갯수
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm = br.readLine();
        String[] nms = nm.split(" ");
        
        // 0-1. 행과 열 입력
        int row = Integer.parseInt(nms[0]) , col = Integer.parseInt(nms[1]);
        board = new String[row][col];

        // 0-2. 전체 보드판 입력
        for(int i=0; i<row; i++){
            String input = br.readLine();
            String[] s = input.split("");
            for(int j=0; j<col; j++)
                board[i][j] = s[j];
        }

        // 1. 판을 잘라낼수 있는 모든 경우
        for(int i=0; i<=row-8; i++){
            for(int j=0; j<=col-8; j++){
                chess(i,j);
            }
        }
        
        // 4. 최소값 출력
        System.out.println(count);
    }
}
