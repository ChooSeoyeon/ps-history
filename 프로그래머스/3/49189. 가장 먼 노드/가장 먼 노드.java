/*
[설명]
- given: 노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex
    - 간선은 양방향
    - vertex[a, b] 는 a번 노드와 b번 노드 사이에 간선이 있다는 의미
- return: n개의 노드가 있는 그래프의 1번 노드에서 가장 멀리 떨어진 노드의 갯수
    - 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들
[접근] 인접 리스트 그래프 + BFS
*/
import java.util.*;

class Solution {
    private static final int START = 1;
    private static final int INFINITE = 99_999_999;
    private static final int WEIGHT = 1;
    
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
    
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(START);
        
        long[] distance = new long[n + 1];
        Arrays.fill(distance, INFINITE);
        distance[START] = 0;
        
        while(!queue.isEmpty()) {
            int select = queue.poll();
            for (int near : graph[select]) {
                if (distance[near] == INFINITE) {
                    distance[near] = distance[select] + WEIGHT;
                    queue.offer(near);
                }
            }
        }
        
        int count = 0;
        long max = 0;
        for (int i = 1; i < distance.length; i++) {
            if (max < distance[i]) {
                max = distance[i];
                count = 1;
            } else if (max == distance[i]) {
                count++;
            }
        }
        return count;
    }
}