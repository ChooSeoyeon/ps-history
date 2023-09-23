/*
[설명]
- 하나의 키에 무작위로 여러 문자 할당 
    - 아예 할당 안되어있을 수도 있음
    - 하나의 키에 같은 문자가 여러 번 할당될 수도 있음
    - 하나의 문자가 여러 키에 할당될 수도 있음
- 특정 문자열 작성하려면 키를 눌러야 하는 최소 횟수 return (작성 불가능할 땐 -1 return)
- 1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 배열 keymap[1[1..100]..100]
- 입력하려는 문자열이 담긴 배열 targets[1[1..100]..100]
[접근]
- String의 indexOf 함수 써서 target의 각 문자열의 index 찾기
- 단 찾을 때 여러 키에서 다 찾아야 함. 그 중 가장 최소 횟수 누르는 경우 찾기
- 가장 최소 횟수를 sum에 더하기
*/
import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i=0; i<targets.length; i++) {
            int sum = 0;
            for(int j=0; j<targets[i].length(); j++) {
                char target = targets[i].charAt(j);
                int small = 1000;
                for(String key : keymap) {
                    int idx = key.indexOf(target);
                    if(idx == -1) continue;
                    if(small > idx) small = idx + 1;
                }
                sum += small;
            }
            answer[i] = sum < 1000 ? sum : -1;
        }
        
        return answer;
    }
}