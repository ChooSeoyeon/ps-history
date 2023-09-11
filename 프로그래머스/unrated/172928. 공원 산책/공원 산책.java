/*
[설명]
- 지나다니는 길은 O, 장애물은 X로 표시된 격자 모양의 공원
- 로봇 강아지는 "E 5" 꼴의 배열에 따라 움직임. 동쪽으로 5칸 이동
- 로봇 강아지는 주어진 방향으로 "이동할 때 공원 벗어나는지"와 "이동 중 장애물 만나는지" 확인함
- 둘 중 하나라도 해당하면 해당 명령 무시하고 다음 명령 수행함
- 공원 가로 길이 W, 세로 길이 H, 좌측 상단 좌표 (0,0), 우측 하단 좌표(H-1, W-1)
- 공원 격자 나타낸 문자열 배열 park(3[3..50]..50)
- 로봇 강아지가 수행할 명령 담긴 문자열 배열 routes(1[N/S/W/E 1~9]..50)
- 로봇 강아지가 모든 명령 수행한 후 놓인 위치의 세로 좌표와 가로 좌표 배열에 담아 반환
[접근]
- 그리디
- N(북) : [x - jump][y]
- S(남) : [x + jump][y]
- W(서) : [x][y - jump]
- E(동) : [x][y + jump]
*/
import java.util.*;

class Solution {
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        for(int i=0; i<park.length; i++) {
            int findS = park[i].indexOf('S');
            if(findS != -1) {
                answer[0] = i;
                answer[1] = findS;
            }
        }
        
        for(int i=0; i<routes.length; i++) {
            char dir = routes[i].charAt(0);
            int jump = routes[i].charAt(2) - '0';
            move(answer, park, dir, jump);
        }
        
        return answer;
    }
    
    private void move(int[] answer, String[] park, char dir, int jump) {
        int x = answer[0];
        int y = answer[1];
        boolean isValid = true;
        
        while(jump > 0) {
            if(dir == 'E') y++;
            else if(dir == 'W') y--;
            else if(dir == 'S') x++;
            else if(dir == 'N') x--;
            else break;
            if(x < 0 || x >= park.length || y < 0 || y >= park[0].length()) {
                isValid = false;
                break;
            }
            if(park[x].charAt(y) == 'X') {
                isValid = false;
                break;
            }
            jump--;
        }
        
        if(isValid) {
            answer[0] = x;
            answer[1] = y;
        }
        
        return;
    }
}