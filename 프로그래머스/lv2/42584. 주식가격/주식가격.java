/*
[설명]
- 초 단위로 기록된 주식 가격이 담긴 배열에서
- 각 원소가 이후 몇 초동안 가격 떨어지지 않았는지 찾기
[접근] 스택
- 스택에 0초부터 시간을 순서대로 push
- 이때, peek초 일때의 값 보다 작은 값이 들어가기 전엔 pop
- (들어갈 값이 peek초 일때의 값보다 크거나 같아질 때까지) 혹은 (empty 일때까지) pop
- pop 할 땐 answer 배열의 해당 원소 위치(peek)에 몇 초간 지속(i-peek)됐는지 계산해서 넣어주기
- 마지막 시간까지 모두 스택에 넣었다면 answer 배열의 남은 원소들 위치에 몇 초간 지속(마지막 시간-peek)됐는지 계산해서 넣어주기
*/
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int fullTime = prices.length - 1; // 4초 (0초부터 시작)
        
        Stack<Integer> time = new Stack<Integer>();
        
        for(int i = 0; i <= fullTime; i++) {
            while(!time.empty() && prices[time.peek()] > prices[i]) {
                answer[time.peek()] = i - time.peek();
                time.pop();
            }
            time.push(i);
        }
        
        while (!time.isEmpty()) {
            answer[time.peek()] = fullTime - time.peek();
            time.pop();
        }
        
        return answer;
    }
}