package boj.silver;

import java.io.*;
import java.util.*;

/**
 * 2022-07-05
 * BOJ 1244
 * 스위치 켜고 끄기
 * 실버 3
 * 1시간 30분
 * https://www.acmicpc.net/problem/1244
 * 스위치를 배열로 해결할려고 하다가 Hash를 사용해서 해결
 * StringTokenizer로 가져오는 토큰도 String 타입이므로 == 으로 비교 불가 equals() 메소드 사용
 */
public class 스위치켜고끄기_1244 {

    static HashMap<Integer,Boolean> sw = new HashMap<>();

    public static void checkGender(int g, int n){
        // 남자일때
        if(g == 1){
            // n의 배수로 size/n 횟수만큼 스위치를 바꾼다.
            for(int i=1; i<= sw.size()/n; i++){
                switchCtrl(i*n);
            }
        }
        // 여자일때
        else{
            int beginIdx = n-1; // n보다 1 작은 값부터 시작
            int endIdx = n+1; // n보다 1 큰값부터 시작

            // 특정 조건일때만 탈출하는 무한 루프
            while(true){
                // beginIdx가 0이 되어 null일때와 beginIdx와 endIdx가 일치하지않으면 탈출
                if(sw.get(beginIdx) == null || sw.get(beginIdx) != sw.get(endIdx)){
                    break;
                }else{
                    // 그외 조건일시 양쪽 범위를 1씩 늘림
                    beginIdx--;
                    endIdx++;
                }
            }
            // 시작과 끝의 1의 범위를 줄인 값만큼 루프
            for(int i=beginIdx+1; i<=endIdx-1; i++){
                switchCtrl(i);
            }
        }
    }

    // hash값을 true false 반대로 바꾸는 메소드
    public static void switchCtrl(int idx){
        sw.put(idx, !sw.get(idx));
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        
        int idx = 1;
        while(st.hasMoreTokens()){
            sw.put(idx++, st.nextToken().equals("1") ? true : false);
        }
        
        int stu = Integer.parseInt(br.readLine());

        for(int i=0; i<stu; i++){
            input = br.readLine();
            String[] arr = input.split(" ");
            checkGender(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=sw.size(); i++){
            sb.append(sw.get(i) == true ? "1 " : "0 ");
            if(i%20 == 0){
                System.out.println(sb.toString());
                sb = new StringBuilder();
            }
        }
        System.out.println(sb.toString());
    }

}
