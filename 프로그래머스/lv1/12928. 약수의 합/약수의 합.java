import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n/2; i++) { // 2의 짝꿍까지만 더해주면 됨. 그 다음은 1의 짝꿍인 n임.
            if(n%i==0) {
                answer+=i;
            }
        }
        return answer+n;
    }
}