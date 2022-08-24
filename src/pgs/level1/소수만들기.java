package pgs.level1;

/**
 * 2022-08-25
 * PGS
 * 소수 만들기
 * Level1
 * 1시간
 * https://school.programmers.co.kr/learn/courses/30/lessons/12977
 * 소수 알고리즘은 복잡하게 생각하지말고 메서드를 생성하여 판단하자
 */
public class 소수만들기 {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(isPrime(nums[i] + nums[j] + nums[k])) 
                        answer++;
                }
            }
        }

        return answer;
    }

    public boolean isPrime(int n){
        if(n < 2) return false;
        if(n == 2) return true;

        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
