import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
[설명] Do it 알고리즘 코딩테스트 문제 003
- 배열에 대해 a번째 수부터 b번째 수까지의 합을 구하기
[접근] 03-1 구간 합
- 합 배열 만들어 구간합 이용하기
*/
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine()); // M N
        int N = Integer.parseInt(st.nextToken()); // 데이터 개수
        int M = Integer.parseInt(st.nextToken()); // 질의 개수
        int[] S = new int[N+1]; // 합 배열. 원래 배열은 따로 저장할 필요 없어서 안만듦.

        st = new StringTokenizer(bf.readLine()); // 대상 배열
        for(int i=1; i<=N; i++) { // S[0]은 0으로 초기화 되어 있어서 문제 없음
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine()); // 질의
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(S[b]-S[a-1]);
        }
    }
}