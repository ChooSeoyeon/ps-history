/*
[설명]
- 사진마다 등장하는 인물의 그리움 점수 모두 합산한 추억 점수를 매길거임
- 인물이 4명인데 3명의 그리움 점수만 주어질 수도 있음. 이땐 3명의 그리움 점수만 합함
- 인물 이름 담은 배열 name(3[3..7]..100) 중복 x. 소문자.
- 인물의 그리움 점수 담은 배열 yearning(3..100)
- 각 사진에 찍힌 인물 이름 담은 이차원 배열 photo(3[3..7]..100) 중복 x. 소문자.
- photo 순서대로 추억 점수 배열에 담아 return
[접근] HashMap, HashSet 사용
- name(key)과 yearing(value)을 HashMap에 저장
- name과 photo 비교해서 겹치는 원소 구하기. 
- 겹치는 원소로 HashMap에서 yearing 값 찾기
- yearing 합해서 result에 저장.
*/
import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];      
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < name.length; i++) {
            map.put(name[i], Integer.valueOf(yearning[i]));
        }
        
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                sum += map.getOrDefault(photo[i][j], 0);
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}