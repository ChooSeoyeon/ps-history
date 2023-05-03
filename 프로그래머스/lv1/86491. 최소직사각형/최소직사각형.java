import java.util.*;
/*
[문제 설명]
- 다양한 크기의 명합 수납할 수 있는 가장 작은 지갑
- 가로,세로 상관 없이 큰 쪽, 작은 쪽으로 구분!
- 모든 명함 길이를 큰 쪽, 작은 쪽으로 나눠 저장한 후
- 큰 쪽 중 가장 큰 값, 작은 쪽 중 가장 큰 값으로 지갑 만들면 됨
[문제 접근]
- 완전 탐색_브루트포스
*/

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int big = 0;
        int small = 0;
        
        // 명함 개수만큼 반복
        for(int i=0; i<sizes.length; i++) {
            big = Math.max(big, Math.max(sizes[i][0], sizes[i][1])); // 둘 중 더 큰 애들 중 최대값
            small = Math.max(small, Math.min(sizes[i][0], sizes[i][1])); // 둘 중 더 작은 애들 중 최대값
        }
        
        answer = big*small;
    
        return answer;
    }
}