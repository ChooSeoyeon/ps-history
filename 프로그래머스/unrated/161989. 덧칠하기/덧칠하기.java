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