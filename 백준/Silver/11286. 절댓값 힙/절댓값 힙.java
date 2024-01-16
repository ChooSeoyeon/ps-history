import java.util.PriorityQueue;

/*
[설명]
- 절대값 힙
	- 비어있는 배열에 0이 아닌 정수를 넣음
	- 배열에서 절대값이 가장 작은 값 출력하고, 그 값을 배열에서 제거함
	- 절대값 가장 작은 게 두 개 일 때는 둘 중 음수를 출력하고, 그 값을 배열에서 제거함
- 0 나오면 출력, 0 아닌게 나오면 정수 넣는 거 의미함
[접근] 우선순위 큐
- 우선순위 큐는 기본적으로 작은 수가 더 높은 우선순위를 가지고, 높은 우선순위를 가진 원소가 먼저 나옴
- 절대값 작은 게 우선순위 높게 + 절대값 같을 땐 음수가 우선순위 높게 조건 변경
[메모]
- 일반적인 pq.poll 시 나오는 순서 = [-2, -1, -1, -1, 1, 1, 1, 2]
- 구현할 pq.poll 시 나오는 순서 = [-2, 2, -1, -1, -1, 1, 1, 1]
*/
public class Main {
	private static String solution(int n, int[] numbers) {
		StringBuilder answer = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(
			(o1, o2) -> {
				if (Math.abs(o1) == Math.abs(o2)) {
					return o1 > o2 ? 1 : -1; // 절대값 더 큰 수가 더 큰 수(낮은 우선순위)
				} else {
					return Math.abs(o1) > Math.abs(o2) ? 1 : -1; // 양수가 더 큰 수(낮은 우선순위)
				}
			}
		);

		for (int i = 0; i < n; i++) {
			if (numbers[i] == 0) {
				if (pq.isEmpty()) {
					answer.append("0\n");
				} else {
					answer.append(pq.poll()).append("\n");
				}
			} else {
				pq.add(numbers[i]);
			}
		}
		return answer.toString();
	}

	public static void main(String[] args) throws Exception {
		java.util.Scanner sc = new java.util.Scanner(System.in);

		int n = sc.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}

		System.out.println(solution(n, numbers));

		sc.close();
	}
}