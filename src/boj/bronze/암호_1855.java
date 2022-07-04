package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2022-07-04
 * BOJ 1855
 * 암호
 * 브론즈1
 * 20분
 * https://www.acmicpc.net/problem/1855
 * 테스트 용도로 System.out.println() 을 집어넣었다가 1번 틀림
 */
public class 암호_1855 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 열의 갯수는 입력으로 받음
        int col = Integer.parseInt(br.readLine());

        // 글자수는 반드시 열의 배수임
        String str = br.readLine();

        // 행의 수는 글자수 / 열 => 글자수가 반드시 열의 배수이므로 반드시 나누어 떨어짐
        int row = str.length() / col;

        // 행과 열의 수 만큼 배열 생성
        String[][] arr = new String[row][col];
        
        // 한글자씩 가져올 인덱스
        int index = 0;

        for(int i=0; i<row; i++){
            // 행이 홀수 행이면 역순으로 짝수 행이면 순서대로
            if(i%2 ==0){
                for(int j=0; j<col; j++){
                    arr[i][j] = String.valueOf(str.charAt(index));
                    index++;
                }
                    
            }else{
                for(int j=col-1; j>=0; j--){
                    arr[i][j] = String.valueOf(str.charAt(index));
                    index++;
                }       
            }
        }

        StringBuilder sb = new StringBuilder();
        
        // 전체 배열 열 기준으로 루프
        for(int i=0; i<col; i++){
            for(int j=0; j<row; j++)
                sb.append(arr[j][i]);
        }
            
        //출력
        System.out.println(sb.toString());
    }
}
