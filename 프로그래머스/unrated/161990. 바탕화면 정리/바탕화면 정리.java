/*
[설명]
- 격자판의 바탕화면 상태 나타내는 배열 wallpaper (1[1..50]..50)
    - 빈칸은 .
    - 파일은 #
    - 가장 왼쪽 위가 (0,0)
- 최소한의 이동 거리 갖는 한 번의 드래그로 모든 파일 선택해 한 번에 지우려 함
    - S(lux, luy) ~ E(rdx, rdy) -> 시작점 ~ 끝점
    - 드래그한 거리 : Math.abs(rdx-lux) + Math.abs(rdy - luy)
- 최소한의 이동 거리 갖는 시작점과 끝점 담아 return
[접근]
- lux : 최소 x, rdx : 최대 x + 1
- luy : 최소 y, rdy : 최대 y + 1
*/
import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = { 51, 51, -1, -1 }; // lux, luy, rds, rdy
        
        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    if(answer[0] > i) answer[0] = i; // 최소 x
                    if(answer[1] > j) answer[1] = j; // 최소 y
                    if(answer[2] < i) answer[2] = i; // 최대 x
                    if(answer[3] < j) answer[3] = j; // 최대 y
                }
            }
        }
        answer[2]++;
        answer[3]++;
        return answer;
    }
}