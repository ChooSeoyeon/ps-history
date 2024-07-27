/*
[problem]
- return: 서로 다른 옷의 조합의 수
    - 각 종류별로 최대 1가지 의상만 착용할 수 있음
    - 다른 의상이 겹치지 않거나, 혹은 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산함
    - 하루에 최소 한 개의 의상은 입음
- given: 코니가 가진 의상들이 담긴 2차원 배열 clothes
    - 각 행은 [의상의 이름, 의상의 종류]로 이루어짐
[solve]
- 각 의상 종류 별 의상 개수에 1을 더한 값들을 전부 곱하고 1을 뺌
    - (2+1) * (1+1) - 1 = 5
        - x             | x                 -> 제외
        - yellow_hat    | x
        - green_turban  | x
        - x             | blue_sunglasses
        - yellow_hat    | blue_sunglasses
        - green_turban  | blue_sunglasses
[오답]
- 이상한 쪽으로 복잡하게 생각하다 없는 경우의 수를 곱셈에 이용한단 생각 하지 못해서 힌트 봄 ㅠ.
*/
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for (int value : map.values()) {
            answer *= (value + 1);
        }
        return answer - 1;
    }
}