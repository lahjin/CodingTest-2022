package pgs.level2;

import java.util.*;

/**
 * 2022-08-27
 * PGS
 * 오픈채팅방
 * level2
 * 30분
 * https://school.programmers.co.kr/learn/courses/30/lessons/42888
 * Map과 List에 Class값을 넣으면 좀 더 편하게 짤수있을 듯
 */
public class 오픈채팅방 {
    public String[] solution(String[] record) {
        // key : id value : nickname
        Map<String, String> user = new HashMap<>();
        // Option(Enter, Leave, Change) + id
        List<String> list = new ArrayList<>();

        for(int i=0; i<record.length; i++){
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter")){
                user.put(s[1], s[2]);
                list.add("Enter " + s[1]);
            }else if(s[0].equals("Leave")){
                list.add("Leave " + s[1]);
            }else{ // Change
                user.put(s[1], s[2]);
            }
        }
        
        String[] answer = new String[list.size()];

        for(int i=0; i<list.size(); i++){
            String[] log = list.get(i).split(" ");

            if(log[0].equals("Enter")){
                answer[i] = user.get(log[1]) + "님이 들어왔습니다.";
            }else{ // Leave
                answer[i] = user.get(log[1]) + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}
