package pgs.level1;

/**
 * 2022-06-30
 * PGS
 * 시저암호
 * level1
 * 20분
 * https://programmers.co.kr/learn/courses/30/lessons/12926
 */
public class 시저암호 {
    public String solution(String s, int n) {
        String answer = "";

        for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                int as = (int) c;

                if(as >= 65 && as <= 90){
                    as += n;
                    if(as > 90)
                        as -= 26;
                }
                else if(as >=97 && as <= 122){
                    as += n;
                    if(as > 122)
                        as -= 26;
                }

                char cc = (char) as;
                answer += cc;
        }

        return answer;
    }
}
