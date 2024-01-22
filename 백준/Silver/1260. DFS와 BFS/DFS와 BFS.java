import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
[설명] Do it 알고리즘 코딩테스트 문제 026
[접근] DFS와 BFS
*/
public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 노드 수
        int M = sc.nextInt(); // 엣지 수
        int start = sc.nextInt(); // 시작 노드

        // 그래프 표현
        A = new ArrayList[N + 1]; // 0번 인덱스는 사용 안함
        for (int i = 1; i < N + 1; i++) { // 노드 수 만큼 반복
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) { // 엣지 수 만큼 반복
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        // 번호 작은 것 먼저 방문하기 위해 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        // DFS
        visited = new boolean[N + 1];
        DFS(start);
        System.out.println();

        // BFS
        visited = new boolean[N + 1];
        BFS(start);
        System.out.println();
    }

    static void DFS(int Node) {
        System.out.print(Node + " ");
        visited[Node] = true;
        for (int i : A[Node]) {
            if (!visited[i]) { // 탐색 안 한 노드 기준으로 dfs 실행
                DFS(i);
            }
        }
    }

    static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node); // 큐에 시작 노드를 넣음
        visited[Node] = true; // 큐에 들어가는 순간 방문 처리

        while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
            int nowNode = queue.poll(); // 큐에서 하나 꺼냄
            System.out.print(nowNode + " ");
            for (int i : A[nowNode]) {
                if (!visited[i]) { // 갈 수 있는 애들을 큐에 넣어줌
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
