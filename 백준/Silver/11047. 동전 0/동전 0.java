import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 동전을 적절히 사용해서 그 가치의 합을 K로 만드려 할 때, 필요한 동전 개수의 최솟값
[접근] 그리디
- 4200 보다 작은 수 중 최대값 : 1000 -> 1000으로 최대한 4200을 구성하기
- 200 보다 작은 수 중 최대값 : 200 -> 100으로 최대한 200을 구성하기
[메모]
- 이 문제에 그리디를 쓸 수 있는 이유 : 못 만드는 경우가 나오지 않음 1원 까지 존재하기 떄문에!
- 내 풀이가 그리디인 이유 : 동전을 최소로 쓰려면 큰 액수의 동전부터 먼저 사용해야 함.
	- 해 선택 : 현재 남은 금액을 채울 수 있는 가장 큰 액수의 동전 고르기
	- 적절성 검사 : 고른 동전을 몇 개 사용할 지 정하기
	- 해 검사 : 현재 남은 금액이 0원인지 확인하기
		- 0원이라면, 반복 종료
		- 0원 이상이라면, 남은 금액에 대해 다시 해 선택부터 반복
*/
public class Main {
	private static int[] numbers;

	private static int solution(int k) {
		int count = 0;
		int idx = numbers.length - 1;
		while (k != 0) { // 무조건 k=0이 되는 순간이 있기에 가능 (1원이 존재해서)
			while (numbers[idx] > k) {
				idx--;
			}
			count += (k / numbers[idx]);
			k -= numbers[idx] * (k / numbers[idx]);
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(solution(k));

		br.close();
	}
}