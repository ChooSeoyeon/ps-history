import java.util.Arrays;

/*
[설명]
- 1~N번까지 번호 매겨져 있는 N명의 사람들 줄 서있음
- i번 사람이 돈 인출하는데 걸리는 시간은 Pi분
- 줄 서는 순서에 따라 돈 인출하는 데 필요한 시간 합 달라짐
	- p 나열한 게 3, 1, 4, 3, 2 라면, 실제론 3, 4, 8, 11, 13 만큼 시간 걸리고 총 시간은 39분 걸림
	- p 나열한 게 1, 2, 3, 3, 4 라면, 실제론 1, 3, 6, 9, 13 만큼 시간이 걸리고 총 32분이 걸림
- N과 P를 보고 각 사람이 돈을 인출하는 데 필요한 시간 합의 최소값 구하기
[접근] 일단 기본 정렬로 구현하고, 삽입 정렬로 구현해보기
- 정렬하고 그 값 누적해서 더하기
[메모]
*/
public class Main {
	private static int solution(int n, int[] numbers) {
		Arrays.sort(numbers);
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += numbers[i] * (n - i);
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		java.util.Scanner sc = new java.util.Scanner(System.in);

		int n = sc.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}

		System.out.println(solution(n, numbers));

		sc.close();
	}
}