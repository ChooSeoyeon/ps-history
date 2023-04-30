import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n>0) {
            answer +=1;
            if(n>1) answer +=n;
        }
        
        for(int i=2; i<=(int)Math.sqrt(n); i++) {
            if(n%i==0) {
                answer+=i;
                if(n/i!=i) answer+=(n/i);
            }
        }
        return answer;
    }
}