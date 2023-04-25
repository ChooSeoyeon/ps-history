import java.util.*;
/*
[문제 설명]
- i~j까지 정렬 후, k번째 수 구하기
[문제 접근]
- 정렬
*/
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<commands.length; i++) {
            // start, end, index는 모두 1부터 시작
            int start = commands[i][0];
            int end = commands[i][1];
            int index = commands[i][2];
            
            int[] slice = Arrays.copyOfRange(array, start-1, end);
            Arrays.sort(slice);
            list.add(slice[index-1]);
        } 
        answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}