import java.util.*;
/*
[설명]
- 3개 수 더해서 소수 되는 경우의 수 구하기
- nums에 1~1000 사이의 3개 이상 50개 이하 수 들어있고, 중복은 없음
[접근]
- 조합 구하기 : 백트래킹 안쓰고 그냥 3중 for문으로 구함
- 소수인지 확인하기 : 에라토스테네스의 체
*/
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    if(sosu(nums[i] + nums[j] + nums[k])) answer++;
                    // System.out.print(nums[i] + " " + nums[j] + " " + nums[k] + "\n");
                }
            }
        }

        return answer;
    }
    
    public boolean sosu(int n) {
        if(n < 2) return false;
        for(int i=2; i <= (int)Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}