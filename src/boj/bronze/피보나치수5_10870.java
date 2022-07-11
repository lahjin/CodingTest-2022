package boj.bronze;

import java.io.*;
/**
 * 2022-07-11
 * BOJ 10870
 * 팩토리얼
 * 브론즈5
 * 1시간
 * https://www.acmicpc.net/problem/10870
 * 문제에 답이 있었지만 찾아내지 못했고 재귀함수의 흐름은 이해했지만 직접 구현하는건 어려운듯하다.
 */
public class 피보나치수5_10870 {

    public static int rfFibonacci(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        return rfFibonacci(n-1) + rfFibonacci(n-2);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(rfFibonacci(n));
    }
}
