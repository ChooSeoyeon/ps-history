import java.util.Scanner;

/*
[설명] Do it 알고리즘 코딩테스트 문제 005
- 주어진 배열 A[N]에서 연속된 부분의 합이 주어진 수 M으로 나누어떨어지는 구간의 개수 구하기
    - ex. (A[1]+A[2]+A[3]) % 2 == 0, (A[2]+A[3]+A[4]+A[5]) % 2 ==0 -> 2개
[접근]
- 구간 합 (합 배열 만들어 구간 합 구하기)
- 나눠서 구한 나머지를 합한 것 == 합하고 나눠서 구한 나머지
    - ex. (2+3)%2 == (2%2)+(3%2)
            1 == 0 + 1
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 배열 크기 -> A[N]
        int M = sc.nextInt(); // 나누는 수 -> %M
        long[] S = new long[N]; // 합 배열 (ex. S[0]=A[0], S[1]=A[0]+A[1], S[2]=A[0]+A[1]+A[2])
        long[] C = new long[M]; // 같은 나머지의 인덱스 카운트 (ex. M=3 -> 나머지가 0,1,2인 것들 개수를 각각 C[0], C[1], C[2]에 저장함)
        long answer = 0; // 정답(구간의 개수)

        // 합 배열 구하기
        S[0]=sc.nextInt(); // S[0]=A[0]
        for(int i=1; i<N; i++) { // A[1]~A[N]
            S[i] = S[i-1] + sc.nextInt(); // S[N]=S[N-1]+A[N]
        }

        // [나눠서 구한 나머지를 합한 것 == 합하고 나눠서 구한 나머지]라는 사실 이용해서 부분 합의 나머지로 정답 체크
        for(int i=0; i<N; i++) {
            int temp = (int) (S[i] % M); // 합 배열을 M으로 나눈 나머지 값
            if(temp == 0) answer++; // 나머지가 0이라면 A[0]~A[i] 구간이 M으로 나누어떨어지는 것이므로 정답 카운트
            C[temp]++; // 같은 나머지의 인덱스 카운트
        }

        /*
        나머지 같은 것 중 2개 뽑는 이유 : S[3]%M=1, S[1]%M=1 이라면
        A[0]+A[1]+A[2]+A[3]과 A[0]+A[1] 그 자체는 나머지가 0이 될 수 없지만,
        S[3]-S[1]=0으로 A[2]+A[3]은 나머지가 0이 될 수 있다
         */
        // 나머지 같은 것 중 2개 뽑는 경우의 수를 정답에 더하기
        for(int i=0; i<M; i++) {
            if(C[i]>1) { // C[i]가 0이면 나머지가 i인 수가 없는 것. 1이면 나머지가 i인 수가 한 개인 것
                answer += (C[i] * (C[i]-1) / 2); // nC2 = n*(n-1) / 2
            }
        }
        System.out.println(answer);
    }
}