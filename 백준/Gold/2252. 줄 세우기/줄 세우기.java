import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
[설명]
- N명의 학생들을 키 순서대로 줄 세우기
- 두 학생의 키 비교한 결과가 선후 관계 꼴로 주어짐 -> A B 는 A가 B 앞에 서야 한단 의미
- 모든 학생 다 비교해보진 않음
[접근] 위상정렬
1. 그래프를 인접리스트로 표현하면서 진입차수배열 초기화
2. 진입차수가 0인 노드들을 큐에 넣기
3. 큐에서 뺀 노드를 정렬 결과에 넣고, 해당 노드가 가리키는 노드들의 진입차수 값을 1씩 빼기
	- 1을 뺐을 때 진입차수가 0이 된 노드는 큐에 넣기
4. 큐가 빌 때까지 3을 반복
5. 개수로 비교했을 때 정렬 결과에 모든 노드가 들어가지 않았다면, 사이클 존재하는 것이니 예외 처리 -> 이 문제에선 필요 x
[메모]
- 위상정렬 택한 이유
	- 선후관계 명확히 주어짐
	- 답이 여러 가지인 경우 아무거나 출력해도 된다함
	- 키가 완전히 똑같은 경우는 존재하지 않음 -> 사이클 x
*/
public class Main {
	private static int[] solution(int n, int m, int[][] numbers) {
		// 1. 그래프를 인접리스트로 표현하면서 진입차수배열 초기화
		ArrayList<Integer>[] graph = new ArrayList[n + 1];
		int[] inDegree = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			graph[numbers[i][0]].add(numbers[i][1]);
			inDegree[numbers[i][1]]++;
		}

		// 2. 진입차수가 0인 노드들을 큐에 넣기
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		// 3~4. 큐에서 뺀 노드를 정렬 결과에 넣고, 해당 노드가 가리키는 노드들의 진입차수 값을 1씩 빼기. 이때, 진입 차수가 0이 된 노드는 큐에 넣기
		ArrayList<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			int targetNode = queue.poll();
			result.add(targetNode);
			for (int nearNode : graph[targetNode]) {
				inDegree[nearNode]--;
				if (inDegree[nearNode] == 0) {
					queue.add(nearNode);
				}
			}
		}

		// 5. 개수로 비교했을 때 정렬 결과에 모든 노드가 들어가지 않았다면, 사이클 존재하는 것이니 예외 처리
		if (result.size() != n) {
			throw new IllegalArgumentException("사이클이 존재합니다");
		}

		return result.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		int[][] numbers = new int[m][2];
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			numbers[i][0] = Integer.parseInt(input[0]);
			numbers[i][1] = Integer.parseInt(input[1]);
		}

		int[] answers = solution(n, m, numbers);
		for (int answer : answers) {
			System.out.print(answer + " ");
		}

		br.close();
	}
}