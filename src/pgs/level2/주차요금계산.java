package pgs.level2;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 2022-09-02
 * PGS
 * 주차 요금 계산
 * level2
 * 2시간 20분
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 * 전체적인 문제 구조 이해하는게 어려웠음
 * null 체크 조건을 잘못 작성하여 코드 수정에 시간을 많이 소모
 * 아직 자바 라이브러리 기본기가 많이 부족하구나를 느낌
 */
class Solution {
    // 입출차 시간을 기록하는 클래스, 자동차번호는 TreeMap의 key가 가지고있으므로 변수를 만들지않았음
    class Record{
        ArrayList<Integer> in;
        ArrayList<Integer> out;

        public Record(ArrayList<Integer> in, ArrayList<Integer> out){
            this.in = in;
            this.out = out;
        }
    }

    // HH:MM 으로 들어오는 데이터를 분단위로 변환해 주는 메서드
    public int hourToMin(String time){
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }

    public int[] solution(int[] fees, String[] records) {
        // 오름차순으로 출력하므로 TreeMap 사용
        TreeMap<String, Record> map = new TreeMap<>();

        // 입출차 기록표 순회
        for(String s : records){
            // 공백 단위로 스플릿
            String[] ss = s.split(" ");
            // IN(입차) 일 경우
            if(ss[2].equals("IN")){
                // map의 getOrDefault로 하기엔 복잡해 보여서 null로 분기를 나눔
                if(map.get(ss[1]) == null){
                    ArrayList<Integer> list = new ArrayList<>();
                    // 입차 기록을 분단위로 변환해서 List에 추가
                    list.add(hourToMin(ss[0]));
                    map.put(ss[1], new Record(list, new ArrayList<>()));
                }else{
                    // null이 아닌 경우에는 기존의 List(in)에 분단위로 변환해서 추가
                    map.get(ss[1]).in.add(hourToMin(ss[0]));
                }
            }else{ // OUT(출차) 일 경우
                // IN(입차) 기록이 없는데 OUT(출차)가 되는 케이스는 없다고 했음
                // 따라서 기존의 map이 null일 경우는 없으니 기존의 List(out)에 분단위로 변환해서 추가 
                map.get(ss[1]).out.add(hourToMin(ss[0]));
            }
        }
        // 정답을 저장할 변수
        int[] answer = new int[map.size()];
        int idx = 0;
        for(String key : map.keySet()){
            // 입차기록과 출차기록이 같지않다면
            if(map.get(key).in.size() != map.get(key).out.size()){
                // 출차기록에 23:59에 나간것으로 기록한다.
                map.get(key).out.add(1439);
            }

            // answer[idx]에 누적 주차시간을 더한다.
            for(int i=0; i<map.get(key).in.size(); i++){
                answer[idx] += map.get(key).out.get(i) - map.get(key).in.get(i);
            }

            // 기본 시간 이하인 경우
            if(answer[idx] <= fees[0])
                answer[idx] = fees[1]; // 기본요금만 측정
            else{ // 기본 시간을 초과한 경우
                // 초과한 시간 계산
                int overTime = (int) Math.ceil((double)(answer[idx] -fees[0]) / fees[2]);
                answer[idx] = fees[1] + overTime * fees[3];
            }
            idx++;
        }
        
        return answer;
    }
    
}
