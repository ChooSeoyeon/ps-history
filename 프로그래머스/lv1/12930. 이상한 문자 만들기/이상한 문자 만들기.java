/*
[설명]
- 하나 이상의 공백 문자로 구분 된 단어들로 구성된 문자열 s (단어는 최소 한 개 이상)
- 각 단어의 짝수 알파벳은 대문자로, 홀수는 소문자로 바꿔 리턴 (단어 별로 짝/홀수 인덱스 판단. 0부터 시작)
[접근]
- 반복문 돌리다 공백 아닐 때 인덱스 세서 짝수 인덱스만 대문자로 바꿔주자.
*/

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int i = -1;
        for(String letter : s.split("")) {
            i = letter.equals(" ") ? -1 : i + 1;
            letter = (i % 2 == 0) ? letter.toUpperCase() : letter.toLowerCase();
            answer += letter;
        }
        return answer;
    }
}