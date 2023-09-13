/*
[설명]
- 행렬곱 결과 반환
- 곱할 수 있는 배열만 주어짐
- arr1, arr2[2[-10..20]..100][2..100]
[접근]
- arr1의 행(가로)과 arr2의 열(세로)을 곱함
- answer의 행 개수는 arr1의 행 개수(arr1.length)와 같고, -> i
- answer의 열 개수는 arr2의 열 개수(arr2[0].length)와 같음 -> j
- 각 행과 열을 곱할 땐[i][j] arr1의 열 개수(== arr2의 행 개수)만큼 반복하며 각 원소를 곱해주면 됨 -> k
*/
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr2[0].length; j++) {
                int sum = 0;
                for(int k=0; k<arr2.length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        
        return answer;
    }
}