import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

/*
[설명]
- 중복순열 (순서 다른거 인정함)
[접근]
- 백트래킹
*/
public class Main {
    public static int n, r;
    public static int[] ans = new int[9];
    public static boolean[] visited = new boolean[9]; // false로 초기화
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        backtracking(0);
        bw.flush();
    }

    public static void backtracking(int x) throws Exception {
        if(x==r) { // [종료 조건] r개 다 뽑았다면 출력하고 return
            for(int i=0; i<r; i++) {
                bw.write(Integer.toString(ans[i]) + " ");
            }
            bw.newLine();
            return;
        }

        for(int i=1; i<=n; i++) { // [반복문] n개의 수 (1부터 N까지 중)
            ans[x] = i; // [현재 단계에서 해야 하는 작업] 정답에 집어 넣기
            backtracking(x+1); // [다음 단계] 한 개의 수를 더 고름
        }
    }
}