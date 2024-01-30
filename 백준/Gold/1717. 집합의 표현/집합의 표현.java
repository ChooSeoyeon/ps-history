import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 초기에 n+1개의 집합(1,2...n)이 있음
- 이 집합에 연산 수행함
	- 0 a b : a가 포함된 집합과 b가 포함된 집합을 합치는 연산 (합집합 연산)
	- 1 a b : 두 원소 a, b가 같은 집합에 포함되어 있는지 확인하는 연산 -> YES, NO 출력
- a와 b는 같을 수도 있음
[접근] 유니온파인드
- union : find로 대표노드 찾은 후 합침
	- 두 대표노드에 대해 둘 중 작은 노드만 대표노드로 남기고, 나머지 큰 노드의 대표노드를 본인이 아닌 작은 노드로 변경
- find : 대표노드 찾음
	- 인덱스와 값이 같을 때까지 재귀
	- 인덱스와 값이 같은 경우가 대표노드인데 이 값으로 재귀 과정 중 마주한 노드들의 대표노드값을 업데이트
- isSameGroup : 같은 집합에 포함되어 있는지 확인함 -> find 연산을 내부적으로 사용해도 됨
	- 대표노드가 같은지 확인
[메모]
*/
public class Main {
	private static int[] graph;

	private static String solution(int n, int[][] questions) {
		initGraph(n);
		StringBuilder answer = new StringBuilder();
		for (int[] question : questions) {
			int operator = question[0];
			int operand1 = question[1];
			int operand2 = question[2];
			if (operator == 0) {
				union(operand1, operand2);
			} else if (operator == 1) {
				boolean result = isSameGroup(operand1, operand2);
				answer.append(result ? "YES\n" : "NO\n");
			}
		}

		return answer.toString();
	}

	private static void initGraph(int n) {
		graph = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = i;
		}
	}

	private static int find(int target) {
		if (graph[target] == target)
			return target;
		int parent = find(graph[target]);
		graph[target] = parent;
		return parent;
	}

	private static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		if (aParent <= bParent) {
			graph[bParent] = aParent;
		} else {
			graph[aParent] = bParent;
		}
	}

	private static boolean isSameGroup(int a, int b) {
		return find(a) == find(b);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		int[][] numbers = new int[m][3];

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			numbers[i][0] = Integer.parseInt(input[0]);
			numbers[i][1] = Integer.parseInt(input[1]);
			numbers[i][2] = Integer.parseInt(input[2]);
		}

		System.out.println(solution(n, numbers));

		br.close();
	}
}