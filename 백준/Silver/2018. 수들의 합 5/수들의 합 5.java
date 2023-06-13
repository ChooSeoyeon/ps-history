import java.util.Scanner;

/*
[설명] Do it 알고리즘 코딩테스트 문제 006
- N을 연속된 자연수의 합으로 나타낼 수 있는 경우의 수 구하기
[접근]
- 투 포인터 (자연수 합의 시작, 끝을 포인터로 지정(인덱스를 저장하는 변수 사용함, 단 여기선 배열이 1부터 시작하는 자연수 집합이라 인덱스가 값 그 자체임)) -> O(n)
- 투 포인터 이동 원칙
    - if(sum > N) sum-=start; start++;
    - if(sum < N) end++; sum+=end;
    - if(sum == N) cnt++; end++; sum+=end;
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 주어진 N
        int start = 1; // 시작 포인터
        int end = 1; // 끝 포인터
        int cnt = 1; // 경우의 수 (N 자기 자신만 더한 경우는 먼저 카운트 해 초기값이 1임)
        int sum = 1; // 합 저장 (start, end가 모두 1인 경우 sum=1이라 초기값이 1임)

        // 투포인터 이동원칙 대로 포인터 이동시키며 경우의 수 모두 찾기
        while(end != N) { // end가 N이 될 때까지 반복
            if(sum > N) { // if(sum > N) sum-=start; start--;
                sum -= start;
                start++;
            }
            else if(sum < N) { // if(sum < N) end++; sum+=end;
                end++;
                sum += end;
            }
            else if(sum == N) { // if(sum == N) cnt++; end++; sum+=end;
                end++;
                sum += end;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}