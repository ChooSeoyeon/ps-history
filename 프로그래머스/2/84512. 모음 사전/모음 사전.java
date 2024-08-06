/*
[problem]
- given: 단어 하나 word
    - 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록
    - 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"
- return: 단어가 사전에서 몇 번째 단어인지
[solve]
- I -> 1 + (781)*2 = 1563
- AE -> 2 + (156)*1 = 158
- AAE -> 3 + (31)*1 = 34
- AAAE -> 4 + (6)*1 = 10
- AAAAE -> 5 + (1)*1 = 6

- 1
- 6 = 1+(1)*5
- 31 = 1+(6)*5
- 156 = 1+(31)*5
- 781 = 1+(156)*5

- A~Z 는 28개
    A, -> 1 
        AA, -> 2
            AAA, -> 3
                AAAA, -> 4
                    AAAAA, AAAAE, AAAAI, AAAAO, AAAAU, -> 5..9
                AAAE, -> 10 (+6) = (1+1*5)
                    ... -> 11..15
                AAAI, -> 16
                    AAAIA, AAAIE, AAAII, AAAIO, AAAIU, -> 17..21
                AAAO, -> 22
                    ... -> 23..27
                AAAU, -> 28
                    ... -> 29..33
            AAE, -> 34 (+31) = (1+6*5)
                AAEA, -> 35
                    AAEAA, AAEAE, AAEAI, AAEAO, AAEAU, -> 36..40
                AAEE, -> 41
                    ...
                AAEI, -> 47
                    ...
                AAEO, -> 53
                    ...
                AAEU, -> 59
                    ... -> 60..64
            AAI, ... -> 65
            AAO, ... -> 96
            AAU, ... -> 127
        AE, ... -> 158 (+156) = (1+31*5)
        AI, ... -> 314
        AO, ... -> 470
        AU, ... -> 626
    E, -> 782 (+781) = (1+156*5)
        EA,
        E
*/
import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int turn = findTurn(c);
            int jumpNumber = makeJumpNumber(i);
            if (turn == 0) {
                answer += 1;
            } else {
                answer += jumpNumber * turn + 1;
            }
        }
        return answer;
    }
    
    private int makeJumpNumber(int digit) {
        int number = 1;
        for (int i = 1; i < 5 - digit; i++) {
            number = 1 + number * 5;
        }
        return number;
    }
    
    private int findTurn(char alpha) {
        if (alpha == 'A') {
            return 0;
        }
        if (alpha == 'E') {
            return 1;
        }
        if (alpha == 'I') {
            return 2;
        }
        if (alpha == 'O') {
            return 3;
        }
        if (alpha == 'U') {
            return 4;
        }
        throw new IllegalArgumentException();
    }
}
