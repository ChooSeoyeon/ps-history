import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- N개의 정수로 이루어진 수열이 있음
- 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수
[접근] nCr 조합 -> 백트래킹
[메모]
- 1,2 -> 1,3 -> 1,4 -> 1,5
- 2,3 -> 2,4 -> 2,5
- 3,4 -> 3,5
- 4,5
- 1,2,3 -> 1,2,4 -> 1,2,5 -> 1,3,4 -> 1,3,5 -> 1,4,5
- 2,3,4 -> 2,3,5 -> 2,4,5
- 3,4,5
- 1,2,3,4 -> 1,2,3,5 -> 1,2,4,5 -> 1,3,4,5
- 2,3,4,5
- 1,2,3,4,5
[오답]
- 같은 수 있을 수 있어서?
- 시간초과나서 방법 아예 바꿈 ㅠ 이 방식은 모르겠어서 답지 거의 보고 품. 나중에 다시 풀 필요 있음.
*/
public class Main {
    private static int count = 0;

    private static int solution(int n, int s, int[] numbers) {
        backtracking(0, 0, n, s, numbers);
        return count;
    }

    private static void backtracking(int x, int sum, int n, int s, int[] numbers) {
        if (x == n) {
            return;
        }
        if (sum + numbers[x] == s) {
            count++;
        }

        backtracking(x + 1, sum + numbers[x], n, s, numbers);
        backtracking(x + 1, sum, n, s, numbers);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        int[] numbers = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        System.out.println(solution(n, s, numbers));

        br.close();
    }
}
