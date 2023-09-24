/*
[설명]
- 영어 단어가 적힌 카드 뭉치 두 개
- 카드에 적힌 단어 사용해 원하는 단어 만들 수 있는지 알아내기
    - 원하는 카드 뭉치에서 카드 순서대로 한 장씩 사용
    - 한 번 사용한 카드는 다시 사용 불가, 순서인데 사용 안하는 것도 불가
    - 카드 뭉치의 단어 순서 변경 불가
[접근] dfs
- 양쪽 다 맨 앞 확인 (인덱스 범위 확인 필수)
- 둘 중 현재 goal과 일치하는 단어 있으면 해당 뭉치 인덱스 증가
- 둘 중 현재 goal과 일치하는 단어 없으면 no 반환
- 둘 다 현재 goal과 일치하면, 일단 앞에거 사용
    - 대신 temp에 현재 인덱스 저장해두고 후에 일치하는 게 없을 때 
    - 여기로 돌아와서 다른쪽거 사용해보기
*/
import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        return dfs(cards1, cards2, goal, 0, 0, 0);
    }
    
    public String dfs(String[] cards1, String[] cards2, String[] goal, int i, int j, int k) {
        if(k == goal.length) return "Yes";
        if(i < cards1.length && goal[k].equals(cards1[i])) {
            return dfs(cards1, cards2, goal, i + 1, j, k + 1);
        }
        if(j < cards2.length && goal[k].equals(cards2[j])) {
            return dfs(cards1, cards2, goal, i, j + 1, k + 1);
        }
        return "No";
    }
}