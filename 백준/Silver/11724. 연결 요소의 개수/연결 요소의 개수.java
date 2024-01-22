import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
[설명] Do it 알고리즘 코딩테스트 문제 023
[접근] DFS
*/
public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드 수
        int m = Integer.parseInt(st.nextToken()); // 엣지 수

        A = new ArrayList[n + 1];
        visited = new boolean[n + 1]; // 0번 인덱스는 사용 안함
        for (int i = 1; i < n + 1; i++) { // 노드 수 만큼 반복
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) { // 엣지 수 만큼 반복
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) { // 노드 수 만큼 반복
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    static void DFS(int v) {
        visited[v] = true;
        for (int i : A[v]) {
            if (!visited[i]) { // 탐색 안 한 노드 기준으로 dfs 실행
                DFS(i);
            }
        }
    }
}