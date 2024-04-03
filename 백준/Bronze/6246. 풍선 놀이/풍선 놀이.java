import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
[설명]
- 풍선 엮어서 긴 풍선 줄 만들기
- 풍선 줄엔 풍선을 매달 수 있는 N개의 슬롯이 있음
- 각 슬롯은 1번부터 N(30)번까지 번호가 붙어있음
- Q(3)번에 걸쳐서 규칙적으로 풍선을 꽂고 빈 슬롯의 개수 세기
    - 1번 규칙: 1번 슬롯부터 3개씩 띄어서 풍선을 놓자
        - 1, 4, 7, 10, 13, 16, 19, 22, 25, 28 -> 10개
    - 2번 규칙: 3번 슬롯부터 7개씩 띄어서 풍선을 놓자
    ...
[접근]
- N*Q가 1,000,000으로 1억 안 넘기에 전부 접근해도 괜찮음
- 풍선 꽂을 자리 각 규칙마다 찾아서 HashSet에 전부 때려박고 마지막에 HashSet개수 세서 정답 구하자
[메모]
*/
public class Main {
    private static int solution(int n, int[][] numbers) {
        HashSet<Integer> set = new HashSet<>();

        for (int[] number : numbers) {
            int j = number[0];
            int jump = number[1];
            while (j <= n) {
                set.add(j);
                j += jump;
            }
        }

        return n - set.size();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);

        int[][] numbers = new int[q][2];
        for (int i = 0; i < q; i++) {
            input = br.readLine().split(" ");
            numbers[i][0] = Integer.parseInt(input[0]);
            numbers[i][1] = Integer.parseInt(input[1]);
        }

        System.out.println(solution(n, numbers));

        br.close();
    }
}