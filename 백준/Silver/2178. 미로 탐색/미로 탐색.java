import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
[설명]
- 1은 이동 가능, 0은 이동 불가능
- (1,1)에서 (N,M)의 위치로 이동할 때 지나야 하는 최소 칸 수 구하기
- 칸 수에 시작 위치와 도착 위치 포함
[접근] BFS
- BFS를 선택한 이유
	- 최단 경로의 거리 구하기
	- 이미 방문한 칸은 다시 가지 않고, 탐색하기
- 미로 생성
	- 미로의 맨 앞줄, 맨 뒷줄, 맨 오른쪽줄, 맨 왼쪽줄은 0으로 채워두기
- DFS 구현
	- 큐에 갈 수 있는 칸들 칸의 이름으로 저장해두기
- 최단 경로 관리
	- DFS 탐색 시 이전 값을 같이 저장해두기
[메모]
- i * (m+2) + j = 칸의 이름
- 칸의 이름을 m으로 나눴을 때 몫(내림)이 i, 나머지가 j
	- 0/8 -? 몫 : 0, 나머지 : 0 -> [0][0]
	- 1/8 -> 몫 : 0.x, 나머지 : 1 -> [0][1]
	- 2/8 -> 몫 : 0.x, 나머지 : 2 -> [0][2]
	- 6/8 -> 목 : 0.x, 나머지 : 6 -> [0][6]
	- 7/8 -> 몫: 0.x, 나머지 : 7 -> [0][7]
	- 8/8 -> 몫 : 1, 나머지 : 0 -> [1][0]
	- 9/8 -> 몫 : 1, 나머지 : 1 -> [1][1]
	- 11/8 -> 몫 : 1.x 나머지 : 3 -> [1][3]
	- 12/8 -> 몫 : 1.x, 나머지 : 4 -> [1][4]
	- 13/8 -> 몫 : 1.x, 나머지 : 5 -> [1][5]
[오답]
	- m+2 쓰기로 해놓고, m 써서 범위밖으로 나갔었음
	- dfs는 무사히 마쳤는데, 전체 경로를 세었음. 최단 경로만 따로 카운트 하는 법 몰랐음
	- 최단 경로만 따로 카운트 하기 위해 각 경로의 부모 노드를 저장하는 배열을 따로 만들면 된단 걸 다른 사람 조언으로 알게 됨
*/
public class Main {
	private static int n;
	private static int m;
	private static int[][] maze;
	private static boolean[] visited; // maze를 1차원 배열로 펼쳐서 봄
	private static int[] parent;

	private static int solution() {
		int count = 0;

		int startName = makeName(1, 1);
		int endName = makeName(n, m);
		parent = new int[(n + 2) * (m + 2)];
		visited = new boolean[(n + 2) * (m + 2)];
		visited[startName] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startName);

		while (!queue.isEmpty()) {
			int nodeName = queue.poll();
			if (nodeName == endName) {
				break;
			}
			for (int nearNodeName : findNearNodeNameByName(nodeName)) {
				if (isMovableByName(nearNodeName)) {
					queue.add(nearNodeName);
					visited[nearNodeName] = true;
					parent[nearNodeName] = nodeName;
				}
			}
		}

		while (true) {
			count++;
			if (parent[endName] == startName) {
				break;
			}
			endName = parent[endName];
		}

		return count + 1;
	}

	private static int makeName(int i, int j) {
		return i * (m + 2) + j;
	}

	private static int[] findNearNodeNameByName(int name) {
		int[] result = new int[4];
		result[0] = name - (m + 2);
		result[1] = name + (m + 2);
		result[2] = name - 1;
		result[3] = name + 1;
		return result;
	}

	private static boolean isMovableByName(int name) {
		int i = name / (m + 2); // int는 소수점 들어오면 자동으로 버림처리함
		int j = name % (m + 2);
		return maze[i][j] == 1 && !visited[name];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		maze = new int[n + 2][m + 2];
		for (int i = 1; i <= n; i++) {
			input = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				maze[i][j + 1] = Integer.parseInt(input[j]);
			}
		}

		System.out.println(solution());

		br.close();
	}
}