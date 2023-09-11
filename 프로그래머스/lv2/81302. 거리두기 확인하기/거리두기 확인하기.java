/*
[설명]
- 응시자들 거리 둬서 대기함
    - 대기실은 5개, 각 대기실은 5*5 크기
    - 응시자끼리 맨허튼 거리 2 이하로 앉지 않음
        - (r1, c1) (r2, c2) -> Math.abs(r1-r2) + Math.abs(c1-c2) > 2
        - 
    - 응시자 앉아있는 자리 사이가 파티션으로 막힌 경우엔 허용함
- 응시자 P, 빈 테이블 O, 파티션 X로 이루어진 대기실 별 정보 담은 배열 places(5[5][5])
- 자리 잘 지키고 있으면 1(성공), 한 명이라도 안지키면 0(탈락)으로 대기실 별 정보 담은 배열 return[5]
[접근]
- 특정 P에 대해 세 가지 순서대로 체크하면 됨 (단, 면제권도 있음)
    - 상하좌우 한 칸 차이에 P 있음 탈락
    - 상하좌우 두 칸 차이에 P 있음 탈락 (단, 한 칸 갔을 때 파티션 있었으면 탈락 면제라 더 안봐도 됨)
    - 대각선 한 칸 차이에 P 있음 탈락 (단, 둘 사이에 양쪽 다 파티션x 있으면 탈락 면제)
- 상1 : [i-1][j] (i>0)
- 하1 : [i+1][j] (i<4)
- 좌1 : [i][j-1] (j>0)
- 우1 : [i][j+1] (j<4)
- 상1 : [i-2][j] (i>1)
- 하1 : [i+2][j] (i<3)
- 좌1 : [i][j-2] (j>1)
- 우1 : [i][j+2] (j<3)
- 상좌 : [i-1][j-1] (i>0 && j>0)
- 좌하 : [i+1][j-1] (i<4 && j>0)
- 하우 : [i+1][j+1] (i<4 && j<4)
- 우상 : [i-1][j+1] (i>0 && j<4)
*/
import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<5; i++) {
            answer[i] = checkPlace(places[i]);
        }
        
        return answer;
    }
    
    private int checkPlace(String[] place) {
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(place[i].charAt(j) == 'P') {
                    if(!checkPerson(place, i, j)) return 0;
                }
            }
        }
        return 1;
    }
    
    private boolean checkPerson(String[] place, int i, int j) {
        
        char up = 'N', down = 'N', left = 'N', right = 'N';
        
        if(i > 0) {
            up = place[i-1].charAt(j);
            if(up == 'P') return false;
        }
        if(i < 4) {
            down = place[i+1].charAt(j);
            if(down == 'P') return false;
        }
        if(j > 0) {
            left = place[i].charAt(j-1);
            if(left == 'P') return false;
        }
        if(j < 4) {
            right = place[i].charAt(j+1);
            if(right == 'P') return false;
        }
        
        if(i > 1) {
            if(up == 'O' && place[i-2].charAt(j) == 'P') return false;
        }
        if(i < 3) {
            if(down == 'O' && place[i+2].charAt(j) == 'P') return false;
        }
        if(j > 1) {
            if(left == 'O' && place[i].charAt(j-2) == 'P') return false;
        }
        if(j < 3) {
            if(right == 'O' && place[i].charAt(j+2) == 'P') return false;
        }
        
        if(i > 0 && j > 0) { // 상좌
            if(!(up == 'X' && left == 'X') && place[i-1].charAt(j-1) == 'P') return false;
        }
        if(i < 4 && j > 0) { // 좌하
            if(!(left == 'X' && down == 'X') && place[i+1].charAt(j-1) == 'P') return false;
        }
        if(i < 4 && j < 4) { // 하우
            if(!(down == 'X' && right == 'X') && place[i+1].charAt(j+1) == 'P') return false;
        }
        if(i > 0 && j < 4) { // 우상
            if(!(right == 'X' && up == 'X') && place[i-1].charAt(j+1) == 'P') return false;
        }
        
        return true;
    }
}