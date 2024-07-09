import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 로또: 1..49 중 6개 고름
	- 번호 선택 전략: 49가지 수 중 k(k>6)개 수를 골라 집합 s 만든 후 그 수만 가지고 번호 택하기
- 집합 s와 k개 주어졌을 때, 수를 고르는 모든 방법 구하기
	- s는 오름차순으로 주어짐
[접근] 조합 -> 백트래킹(길의 끝이 보이면 분기점으로 돌아감)&재귀 vs dfs
- 작은 순서부터 하나씩 뽑음
- 6개 다 고르면, 바로 전 분기로 돌아가기
- ex) 1,2,3,4,5,6
	- 1,2,3 -> 1,2,4 -> 1,2,5 -> 1,2,6
	- 1,3,4 -> 1,3,5 -> 1,3,6
	- 1,4,5 -> 1,4,6
	- 1,5,6
	- 2,3,4 -> 2,3,5 -> 2,3,6
	- 2,4,5 -> 2,4,6
	- 2,5,6
	- 3,4,5 -> 3,4,6
	- 3,5,6
[오답]
- 백트래킹 구현 까먹어서 내 블로그에 정리해둔 조합 글 참고함
*/
public class Main {
    private static int[] arr;
    private static boolean[] visited;

    private static void solution(int[] numbers) {
        arr = new int[numbers.length];
        visited = new boolean[numbers.length];
        backtracking(0, numbers);
    }

    private static void backtracking(int point, int[] numbers) {
        if (point == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i] && ((point == 0) || (arr[point - 1] < numbers[i]))) {
                visited[i] = true;
                arr[point] = numbers[i];
                backtracking(point + 1, numbers);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            if (n == 0) {
                break;
            }

            int[] numbers = new int[n];
            for (int i = 1; i <= n; i++) {
                numbers[i - 1] = Integer.parseInt(input[i]);
            }
            solution(numbers);
            System.out.println();
        }

        br.close();
    }
}
