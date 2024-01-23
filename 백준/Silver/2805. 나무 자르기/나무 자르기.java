import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[설명]
- 나무에서 절단기 높이 이상의 부분을 자름
- 자른 거 합한 게 M미터 이상이면서, 절단기 높이가 최대한 높을 때 절단기 높이 구하기
[접근] 매개변수 탐색
- 정답을 매개변수로 만들고, yes/no문제로 만들기
	- 매개변수 : 절단기의 높이
	- 문제 : 이 높이로 자른 나무 토막의 합이 M보다 크거나 같니?
- yes/no 결과들이 정렬된 상태의 배열이 될 지 미리 확인해보기
	- 매개변수 : 0, 1, ... ,
	- 결과 : yes, yes,... , no, no
- 매개변수의 범위를 이분 탐색하기
	- 찾을 것 : yes가 나오는 것 중 최소값 찾기 -> no가 나오는 최초의 지점 찾기
	- 타깃 : 최초로 no가 나오는 곳
	- 이분탐색 :
		- mid가 yes일 떄 :
			- result를 mid로 갱신하기
			- 타깃이 미드보다 크다고 간주하고, 탐색 범위를 mid보다 큰 쪽으로 변경
		- mid가 no일 때 :
			- 타깃이 미드보다 작다고 간주하고, 탐색 범위를 mid보다 작은 쪽으로 변경
- yes/no 문제에 답하기
[메모]
- 최적화 문제를 결정 문제로 바꾸기 (질문의 앞뒤를 바꿔서 정답을 매개변수로 두게 하기)
	- 최적화 문제
		- Q) (원하는 길이 M만큼을 얻을 수 있는) 최대 (높이)는 몇 이니?
		- A) 15
	- 결정 문제
		- Q) 이 (높이)에 (원하는 길이 M만큼을 얻어갈 수 있니)? 의 답변 중 최대일 때 구하기
		- A) O/x
- 높이의 최소 크기 : 0, 최대 크기 : 가장 높은 나무의 높이
[오답]
- 메모리 초과...............왜 나는데 -> 매개변수 배열 따로 안 만들고, 그냥 long 타입 숫자 이용했음
	- 내가 원한 매개변수 배열 : { 0, 1, 2, ..., 가장 큰 나무 높이 }
*/
public class Main {
	private static long[] numbers;
	private static int n;
	private static int m;

	private static long solution() {
		Arrays.sort(numbers);
		return binarySearch();
	}

	private static boolean isPossible(long target) {
		long sum = 0;
		for (long number : numbers) {
			long part = number - target;
			part = Math.max(part, 0);
			sum += part;
		}
		return sum >= m;
	}

	private static long binarySearch() {
		long result = 0;
		long left = 0;
		long right = numbers[numbers.length - 1];

		while (left <= right) {
			long mid = (left + right) / 2;
			if (isPossible(mid)) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		numbers = new long[n];
		input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			numbers[i] = Long.parseLong(input[i]);
		}

		System.out.println(solution());

		br.close();
	}
}