import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
[설명]
- M이상 N 이하의 소수를 모두 출력하기
[접근] 소수 구하기 (에라토스테네스의 체)
- 범위 내 소수 출력 -> 에라토스테네스의 체 이용
[메모] 최적화 전 코드
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}
[오답]
- 에라토스테네스의 체 구현이 퍼뜩 머리에 안떠올라서 이전에 짠 코드 봐버림..ㅠ
- 최적화도 이전에 짠 거 참고함
*/
public class Main {
	private static int[] solution(int m, int n) {
		boolean[] isPrime = new boolean[n + 1]; // 1~n까지. 소수인지 여부 (isPrime[3]=true면 3이 소수라는 뜻)
		Arrays.fill(isPrime, true); // 전부 true로 초기화
		isPrime[1] = false; // 1은 합성수니 false로 미리 지정

		for (int i = 2; i * i <= n; i++) { // n의 제곱근까지만 검사 (1,3,5,15라면 3까지만 봐도 됨)
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) { // i=5라면, 5*2, 5*3, 5*4는 이미 false로 되어 있으므로, 5*5부터 보면됨
					isPrime[j] = false;
				}
			}
		}

		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = m; i <= n; i++) {
			if (isPrime[i]) {
				answer.add(i);
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);

		int[] answers = solution(m, n);
		for (int answer : answers) {
			System.out.println(answer);
		}

		br.close();
	}
}