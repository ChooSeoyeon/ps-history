import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
[설명]
- 오름차순 정렬하기
- 10000보다 작거나 같은 자연수
[접근] 기수 정렬로 풀기
- 자릿수 5로 취급하고, 5번 반복
	- 1의 자릿수로 정렬
	- 10의 자릿수로 정렬
	...
	- 1000의 자릿수로 정렬
	- 10000의 자릿수로 정렬
[메모]
- 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다.
- 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
[오답]
- 메모리 초과남
	- 결과 임시 저장하던 temp 없앰 -> 여전히 남
	- 값들을 다 저장하지않고, 카운트하는 방식으로 바꿔서 해결함 (doit 코드 참고함)
	- 혹은, 중복되는 수 카운트 세두고 나중에 처리하게 하는 방식도 가능하다고 함
*/
public class Main {
	private static int[] numbers;
	private static int[] powerOfTen = new int[5];

	private static void initPowerOfTen() {
		powerOfTen[0] = 1;
		for (int i = 1; i < 5; i++) {
			powerOfTen[i] = powerOfTen[i - 1] * 10;
		}
	}

	private static int findDigitNum(int x, int a) {
		return (x / powerOfTen[a]) % 10; // 10^a
	}

	private static void solution(int n, int maxSize) {
		initPowerOfTen();

		for (int i = 0; i < maxSize; i++) {
			int[] temp = new int[n];  // 사실상 swap 느낌이라 temp 필요함
			int[] bucket = new int[10];

			for (int j = 0; j < n; j++) {
				int digitNumber = findDigitNum(numbers[j], i);
				bucket[digitNumber]++;
			}

			for (int j = 1; j < bucket.length; j++) {
				bucket[j] += bucket[j - 1]; // 구간합
			}

			for (int j = n - 1; j >= 0; j--) {
				int digitNumber = findDigitNum(numbers[j], i);
				int tempIdx = bucket[digitNumber] - 1;
				temp[tempIdx] = numbers[j];
				bucket[digitNumber]--;
			}

			for (int j = 0; j < n; j++) {
				numbers[j] = temp[j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		solution(n, 5);

		for (int i = 0; i < n; i++) {
			bw.write(numbers[i] + "\n");
		}

		bw.flush();
		br.close();
	}
}