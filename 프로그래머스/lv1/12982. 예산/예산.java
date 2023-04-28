import java.util.*;
/*
[설명]
- 금액보다 모자라게 예산 주는 건 안됨
- d: 부서 별 신청한 금액 배열 (길이 : 1~100 ,원소 : 1~십만)
- budget : 예산 (1~천만)
- 예산 내에서 최대 몇 개 부서에 지원 가능한지 return
[접근]
- 처음에 잘못 접근했던 방법) 최대 구하는 거니까 전부 다 주는 거에서 한 개씩, 두 개씩 제외하는 거로 점점 적어지게 가기
- 두번째 접근 방법) 작은 수부터 더해서 budget보다 커지면 종료. 작은 수부터 더하는게 최대 개수 나오는 방법임.
*/
class Solution {
    public int solution(int[] d, int budget) {
        int sum = 0;
        Arrays.sort(d); // 작은 수부터 더할 수 있게 정렬
        for(int i=0; i<d.length; i++) {
            sum += d[i];
            if(sum>budget) { // 예산 넘어가면 그 전거까지가 최대개수. 현재 인덱스는 전꺼까지의 개수임.
                return i;
            }
        }
        return d.length;// break 한번도 안되고 다 더했으면 sum <=budget인거니 전체 개수가 최대개수.
    }
}