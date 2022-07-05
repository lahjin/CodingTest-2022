package boj.bronze;

import java.io.*;
import java.util.Arrays;

/**
 * 2022-07-05
 * BOJ 2309
 * 암호
 * 브론즈1
 * 40분
 * https://www.acmicpc.net/problem/2309
 * 이중 루프문을 효과적으로 탈출하는 방법을 배움
 */
public class 일곱난쟁이_2309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] children = new int[9];

        int sum = 0;
        for(int i=0; i< 9; i++){
            children[i] = Integer.parseInt(br.readLine());
            sum += children[i];
        }
        Arrays.sort(children);

        int idx1=0, idx2=0;

        loop:
        for(idx1 = 0; idx1<children.length-1; idx1++){
            int m1 = sum - children[idx1];
            for(idx2 = idx1+1; idx2<children.length; idx2++){
                int m2 = m1 - children[idx2];
                if(m2 == 100) {
                    break loop;
                }
            }
        }

        for(int i=0; i<9; i++){
            if(i == idx1 || i == idx2) continue;
            System.out.println(children[i]);
        }
    }
}
