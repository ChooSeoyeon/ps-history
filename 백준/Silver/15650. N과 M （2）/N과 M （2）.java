import java.util.*;

/*
[설명]
- 조합 (순서 다른거 인정 안함) nCr
[접근]
- 백트래킹
*/
public class Main {
    public static int n, r;
    public static int[] arr = new int[9];
    public static boolean[] visited = new boolean[9]; // false로 초기화

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        backtracking(0);
    }

    public static void backtracking(int x) {
        if(x==r) { // [종료 조건] r개 다 뽑았다면 출력하고 return
            for(int i=0; i<r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=n; i++) { // [반복문] n개의 수 (1부터 N까지 중)
            if( !visited[i] && ( (x==0) || (arr[x-1]<i) ) ) { // [제한조건] 사용한 적 없으면서 전 거보다 큼(오름차순)
                visited[i] = true; // [상태 변화] 사용한 수는 표시
                arr[x] = i; // [현재 단계에서 해야 하는 작업] 정답에 집어 넣기
                backtracking(x+1); // [다음 단계] 한 개의 수를 더 고름
                visited[i] = false; // [원상 복구] 사용했다고 표시한 거 복구
            }
        }
    }
}