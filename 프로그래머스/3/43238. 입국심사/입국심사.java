/*
[설명]
- n명이 심사 받으려 줄 서있음
    - 가장 앞에 서 있는 사람은 빈 심사대로 갈 수 있지만, 더 빨리 끝나는 심사대가 있다면 기다렸다가 그곳으로 가서 심사 받을 수도 있음
- 입국심사대
    - 각 심사대마다 심사하는데 걸리는 시간 다름
    - 처음에 모든 심사대 비어있음
    - 한 심사대에선 동시에 한 명만 심사할 수 있음
- 모든 사람이 심사 받는데 걸리는 시간의 최소값 구하기
[풀이] 매개변수탐색 (심사불가능, 심사불가능,... , 심사가능, 심사가능)
- 6명, [7,10]
    - 모든 사람이 심사 받는데 걸리는 시간: 최소 0분, 최대 10*6=60분
    - 30분동안 심사할 수 있는 사람 수: 7명 = 30/7 + 30/10 = 4 + 3 (심사가능)
    - 15분동안 심사할 수 있는 사람 수: 3명 = 15/7 + 15/10 = 2 + 1 (심사불가능)
    - 22분동안 심사할 수 있는 사람 수: 5명 = 22/7 + 22/10 = 3 + 2 (심사불가능)
    - 26분동안 심사할 수 있는 사람 수: 5명 = 26/7 + 26/10 = 3 + 2 (심사불가능)
    - 28분동안 심사할 수 있는 사람 수: 6명 = 28/7 + 28/10 = 4 + 2 (심사가능)
- 최초의 심사가능 찾으면 됨 (불가능의 최대값 찾아서 +1)
*/
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = findMaxTime(times) * n;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            if (isImpossibleTime(mid, n, times)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer + 1;
    }
    
    private long findMaxTime(int[] times) {
        long max = 0;
        for (int i = 0; i < times.length; i++) {
            if (max < times[i]) {
                max = times[i];
            }
        }
        return max;
    }
    
    private boolean isImpossibleTime(long totalTime, long people, int[] times) {
        long possiblePeople = 0;
        for (int i = 0; i < times.length; i++) {
            possiblePeople += totalTime / times[i];
        }
        return possiblePeople < people;
    }
}