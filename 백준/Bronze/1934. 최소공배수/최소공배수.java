import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 최소공배수 구하기
[접근] 유클리드 호제법
[메모]
*/
public class Main {
	private static int[] solution(int n, int[][] numbers) {
		int[] answers = new int[n];
		for (int i = 0; i < n; i++) {
			answers[i] = lcm(numbers[i][0], numbers[i][1]);
		}
		return answers;
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	private static int lcm(int a, int b) {
		return a / gcd(a, b) * b;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] numbers = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			numbers[i][0] = Integer.parseInt(input[0]);
			numbers[i][1] = Integer.parseInt(input[1]);
		}

		int[] answers = solution(n, numbers);
		for (int answer : answers) {
			System.out.println(answer);
		}

		br.close();
	}
}