/*
[설명]
- 문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줌
    - z 넘어갈 경우 다시 a로 돌아옴
    - skip에 있는 알파벳은 제외하고 건너뜀 (skip의 알파벳은 s에 포함되지 않음)
[접근]
- skip에 있는 알파벳 제외한 a to z 알파벳 담고 있는 문자 배열 만들기
- 문자 배열의 인덱스 이동해서 해당 값으로 원래 값 교체하기
*/
import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(char c : skip.toCharArray()) {
            alphabet = alphabet.replace(String.valueOf(c), "");
        }
        for(char c : s.toCharArray()) {
            int base = alphabet.indexOf(c);
            int length = alphabet.length();
            answer += String.valueOf(alphabet.charAt((base + index) % length));
        }
        return answer;
    }
}