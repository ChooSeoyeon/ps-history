/*
[문제]
- return: x부터 시작해 x씩 증가하는 숫자를 n개 갖는 리스트 ([2,4,6,8,10])
- given: x, n (x=2,n=5)
[접근]
*/
import java.util.*;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }
        return answer;
    }
}