/*
[설명]
- 밑변의 길이와 높이가 n(1..1000)인 삼각형
- 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기 진행 후 
- 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열 return
- 예시 : (1 / 2 6 / 3 4 5) (1 / 2 9 / 3 10 8 / 4 5 6 7)
[접근]
- 이차원 배열 이용 
- n = 5라면 0(0,1,2,3,4)->1(1,2,3,4)->2(2,3,4)->3(3,4)->4(4)
- 정답을 담은 배열 크기는 n(n+1)/2 = 15
- 마지막으로 숫자 넣은 곳 [i][j]라 표현할 때
- i % 3 == 0-> [i][j] 주어지면 -> [i+1][j] -> [i+2][j] ...
- i % 3 == 1 -> [i][j] 주어지면 -> [i][j+1] -> [i][j+2]...
- i % 3 == 2 -> [i][j] 주어지면 -> [i-1][j-1] -> [i-2][j-2]...
*/

class Solution {
    
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] triangle = new int[n][n];
        int lastValue = 1;
        int lastI = -1;
        int lastJ = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i % 3 == 0) {
                    lastI++;
                }
                else if(i % 3 == 1) {
                    lastJ++;
                }
                else {
                    lastI--;
                    lastJ--;
                }
                triangle[lastI][lastJ] = lastValue++;
            }
        }
        
        int k = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(triangle[i][j] == 0) break;
                answer[k++] = triangle[i][j];
            }
        }
        
        return answer;
    }
}
