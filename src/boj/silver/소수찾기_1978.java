package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2022-07-07
 * BOJ 1978
 * 스위치 켜고 끄기
 * 실버 5
 * 15분
 * https://www.acmicpc.net/problem/1978
 */
public class 소수찾기_1978 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int[] d = new int[n];
        int idx = 0;        
        while(st.hasMoreTokens()){
            d[idx++] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for(int i=0; i<d.length; i++){
            // 1은 소수가 아님
            if(d[i] == 1) continue;
            // 2와 3은 소수임
            if(d[i] == 2 || d[i] == 3){
                count++;
                continue;
            }
            boolean isD = true;
            for(int j=2; j<d[i]; j++){
                // j로 나누어 지면 소수가 아님
                if(d[i]%j == 0){
                    isD = false;
                    break;
                }
            }
            // 루프를 다 돌고 나왔을때도 나누어진 값이 없다면 소수임
            if(isD) count++;
        }

        System.out.println(count);
    }
}
