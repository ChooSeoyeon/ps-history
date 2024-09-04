import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- given: 계단의 개수(1~300), 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수(1~10,000)
- return: 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값
	- 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점가지 가는 게임
	- 계단을 밟으면 그 계단에 쓰여 있는 점수 얻게 됨
	- 계단 오르는 데 규칙 잇음
		- 한 번에 한 계단씩 또는 두 계단씩 오를 수 있음
		- 연속된 세 개의 계단을 모두 밟으면 안됨 (단, 시작점은 계단에 포함 X)
		- 마지막 도착 계단은 반드시 밟아야 함
[접근] DP
- 각 계단 밟았을 때 최대 점수 구하기
	- 각 계단 밟았을 때 최대 점수 = max(연속이게 밟았을 때 점수, 연속 아니게 밟았을 때 점수)
		- 연속이게 밟았을 때 점수 = 지난 계단을 연속 아니게 밟았을 때 점수 + 현재 계단의 점수
		- 연속 아니게 밟았을 때 점수 = 지지난 계단을 밟았을 때 최대 점수 + 현재 계단의 점수
	- 0번째 계단과 1번째 계단은 미리 초기화해두기
[메모]
| 계단 점수					|  0 | 10 | 20 | 15 | 25 | 10 | 20 |
| 연속 밟았을 때 최대 점수		|  0 | 10 | 30 | 35 | 55 | 45 | 75 |
| 연속 아니게 밟았을 때 최대 점수	|  0 | 10 | 10 | 30 | 35 | 55 | 45 |
- 지난 계단에서 연속으로 밟았을 때 점수 = 지지난 계단을 뛰어넘고 지난 계단 밟았을 때 최대 점수 + 현재 계단의 점수
- 지난 계단을 뛰어넘어 밟았을 때 점수 = 지지난 계단 밟았을 떄 최대 점수(지지지난 계단을 밟았는지 여부는 중요 x)
[오답]
- 도저히 안떠올라서 지난 번 풀이 봄. 지난 번에도 다른 사람 풀이 봄..
- 연속이게 연속 아니게를 나눠 가져가야 한다는 걸 인지하기가 어려웠음
- 뒤에서부터 생각하면 편했을 듯 싶음
*/
public class Main {
	private static int solution(int[] numbers) {
		int[][] memory = new int[numbers.length + 1][2];
		memory[0][0] = 0;
		memory[0][1] = 0;
		memory[1][0] = numbers[0];
		memory[1][1] = numbers[0];

		for (int i = 2; i <= numbers.length; i++) {
			memory[i][0] = memory[i - 1][1] + numbers[i - 1];
			memory[i][1] = Math.max(memory[i - 2][0], memory[i - 2][1]) + numbers[i - 1];
		}

		return Math.max(memory[numbers.length][0], memory[numbers.length][1]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(solution(numbers));

		br.close();
	}
}