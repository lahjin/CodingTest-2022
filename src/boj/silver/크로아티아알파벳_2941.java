package boj.silver;

import java.io.*;
/**
 * 2022-07-12
 * BOJ 2941
 * 크로아티아 알파벳
 * 실버5
 * 1시간 30분
 * https://www.acmicpc.net/problem/2941
 * StringTokenizer로 해결할려다가 단순한 if문으로 처리 후 StringIndexOutOfBounds 처리 고민을 더 해야할듯
 */
public class 크로아티아알파벳_2941{
    
    public static int croatia(String s){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(i == s.length()-1){
                count++;
                continue;
            }else if(c == 'c'){
                if(s.charAt(i+1) == '=' || s.charAt(i+1) == '-'){
                    count++;
                    i++;
                    continue;
                }
            }else if(c == 'd'){
                if(s.charAt(i+1) == '-'){
                    count++;
                    i++;
                    continue;
                }else if(i < s.length()-2 && s.charAt(i+1) == 'z' && s.charAt(i+2) == '='){
                    count++;
                    i += 2;
                    continue;
                }
            }else if (c == 'l' || c == 'n'){
                if(s.charAt(i+1) == 'j'){
                    count++;
                    i++;
                    continue;
                }
            }else if(c == 's' || c == 'z'){
                if(s.charAt(i+1) == '='){
                    count++;
                    i++;
                    continue;
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count = croatia(input);
        System.out.println(count);
    }
}