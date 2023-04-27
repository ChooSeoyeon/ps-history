import java.util.*;
/*
[설명]
- 로또 : 1~45 중 6개 찍어 맞추기(순서 상관x)(숫자 중복x)
- 훼손된 일부 번호(0)을 다른 번호로 가정해, 로또 최고 순위&최저 순위 배열에 담아 return
- 민우 : lottos, 당첨 : win_nums
[접근]
- 최저는 민우의 현재 번호 가지고 검사하면 됨
- 최고는 현재 번호 맞는 거 개수 + 0의 개수
*/

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        for(int i=0; i<6; i++) {
            if(lottos[i]==0) answer[0]++;
            else {
                for(int j: win_nums){
                    if(j == lottos[i]) {
                        answer[0]++;
                        answer[1]++;
                    }        
                }
            }
            // Arrays.asList(win_nums).contains(lottos[i])
        }
        answer[0]=7-answer[0];
        answer[1]=7-answer[1];
        if(answer[0]==7) answer[0]--;
        if(answer[1]==7) answer[1]--;
        return answer;
    }
}