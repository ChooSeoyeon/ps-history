import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
[설명]
- 정사각형으로 이루어진 섬과 바다 지도에서 섬의 개수 세기
    - 섬: 걸어갈 수 있어야 함
    - 걸어갈 수 있음: 한 정사각형과 가로, 세로 또는 대각선으로 연결된 사각형은 걸어갈 수 있음
    - 바다: 지도 밖은 바다로 지도 밖으로 나갈 수 없음
- 입력:
    - 0 0 이 나올 때까지 테스트 케이스 반복
    - 각 테스트 케이스는 높이 w, 너비 h 가 주어지고 지도 중어짐
- 출력: 섬의 개수
[접근] BFS
- 1. 1번 땅부터 걸어갈 수 있는 땅 있는지 탐색
- 2. 탐색 맞췄다면 섬 하나 카운팅하고, 그 다음으로 가장 작은 번호지만 아직 방문하지 않은 땅부터 다시 1번을 반복
*/
public class Main {
    private static int solution(int w, int h, int[][] map) {
        int answer = 0;
        h += 2;
        w += 2;
        boolean[][] visited = new boolean[h][w];

        for (int k = 1; k < h; k++) {
            for (int l = 1; l < w; l++) {
                if (visited[k][l] || map[k][l] == 0) {
                    continue;
                }
                Queue<Integer> queue = new LinkedList<>();
                queue.add(w * k + l);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int nodeI = node / w - 1;
                    int nodeJ = node % w - 1;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (i == 1 && j == 1) {
                                continue;
                            }
                            if ((nodeI + i) >= h || (nodeI + i) < 0 || (nodeJ + j) >= w || (nodeJ + j) < 0) {
                                continue;
                            }
                            if (!visited[nodeI + i][nodeJ + j] && map[nodeI + i][nodeJ + j] == 1) {
                                queue.add(w * (nodeI + i) + nodeJ + j);
                                visited[nodeI + i][nodeJ + j] = true;
                            }
                        }
                    }
                }
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);
            if (w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[h + 2][w + 2];
            for (int i = 1; i <= h; i++) {
                String[] part = br.readLine().split(" ");
                for (int j = 1; j <= w; j++) {
                    map[i][j] = Integer.parseInt(part[j - 1]);
                }
            }
            System.out.println(solution(w, h, map));
        }

        br.close();
    }
}
