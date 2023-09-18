/*
[설명] 뒤집어 반환
[접근]
- Sol1) StringBuffer(str).reverse().toString()
- Sol2) Collections.reverse(list)
*/
import java.util.stream.Stream;
class Solution {
    public int[] solution(long n) {
        String str = new StringBuffer(String.valueOf(n)).reverse().toString();
        return Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();
    }
}