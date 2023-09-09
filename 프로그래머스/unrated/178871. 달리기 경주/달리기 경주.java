/*
[접근]
- 달리기 경주하면서 추월한(추월당한x) 선수들 이름을 해설진들이 부름
- 선수들 이름이 현재 등수 순서대로 담긴 배열 players(5[3..10]..50000)(중복x)
- 해설진들이 부른 이름들 담긴 배열 callings(2..1000000)
- 경주 끝났을 때 선수들 이름을 등수 순서대로 담아 return
[설명] HashMap
- HashMap에 players 내용 넣기
- 순서 바뀐 두 선수 swap하기
*/
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i<players.length; i++) {
            map.put(players[i], i);
        }
        
        for(String calling : callings) {
            int i = map.get(calling);
            map.put(players[i], i-1);
            map.put(players[i-1], i);
            players[i] = players[i-1];
            players[i-1] = calling;
        }
        
        return players;
    }
}