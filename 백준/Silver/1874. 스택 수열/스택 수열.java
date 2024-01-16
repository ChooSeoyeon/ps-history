import java.util.Stack;

/*
[설명] https://www.acmicpc.net/problem/1874
- 1~n까지 수를 오름차순 지켜서 스택에 push
- push와 pop 연산 적절히 조합해 수행함으로써 원하는 수열 만들기
- 수열 만들기 위해 필요한 연산을 push는 +로, pop은 -로 출력하기
[접근] 스택
- 스택에 1부터 push 하다가 원하는 값 나오면 pop
	- 원하는 값이 스택에 현재 있는 수보다 작으면 NO
	- 원하는 값이 스택에 현재 있는 수보다 크거나, 스택이 비어있으면 push 기록
	- 원하는 값이 스택에 현재 있는 수와 같으면 pop 기록 + 다음 원하는 값 보기
- 숫자 다 찾았거나(반복문 다 돌았을 때) NO 나왔을 때 종료
[메모]
*/
public class Main {
	private static String solution(int n, int[] numbers) {
		Stack<Integer> stack = new Stack<>();
		StringBuilder answer = new StringBuilder();
		int inputNumber = 1;
		int index = 0;
		while (index < n) {
			if (stack.isEmpty() || stack.peek() < numbers[index]) {
				stack.push(inputNumber++);
				answer.append("+\n");
			} else if (stack.peek() == numbers[index]) {
				stack.pop();
				index++;
				answer.append("-\n");
			} else {
				return "NO";
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