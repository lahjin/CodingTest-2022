package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 2022-06-28
 * BOJ 2839
 * 설탕배달
 * 실버4
 * 1시간 30분
 * https://www.acmicpc.net/problem/2839
 */
public class 설탕배달_2839 {

    public static int sol(int surger) {
        int answer = -1;

        // 5의 배수일 경우 바로 나눠서 리턴
        if(surger%5 == 0){
            return surger/5;
        }
        // 5로 나누고 3이 남는다면 +1 해서 리턴
        if(surger%5 == 3){
            return surger/5 +1;
        }

        //위의 두 조건을 만족하지 못한 경우
        int bag = surger/5;
        int total = surger - (bag*5);

        while(true){
            // 남은 값이 3의 배수인 경우
            if(total%3 == 0){
                return (total/3) + bag;
            }
            // 5와 3으로 나눠지지않는 경우
            if(bag == 0)
                break;
            bag--;
            total = surger -(bag *5);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = sol(Integer.parseInt(br.readLine()));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
