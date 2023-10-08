/*
[설명]
- 10진법 숫자를 3진법으로 변환 후 뒤집고, 다시 10진법으로 변환해 반환
[접근]
- 10진법 -> 3진법 : String str = Integer.toString(25, 3);
- 3진법 -> 10진법 : int num = Integer.parseInt("10001", 3);
*/

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String str = Integer.toString(n, 3);
        StringBuffer sb = new StringBuffer(str);
        String reversedStr = sb.reverse().toString();
        
        return Integer.parseInt(reversedStr, 3);
    }
}