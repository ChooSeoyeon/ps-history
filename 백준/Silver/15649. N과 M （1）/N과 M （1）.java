import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 1부터 N까지 자연수 중 중복 없이 M개를 고른 수열 모두 구하기
[접근] 조합(nCr) -> 백트래킹
- 1,2 -> 1,3 -> 1,4
- 2,1 -> 2,3 -> 2,4
- 3,1 -> 3,2 -> 3,4
- 4,1 -> 4,2 -> 4,3
[메모]
*/
public class Main {
    private static int[] arr;
    private static boolean[] visited;

    private static void solution(int n, int m) {
        arr = new int[m];
        visited = new boolean[n + 1];
        backtracking(0, n, m);
    }

    private static void backtracking(int x, int n, int m) {
        if (x == m) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                arr[x] = i;
                visited[i] = true;
                backtracking(x + 1, n, m);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        solution(n, m);

        br.close();
    }
}
