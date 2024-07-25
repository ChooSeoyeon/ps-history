/*
[problem]
- return: 주어진 문자열 s를 JadenCase로 바꾼 문자열
    - JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열
        - 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됨
- given: 문자열 s
[solve]
*/
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] words = s.split("");
        char past = ' ';
        for (String word : words) {
            char c = word.charAt(0);
            if (past == ' ') {
                answer.append(word.substring(0, 1).toUpperCase());
            } else {
                answer.append(word.substring(0, 1).toLowerCase());
            }
            past = c;
        }
        
        return answer.toString();
    }
}