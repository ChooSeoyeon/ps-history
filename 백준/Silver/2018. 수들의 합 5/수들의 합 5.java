import java.util.Scanner;

/*
[설명] https://www.acmicpc.net/problem/2018
- N을 몇 개의 연속된 자연수의 합으로 나타낼 수 있는 가지수 구하기
[접근] 구간합 + 투포인터
- i=1,j=1,sum=i인 상태에서 j를 증가시키며 sum에 더함 sum+=(++j)
	- 1, 1+2, 1+2+3, 1+2+3+4, 1+2+3+4+5(15)
- sum==정답 -> i와 j 모두 증가시킴
	- 2+3+4+5+6
	- 5+6+7
	- 8+9
	- 16
- sum>정답 -> i를 증가시켜 sum에서 뺌 (j를 감소시켜 sum에서 빼지 않는 이유 : 아까 이미 본 상태이므로)
	- 3+4+5+6, 4+5+6(15)
	- 6+7
	- 7+8(15)
	- 9
	- 10
	- 11
	- 14
	- 15(15)
- sum<정답 -> j를 증가시키며 sum에 더함 (i를 감소시켜 sum에 더하지 않는 이유 : 아까 이미 본 상태이므로)
	- 6+7+8
	- 9+10
	- 10+11
	- 13+14
	- 14+15
	- 15+16(종료)
- 종료조건 : j가 n보다 커질 때 (혹은 i가 j보다 커질 때==범위 내 값이 1개 인데, 합이 15보다 큼)
- 연산 예시
	- i 증가시켜 이전값 sum에서 뺌 : sum -= (i++);
	- j 증가시켜 새로운값 sum에 더함 : sum += (++j);
*/

public class Main {
	private static int solution(int n) {
		int answer = 0;
		int i = 1;
		int j = 1;
		int sum = i;
		while (j <= n) {
			if (sum == n) {
				sum -= (i++);
				sum += (++j);
				answer++;
			} else if (sum > n) {
				sum -= (i++);
			} else {
				sum += (++j);
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solution(n));

		sc.close();
	}
}