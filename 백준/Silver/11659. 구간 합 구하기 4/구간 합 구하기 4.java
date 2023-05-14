import java.util.*;

/*
[설명] Do it 알고리즘 코딩테스트 문제 003
- 배열에 대해 a번째 수부터 b번째 수까지의 합을 구하기
[접근] 03-1 구간 합
- 합 배열 만들어 구간합 이용하기
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 데이터 개수
        int M = sc.nextInt(); // 질의 개수
        int[] A = new int[N]; // 배열
        int[] S = new int[N]; // 합 배열
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        S[0]=A[0];
        for(int i=1; i<N; i++) {
            S[i] = S[i-1] + A[i];
        }
        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a<2) System.out.println(S[b-1]); // a가 1인 경우
            else System.out.println(S[b-1]-S[a-2]);
        }
    }
}