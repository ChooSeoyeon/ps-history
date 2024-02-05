import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- n개의 도시 있음. 한 도시에서 출발해 다른 도시에 도착하는 m개의 버스 있음. 각 버스는 사용 비용 있음
- 모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값 구하기
[접근] 플로이드 워셜
1. 최단 거리 리스트로 그래프 표현
	- 최단 거리 저장하는 리스트에 기본 값으로(0,무한대) 초기화
	- 최단 거리 리스트에 간선 정보 저장
2. 점화식으로 리스트 업데이트
	- min( D[S][E], D[S][K] + D[K][E] )
[메모]
- 플로이드 워셜을 택한 이유
	- 모든 노드 간에 최단 거리를 구해야 했음
[오답]
- 시작 노드와 도착 노드를 연결하는 간선이 하나가 아닐 수 있다는 말 안보고서, 그래프 생성 시 처리 안해줘서 틀릴 뻔 함
- 갈 수없는 경우는 0 출력하랬는데 큰 수 출력 그대로 냅둬서 틀림. 문제 똑바로 읽기.
*/
public class Main {
	private static final int INF = 99_999_999;

	private static int[][] solution(int n, int m, int[][] numbers) {
		int[][] distance = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				distance[i][j] = INF;
			}
		}

		for (int i = 1; i <= n; i++) {
			distance[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			int s = numbers[i][0];
			int e = numbers[i][1];
			int w = numbers[i][2];
			distance[s][e] = Math.min(distance[s][e], w);
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (distance[i][j] == INF) {
					distance[i][j] = 0;
				}
			}
		}

		return distance;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] numbers = new int[m][3];
		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");
			numbers[i][0] = Integer.parseInt(input[0]);
			numbers[i][1] = Integer.parseInt(input[1]);
			numbers[i][2] = Integer.parseInt(input[2]);
		}

		int[][] answers = solution(n, m, numbers);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(answers[i][j] + " ");
			}
			System.out.println();
		}

		br.close();
	}
}