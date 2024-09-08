import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- given: 집의 수 N(2..1000), (한 줄에 하나씩 1번 집부터) 각 집을 빨강, 초록, 파랑으로 칠하는 비용(1..1000)
- return: 모든 집을 칠하는 비용의 최솟값
	- 1번 집의 색은 2번 집의 색과 같지 않아야 함
	- i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한
	- N번 집의 색은 N-1번 집의 색과 같지 않아야 함
[접근] DP
- 현재 상태가 어떤 과거의 상태로부터 왔는가
	- 현재 색을 칠한 집은 앞에 있는 집을 칠하고서 칠함
- 현재 N번 집에 특정 페인트 칠했을 때의 최솟값 구하기
[메모] 도저히 모르겠어서 정답 보고 품 ㅠ
- 와................. 현재 넣을 수 있는 최솟값을 선택하는 게 아니라, 현재 넣을 거 기준으로 이전거까지의 최솟값 합 중 선택하는 거였음.. 역발상..
	- 그리디가 아니라 DP 문제!
	- 한 칸씩 밟는 느낌! 계단 오르기랑 비슷한듯!
*/
public class Main {
	private static int solution(int n, int[][] costs) {
		int[][] expenses = new int[n][3];
		for (int i = 0; i < 3; i++) {
			expenses[0][i] = costs[0][i];
		}

		for (int i = 1; i < n; i++) {
			expenses[i][0] = costs[i][0] + Math.min(expenses[i - 1][1], expenses[i - 1][2]);
			expenses[i][1] = costs[i][1] + Math.min(expenses[i - 1][0], expenses[i - 1][2]);
			expenses[i][2] = costs[i][2] + Math.min(expenses[i - 1][0], expenses[i - 1][1]);
		}

		return Math.min(Math.min(expenses[n-1][0], expenses[n-1][1]), expenses[n-1][2]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] numbers = new int[n][3];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				numbers[i][j] = Integer.parseInt(input[j]);
			}
		}

		System.out.println(solution(n, numbers));

		br.close();
	}
}
