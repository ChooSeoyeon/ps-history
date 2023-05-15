import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
[설명] Do it 알고리즘 코딩테스트 문제 004
- N*N짜리 2차원 배열 A에서 (x1)(y1)~(x2)(y2)까지 합 구하기(질의 여러 번)
[접근] 03-1 구간 합
- 2차원 합 배열 만들어 구간합 이용하기
- 합 배열 만들기 : S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + A[i][j]
- 구간합 구하기 : A[x1][y1]~A[x2][y2] 합 = S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1]
*/
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine()); // M N
        int N = Integer.parseInt(st.nextToken()); // 배열 행, 열 길이
        int M = Integer.parseInt(st.nextToken()); // 질의 개수
        int[][] S = new int[N+1][N+1]; // 합 배열. 원래 배열은 따로 저장할 필요 없어서 안만듦.

        // 합 배열 만들기
        for(int i=1; i<=N; i++) { // S[0]은 0으로 초기화 되어 있어서 문제 없음
            st = new StringTokenizer(bf.readLine()); // 대상 배열 a의 한 행씩 읽음
            for(int j=1; j<=N; j++) {
                S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        // 구간합 구하기
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine()); // 질의
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1]);
        }
    }
}