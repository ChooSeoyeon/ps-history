import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
[설명]
- N개의 도시에 대해 한 도시에서 출발해서 다른 도시에 도착하는 M개의 버스 있음
- A번쨰 도시에서 B번째 도시까지 가는데 드는 최소 비용 구하기
- 도시 번호는 1~N -> 노드 : 도시
- 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수 -> 에지 : 버스 비용
[접근] 다익스트라
0. 가중치 있는 그래프를 인접리스트로 표현하기
1. 우선순위 큐에 (거리, 노드)꼴로 (0, 시작점)을 추가, 최단 거리 배열에 시작점은 0으로, 나머지는 큰 수로 초기화
2. 우선순위 큐에서 거리가 가장 작은 원소를 pop하여 선택하고, 원소의 거리가 최단 거리 배열의 값과 같은지 확인
3. 선택한 노드와 이웃한 노드들의 최단 거리 갱신되어야 하면, 최단 거리 테이블 값 변경하고 우선순위 큐에 (거리, 노드)를 추가
	- 최단 거리 계산 : min(선택 노드의 최단 거리+에지 가중치, 이웃 노드의 최단 거리)
4. 우선순위 큐 빌 때까지 2,3을 반복
[메모]
- 다익스트라 택한 이유
	- 시작점에서 다른 노드 가는 최단 경로 구해야 함 -> 시작점 없으면 플로이드 워셜
	- 음수 간선(버스비용) 없음 -> 음수 간선 있으면 벨만 포드
[오답]
- Comparable<Edge>, compareTo 부분은 이전 코드 참고함
*/
public class Main {
	private static class Edge implements Comparable<Edge> {
		private int weight;
		private int node;

		public Edge(int weight, int node) {
			this.weight = weight;
			this.node = node;
		}

		public int compareTo(Edge e) {
			if (this.weight > e.weight) {
				return 1; // weight 이 큰 녀석이 큰 녀석이란 의미 -> 후에 우선순위 큐에선 큰 녀석이 우선순위 낮을 거임
			} else {
				return -1;
			}
		}
	}

	private static int solution(int n, int m, int[][] numbers, int start, int end) {
		// 0. 그래프를 인접리스트로 표현 -> 원소: (거리,노드) 꼴
		ArrayList<Edge>[] graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i <= m; i++) { // u에서 v로 가는 가중치가 w
			int u = numbers[i][0];
			int v = numbers[i][1];
			int w = numbers[i][2];
			graph[u].add(new Edge(w, v));
		}

		// 1. 우선순위 큐에 원소(거리 0, 시작노드) 넣고, 최단 경로 배열(0 혹은 큰수) 초기화
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, start));

		int[] distance = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			distance[i] = 99_999_999;
			if (i == start) {
				distance[i] = 0;
			}
		}

		while (!pq.isEmpty()) {
			// 2. 우선순위 큐에서 거리 가장 작은 원소 pop해 선택. 선택한 원소의 거리랑 최단 거리 배열에서의 거리가 다르면 버리고 다른 원소 선택
			Edge select = pq.poll();
			if (select.weight != distance[select.node]) {
				continue;
			}

			// 3. 선택한 원소의 노드에 이웃한 원소의 노드들의 최단 거리가 갱신될 때엔, 최단 거리 배열의 거리 값 변경하고 우선순위 큐에 (최단거리,노드) 넣기
			// 최단 거리 계산 : min(선택 원소의 노드의 최단거리 + 이웃 원소의 거리, 이웃 원소의 노드의 최단거리)
			for (Edge near : graph[select.node]) {
				int min = Math.min(select.weight + near.weight, distance[near.node]);
				if (min != distance[near.node]) {
					distance[near.node] = min;
					pq.add(new Edge(min, near.node));
				}
			}
		}

		return distance[end];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 도시 개수 -> 노드 개수
		int m = Integer.parseInt(br.readLine()); // 버스 개수 -> 에지 개수

		int[][] numbers = new int[m + 1][3];
		String[] input;
		for (int i = 1; i <= m; i++) {
			input = br.readLine().split(" "); // 출발 도시 번호 u, 도착 도시 번호 v, 버스 비용 w
			for (int j = 0; j < 3; j++) {
				numbers[i][j] = Integer.parseInt(input[j]);
			}
		}

		input = br.readLine().split(" ");
		int start = Integer.parseInt(input[0]); // 출발 도시 -> 시작 노드
		int end = Integer.parseInt(input[1]); // 도착 도시 -> 도착 노드

		System.out.println(solution(n, m, numbers, start, end));

		br.close();
	}
}