/*
[설명]
- 0~9 쓰인 카드들로 만들 수 있는 소수 개수 반환
[접근]
- 만들 수 있는 모든 숫자 만든 후, (순열+중복제거)
- 소수 판별하기 (에라토스테네스의 체)
*/
import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] visited = new boolean[7];
    
    public int solution(String numbers) {
        int answer = 0;
        
        for(int i=0; i<numbers.length(); i++) {
            perm(numbers, "", i+1);
        }
        
        for(Integer s : set) {
            if(sosu((int)s)) answer++;
        }
        
        return answer;
    }
    
    private void perm(String str, String temp, int r) {
        if(temp.length() == r) {
            set.add(Integer.parseInt(temp));
            return;
        }
        
        for(int i=0; i<str.length(); i++) {
            if(!visited[i]) {
                temp += str.charAt(i);
                visited[i] = true;
                perm(str, temp, r);
                visited[i] = false;
                temp = temp.substring(0, temp.length()-1);
            }
        }
    }
    
    private boolean sosu(int n) {
        if(n < 2) return false;
        for(int i = 2; i*i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}