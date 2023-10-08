/*
[설명]
- 문자열 비손실 압축
- 기존 방식 : 반복되는 문자는 횟수+문자 꼴로 표현
    - aabbaccc -> 2a2ba3c (1은 표현 x)
    - 반복되는 문자 적은 경우 압축률 낮음
- 새 방식 : 기존 방식에서 단위가 문자가 아니라 문자열
    - ab/ab/cd/cd/ab/ab/cd/cd -> 2ab/2cd/2ab/2cd (2개 단위)
    - ababcdcd/ababcdcd -> 2ababcdcd (8개 단위)
    - ab/ca/bc/de/de -> abcabc/2de (2개 단위)
    - abc/abc/ded/e -> 2abc/dede (3개 단위)
- 문자열 s를 1개 이상의 단위로 잘라 압축한 결과 중 가장 짧은 것의 길이를 반환
[접근] Stack, ArrayList
- 자르고, 압축문을 스택에 넣기
- 스택에 넣을 때 규칙
    - 자른 것들 차례대로 스택에 넣기 시도
    - 넣기 전에 스택의 맨 위에 거랑 비교
    - 비교했을 때 같으면 맨 위에 거 빼서 숫자 붙이거나 증가시켜서 다시 넣기
    - 비교했을 때 다르면 그대로 넣기
- 정답 : 스택들 길이 중 가장 짧은 것이 정답
*/
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int min = 1001;
        int len = s.length()/2;
        int result = 0;

        for(int i = 0; i <= s.length()/2; i++) {
            String[] arr = split(i + 1, s);
            result = compress(arr);
            if(min > result) min = result;
        }
        
        return min;
    }
    
    private int compress(String[] arr) {
        Stack<String> stack = new Stack<>();
        int sum = 0;
        for(String str : arr) {
            if(!stack.empty()) {
                String compare = stack.peek().replaceAll("[0-9]", "");
                if(str.equals(compare)) {
                    String temp = stack.pop();
                    String num = "2";
                    String tempNum = temp.replaceAll("[^0-9]","");
                    if(!tempNum.equals("")) {
                        int n = Integer.valueOf(tempNum) + 1;
                        num = String.valueOf(n);
                    }
                    str = num + compare;
                }
            }
            stack.push(str);
        }
        
        while(!stack.empty()) {
            String str = stack.pop();
            sum += str.length();
        }
        
        return sum;
    }
    
    private String[] split(int unit, String s) {
        ArrayList<String> list = new ArrayList<String>();
        int i;
        
        for(i = unit; i < s.length(); i += unit) {
            list.add(s.substring(i-unit, i));
        }
        
        list.add(s.substring(i-unit, s.length()));
        
        return list.toArray(new String[list.size()]);
    }
}