import java.util.LinkedList;

/*
[설명] https://www.acmicpc.net/problem/1021
- N개의 원소 갖는 양방향 순환 큐. 세 가지 연산 수행 가능함.
	- 1. 맨 앞의 원소 뽑아내기
	- 2. 왼쪽으로 한 칸 이동시키기 == 맨 앞의 원소가 맨 뒤로 감
	- 3. 오른쪽으로 한 칸 이동시키기 == 맨 뒤의 원소가 맨 앞으로 감
[접근] 덱
- 세 가지 연산을 덱을 이용하면 쉽게 구현할 수 있음
	- 1. 맨 앞의 원소 뽑아내기 -> pollFirst()
	- 2. 맨 앞의 원소가 맨 뒤로 감 -> n=pollFirst(), addLast(n)
	- 3. 맨 뒤의 원소가 맨 앞으로 감 -> n=pollLast(), addFirst(n)
	- 연산 중 2,3 번의 횟수 카운트
- 어떤 연산을 할 지 결정하는 건 인덱스를 보고 알아내자
	- user가 원하는 인덱스가 전체에서 절반보다 작거나 같으면 2번 연산, 절반보다 크면 3번 연산을 하면 됨
	- 2번과 3번 연산을 수차례 진행한 후 항상 1번 연산 진행하면 됨
		- 여기서 수차례는, user가 원하는 인덱스가 3인 경우 1과 2를 맨 뒤로 보내는 두 번을 의미함
		- user 인덱스가 8인 경우 8, 9, 10을 맨 앞으로 보내는 세 번을 의미함
[메모]
- N개 원소 중 인덱스로 찾는 거긴 하지만, 가장 처음 인덱스를 기준으로 찾아야 하기에 처음 인덱스를 값으로 넣어두자.
*/
public class Main {
	private static int solution(int n, int[] numbers) {
		int two = 0;
		int three = 0;

		LinkedList<Integer> deque = new LinkedList<>();
		for (int i = n; i > 0; i--) {
			deque.addFirst(i);
		}

		for (int number : numbers) {
			int halfIndex = deque.size() / 2;
			int numberIndex = deque.indexOf(number);
			if (numberIndex == 0) {
				deque.pollFirst();
				continue;
			} else if (numberIndex <= halfIndex) {
				for (int i = 0; i < numberIndex; i++) {
					Integer target = deque.pollFirst();
					deque.addLast(target);
					two++;
				}
			} else {
				for (int i = 0; i < deque.size() - numberIndex; i++) {
					Integer target = deque.pollLast();
					deque.addFirst(target);
					three++;
				}
			}
			deque.pollFirst();
		}
		return two + three;
	}

	public static void main(String[] args) throws Exception {
		java.util.Scanner sc = new java.util.Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] numbers = new int[m];
		for (int i = 0; i < m; i++) {
			numbers[i] = sc.nextInt();
		}

		System.out.println(solution(n, numbers));

		sc.close();
	}
}