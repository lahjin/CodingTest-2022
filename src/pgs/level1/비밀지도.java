package pgs.level1;

import java.util.*;

/**
 * 2022-07-14
 * PGS
 * 비밀지도
 * level1
 * 25분
 * https://school.programmers.co.kr/learn/courses/30/lessons/17681
 * 프로그래머스 스킬체크 레벨1에서 나온 2번문제
 * 2진수와 if문으로 처리하였지만 출제자의 의도는 2진수와 비트 연산을 활용하는 문제
 * 배워야할 기본문법이 아직 많다는걸 느낌
 */
public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // 매핑된 지도를 담는 ArrayList
        ArrayList<String> ls = new ArrayList<>();

        // arr1과 arr2의 길이는 n으로 같기에 루프
        for(int i=0; i< n; i++){
            // arr1과 arr2를 2진법으로 변환하여 앞에 0이 부족한 경우 0을 붙여준다.
            String bArr1 = addZero(n, Integer.toBinaryString(arr1[i]));
            String bArr2 = addZero(n, Integer.toBinaryString(arr2[i]));
            ls.add(mapping(n,bArr1,bArr2));
        }

        return ls.toArray(new String[ls.size()]); //ArrayList를 Array로 변환하여 리턴
    }

    // 0이 부족한 경우 앞에 0을 붙여주는 함수
    public String addZero(int n, String arr){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<n-arr.length(); i++){
            sb.append("0");
        }
        sb.append(arr);
        return sb.toString();
    }

    // #과 공백을 확인하는 함수
    public String mapping(int n, String arr1, String arr2){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<n; i++){
            char c1 = arr1.charAt(i);
            char c2 = arr2.charAt(i);
            if(c1 == '1' || c2 == '1')
                sb.append("#");
            else
                sb.append(" ");
        }
        return sb.toString();
    }
}
