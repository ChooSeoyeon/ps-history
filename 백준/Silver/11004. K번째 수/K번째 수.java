import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[설명]
- A를 오름차순 정렬했을 때, 앞에서부터 K번째에 있는 수 구하기
[접근] 일단 기본 정렬로 구현하고, 퀵 정렬로 구현해보기
[메모]
*/
public class Main {
	private static int solution(int k, int[] numbers) {
		Arrays.sort(numbers);
		return numbers[k - 1];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}

		System.out.println(solution(k, numbers));

		br.close();
	}
}