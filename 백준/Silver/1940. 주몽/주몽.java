import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[설명] Do it 알고리즘 코딩테스트 문제 007
- 카드(재료) 중 두 개씩 뽑아 원하는 숫자 만들 수 있는 경우의 수 구하기
[접근]
- 투 포인터
*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int count = 0;
        int i = 0; // A[0] -> Min
        int j = N - 1; // A[N-1] -> Max

        while (i < j) { // 모든 재료 한 번씩 다 훑을 때까지
            if (A[i] + A[j] < M) {
                i++;
            } else if (A[i] + A[j] > M) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
        br.close();
    }
}
