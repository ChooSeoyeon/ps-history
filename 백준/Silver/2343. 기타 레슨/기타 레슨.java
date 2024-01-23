import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 블루레이엔 강의를 주어진 순서대로 넣을 수 있음
- 블루레이의 크기를 최소로 할 때 블루레이의 크기 구하기
- 블루레이의 개수는 고정되어 있음
[접근] 매개변수 탐색
- 정답을 매개변수로 만들고, yes/no문제로 만들기
	- 매개변수 : 블루레이의 크기
	- 문제 : 이 크기에 모든 그룹이 들어갈 수 있니?
- yes/no 결과들이 정렬된 상태의 배열이 될 지 미리 확인해보기
	- 매개변수 : 9, 10, ... , 44, 45
	- 결과 : no, no, ... yes, yes
- 매개변수의 범위를 이분 탐색하기
	- 찾을 것 : yes가 나오는 것 중 최소값 찾기 -> yes가 나오는 최초의 지점 찾기
	- 타깃 : 최초로 yes가 나오는 곳
	- 이분탐색 :
		- mid가 no일 떄 :
			- result를 mid로 갱신하기
			- mid가 타깃보다 작다고 간주하고, 탐색 범위를 mid보다 큰 쪽으로 변경
		- mid가 yes일 때 :
			- mid가 타깃보다 크다고 간주하고, 탐색 범위를 mid보다 작은 쪽으로 변경
				- 타깃보다 큰 것으로 간주하는 이유는 최소의 값을 찾아야 하기에 지금 찾은 yes보다 작은 게 더 있는지 확인하기 위함
- yes/no 문제에 답하기
[메모]
- 최적화 문제를 결정 문제로 바꾸기 (질문의 앞뒤를 바꿔서 정답을 매개변수로 두게 하기)
	- 최적화 문제
		- Q) (모든 그룹이 들어갈 수 있는) (크기)는 몇 이니?
		- A) 17
	- 결정 문제
		- Q) 이 (크기)에 (모든 그룹이 들어갈 수 있니)?
		- A) O/x
- 블루레이의 최소 크기 : 9(가장 큰 거), 최대 크기 : 45(전부 다 합한 거)
	- 어쨌든, 가장 큰 수는 들어갈 수 있어야 함
- 구간합은 굳이 의미 앖을듯? 어차피 모든 합 다 봐야 해서..
- 이분탐색
	- mid가 no일 때 == mid가 타깃(yes가 최초로 나오는 지점)보다 작을 때
		- 정답을 현재 mid의 위치로 갱신
		- 타깃이 mid보다 크므로, 탐색 범위를 mid보다 큰 쪽으로 변경
	- mid가 yes일 때 == mid가 타깃(yes가 최초로 나오는 지점)보다 크거나 가틀 때
		- 타깃이 mid보다 작으므로, 탐색 범위를 mid보다 작은 쪽으로 변경
[오답]
- 처음에 yes/no 정답 구하는 걸 틀림
	- 블루레이 크기 * 개수(3) 가 전체 합한 것보다 크거나 같으면 yes ->  반례) 15*3=45
- isPossible은 매개변수 탐색 코드 직접 예시 안 보고 구현하는 데에 너무 많은 생각을 하고선 더이상 생각할 힘이 안 남아있어서 참고함 ㅠ 꼭 다시 생각해보기
	https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-2343-%EA%B8%B0%ED%83%80-%EB%A0%88%EC%8A%A8-java?category=1049955
- 메모리 초과 나서 parameters 배열 없애고 int형 변수 숫자 올려가며 이용하게 변경함
*/
public class Main {
	private static int[] numbers;
	private static int sum;
	private static int n;
	private static int m;

	private static int solution() {
		calculateSum();
		return binarySearch();
	}

	private static void calculateSum() {
		sum = 0;
		for (int number : numbers) {
			sum += number;
		}
	}

	private static boolean isPossible(int limit) {
		int idx = 0;
		for (int i = 0; i < m; i++) {
			int sum = 0;
			while (idx < n && sum <= limit) {
				if (sum + numbers[idx] > limit)
					break;
				sum += numbers[idx++];
			}
		}
		return idx == n;
	}

	private static int binarySearch() {
		int result = 0;
		int left = numbers[numbers.length - 1];
		int right = sum;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (!isPossible(mid)) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return result + 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		numbers = new int[n];
		input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}

		System.out.println(solution());

		br.close();
	}
}