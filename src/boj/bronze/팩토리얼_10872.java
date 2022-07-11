package boj.bronze;

import java.io.*;
/**
 * 2022-07-11
 * BOJ 10872
 * 팩토리얼
 * 브론즈5
 * 10분
 * https://www.acmicpc.net/problem/10872
 * 필드를 사용하지않고 재귀함수를 사용하는 방법에 익숙해져야 될듯하다.
 */
public class 팩토리얼_10872{
    
    static int d=1;
    static int s=1;

    // 필드로 값을 저장하여 구현 (재귀함수의 이해가 부족했음)
    public static void myFactorial(int n){
        s *= d++;
        if(d > n){
            return;
        }
        myFactorial(n);
    }

    // 재귀함수로 구현한 팩토리얼 구하기
    public static int rfFactorial(int n){
        if(n > 1)
            return n * rfFactorial(n-1);
        return 1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        myFactorial(input);
        System.out.println(s);
        //System.out.println(rfFactorial(input));
    }
}