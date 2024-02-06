import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[설명]
- 최소 스패닝 트리의 가중치 출력하기
	- 최소 스패닝 트리: 그래프의 모든 정점들을 연결하는 부분 그래프 중 가중치 합이 최소인 트리
[접근]
1. 그래프 에지 리스트와 유니온 파인드 리스트 초기화
2. 그래프 가중치 순 오름차순 정렬
3. 가중치 낮은 에지부터 연결 시도
	- union 연산 해봤을 때 연결 가능하면(사이클 생기지 않으면) 연결
[오답]
- 음수 간선 생각 못한 채 graph를 0번째 인덱스 값을 0으로 초기화한 후 정렬 돌렸는데, 0이 원하지 않는 곳에 들어가게 되어 틀렸었음
	- 0번쨰 인덱스부터 실제 값 채우게 변경해 해결함 (나올 수 있는 가장 큰 수 후보가 int형 마지막 숫자라서) -> 질문게시판 참고
	- pq 사용하는 방식으로 변경해도 해결 가능함 -> doit 교재 코드 참고
*/
public class Main {
	private static int[][] graph;
	private static int[] unionfind;

	private static int solution(int n, int m) {
		// 1. 그래프 에지 리스트와 유니온 파인드 리스트 초기화
		unionfind = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			unionfind[i] = i;
		}

		// 2. 그래프 가중치 순 오름차순 정렬
		Arrays.sort(graph, (s1, s2) -> {
			return s1[2] - s2[2]; // 음수면 더 작아서 더 앞에 와야 한단 뜻으로 받아들여서
		});

		// 3. 가중치 낮은 에지부터 연결 시도
		int index = 0;
		int count = 0;
		int edgeCount = 0;
		while (count < n - 1) {
			int start = graph[index][0];
			int end = graph[index][1];
			int weight = graph[index++][2];
			if (isSameGroup(start, end)) {
				continue;
			}
			union(start, end);
			count++;
			edgeCount += weight;
		}

		return edgeCount;
	}

	private static int find(int target) {
		if (target == unionfind[target]) {
			return target;
		}
		int parent = find(unionfind[target]);
		unionfind[target] = parent;
		return parent;
	}

	private static boolean isSameGroup(int start, int end) {
		return find(start) == find(end);
	}

	private static void union(int start, int end) {
		int startParent = find(start);
		int endParent = find(end);
		if (startParent < endParent) {
			unionfind[endParent] = startParent;
		} else {
			unionfind[startParent] = endParent;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		graph = new int[m][3];
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			graph[i][0] = Integer.parseInt(input[0]);
			graph[i][1] = Integer.parseInt(input[1]);
			graph[i][2] = Integer.parseInt(input[2]);
		}

		System.out.println(solution(n, m));

		br.close();
	}
}