/*
[설명]
- 모든 알파벳을 일정 거리만큼 밀어서 다른 알파벳으로 바꿔 암호화
- 문자열 s를 거리 n만큼 민 암호문 만들어 반환하기
[접근]
- 문자열 -> 문자배열
*/
import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] ca = s.toCharArray();
        for(char c : ca) {
            if(c >= 'a' && c <= 'z') {
                c += n;
                if(c > 'z') c -= 26;
            }
            if(c >= 'A' && c <= 'Z') {
                c += n;
                if(c > 'Z') c -= 26;
            }
            answer += String.valueOf(c);
        }
        return answer;
    }
}