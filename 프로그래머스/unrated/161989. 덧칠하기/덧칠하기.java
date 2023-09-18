/*
[설명]
- 페인트 칠해진 길이 n 미터 벽에 포스터 붙였다 뗄 때 페인트 벗겨짐
- 페인트 덧칠하는데 전체 칠하지 않고, 구역 나눠서 일부만 페인트 칠할 거임
- 벽을 1 미터 길이의 구역 n개로 나누고, 왼쪽부터 1번부터 n번까지 번호 붙임
- m 미터짜리 롤러로 벽 칠하는데 롤러는 한 번 칠할 때 
    - 벽을 벗어나면 안되고, 
    - 구역의 일부분만 포함되도록 칠하면 안됨
    - 구역 경계선 혹은 벽의 끝 부분에 맞춘 후 롤러 위아래로 움직임
- 페인트 벗겨진 부분을 모두 적어도 한 번은 페인트칠하고 동시에 페인트칠 횟수를 최소화하려 함
- 벽의 가로 길이 n, 롤러 가로 길이 m, 페인트 벗겨진 구역 번호 담긴 배열 section
[접근] 그리디
- 세로 길이는 안중요함. 그냥 1 미터라고 가정해도 무방함
- 가로 길이를 따져야 함. 가로 차례대로 가면서 카운트 새기. 대신 아닌 건 재빠르게 넘기기.
*/
import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) { 
        int answer = 1; 
        int temp = section[0] + m;
        for(int i = 1; i < section.length; i++) {
            if(section[i] < temp) continue;
            answer++; 
            temp = section[i] + m;
            if(temp > n) break;
        }
        return answer;
    }
}