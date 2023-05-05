import java.util.*;

public class Main {
    static boolean visited[];
    static ArrayList<Integer>[] A;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // 노드 개수
        int M = scan.nextInt(); // 에지 개수
        int Start = scan.nextInt(); // 시작점

        // 1. 인접 리스트로 그래프 표현하기
        A = new ArrayList[N+1];
        for(int i=1; i<=N; i++) { // 노드 초기화
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++) { // 엣지의 양끝 노드 입력받기
            int S = scan.nextInt();
            int E = scan.nextInt();
            A[S].add(E);
            A[E].add(S); // 양방향이라서 양쪽 노드에 엣지 추가
        }

        for(int i=1; i<=N; i++) { // 번호 작은 것 먼저 방문하기 위해 각 노드의 엣지들 정렬
            Collections.sort(A[i]);
        }

        // DFS
        // 2. 방문 배열 초기화하기
        visited = new boolean[N+1];
        // 3. 시작 노드 스택에 삽입하기(여기선 스택 대신 재귀함수 사용)
        DFS(Start);
        System.out.println();

        // BFS
        // 2. 방문 배열 초기화하기
        visited = new boolean[N+1];
        // 3. 시작 노드 큐에 삽입하기
        BFS(Start);
        System.out.println();
    }

    public static void DFS(int Node) {
        System.out.print(Node + " "); // 현재 노드 출력하기
        visited[Node] = true; // 현재 노드 방문 기록하기
        // 인접한 미방문 노드로 DFS 실행하기
        for(int i: A[Node]) { // 현재 노드의 엣지들
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node); // 시작 노드 큐에 삽입하기
        visited[Node] = true; // 시작 노드 방문 기록하기
        // 인접한 미방문 노드로 BFS 실행하기
        while(!queue.isEmpty()) {
            // 큐에서 현재 노드 가져와서 출력하기
            int new_Node = queue.poll();
            System.out.print(new_Node + " ");
            for(int i: A[new_Node]) { // 현재 노드의 엣지들
                if(!visited[i]) {
                    queue.add(i); // 인접한 미방문 노드 큐에 삽입하기
                    visited[i] = true; // 인접한 미방문 노드 방문 기록하기
                }
            }
        }
    }
}