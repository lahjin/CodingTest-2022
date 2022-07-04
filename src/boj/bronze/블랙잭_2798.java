package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2022-07-04
 * BOJ 2798
 * 블랙잭
 * 브론즈2
 * 30분
 * https://www.acmicpc.net/problem/2798
 * 경우의 수를 탐색할려다가 브루트포스 방식으로 변경
 */
public class 블랙잭_2798 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        String[] NK = input.split(" ");
        
        int n = Integer.parseInt(NK[0]);
        int m = Integer.parseInt(NK[1]);

        String input2 = br.readLine();
        String[] cards = input2.split(" ");
        int[] cardList = new int[n];
        
        for(int i=0; i<cards.length; i++){
            cardList[i] = Integer.parseInt(cards[i]);
        }

        int max = 0;

        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    int sum = cardList[i] + cardList[j] + cardList[k];
                    if(sum == m){
                        max = sum;
                        break;
                    }
                    if(sum > max && sum < m){
                        max =  sum;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
