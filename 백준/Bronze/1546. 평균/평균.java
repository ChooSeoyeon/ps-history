import java.util.*;

/*
[설명]
- 조작한 시험 점수들의 평균 구하기
- 조작된 점수는 원래점수/최고점수*100임
[접근] 03-1 배열과 리스트
- 원래 평균 = (a+b+c)/n
- 조작한 평균 = (a+b+c)/최고점수*100/n
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        long max=0, sum=0; // int도 괜찮지만, 큰 수 들어갈 수도 있으니 왠만하면 long으로 선언하기
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
            sum+=A[i];
            if(max<A[i]) max=A[i];
        }

        System.out.println(sum*100.0/max/N); // 100.0은 (double)과 같은 효과
    }
}