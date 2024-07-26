/*
[problem]
- return: 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false, 그렇지 않으면 true
- given: 전화번호부에 적힌 전화번호를 담은 배열 phone_book
[solution]
*/
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        for (String phone_num : phone_book) {
            set.add(phone_num);
        }
        
        for (String phone_num : phone_book) {
            for (int i = 0; i <= phone_num.length() - 1; i++) {
                String sub = phone_num.substring(0, i);
                if (set.contains(sub)) {
                    return false;
                }
            }
        }
        return true;
    }
}