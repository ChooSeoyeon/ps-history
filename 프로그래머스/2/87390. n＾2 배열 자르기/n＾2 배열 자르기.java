/*
[problem]
- return: 규칙대로 만들어진 1차원 배열
    - 규칙
        1. [n][n] 크기의 빈 2차원 배열 만듦
        2. i=1..n에 대해 순서대로 [1][1]부터 [i][i]까지의 영역 내 모든 빈칸을 i로 채움
        3. [1][]..[n][] 을 잘라내어 이어붙인 1차원 배열 만듦
        4. 만든 1차원 배열을 arr이라 할 때 arr[left], arr[left+1], ... arr[right]만 남기고 나머지는 지움
- given: n, left, right
[solve]
- 행에 따라 몇 개까지 첫 번째 숫자가 점령할지 나옴 (첫 번째 숫자 == 행번호, 점령당하지 않은 숫자 == 열번호)
    - 1행은 1개까지 1이 나옴, 나머지는 열 번호 그대로임
    - 2행은 2개까지 2가 나옴, 나머지는 열 번호 그대로임
- 1 2 [3 / 2 2 3] / 3 3 3
    - [2] -> 2 / 3 = 0 .. 2 -> 1행 3열 -> 1 < 2 -> 열번호 -> 3
    - [3] -> 3 / 3 = 1 .. 0 -> 2행 1열 -> 2 >= 1 -> 행번호 -> 2
    - [4] -> 4 / 3 = 1 .. 1 -> 2행 2열 -> 2 >= 2 -> 행번호 -> 2
    - [5] -> 5 / 3 = 1 .. 2 -> 2행 3열 -> 2 < 3 -> 열번호 -> 3
*/
import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int[] answer = new int[size];
        long current = left;
        for (int i = 0; i < size; i++) {
            long row = current / n + 1;
            long column = current % n + 1;
            if (row < column) {
                answer[i] = (int)column;
            } else {
                answer[i] = (int)row;
            }
            current += 1;
        }
        return answer;
    }
}