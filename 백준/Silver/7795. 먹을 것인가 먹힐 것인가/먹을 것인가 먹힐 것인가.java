import java.util.Arrays;
import java.util.Scanner;

/*
[설명] https://www.acmicpc.net/problem/7795
- 자기보다 큰 먹이만 먹을 수 있는데, a가 b를 먹을 수 있는 경우의 수 구하기
- a가 1,1,3,7,8 이고, b가 1,3,6 인 경우
    - 1 -> 1,3,6 중에 3보다 작은 애 몇 개인지 찾아야 함 -> 없음
    - 3 -> 1,3,6 중에 3보다 작은 애 몇 개인지 찾아야 함 -> 1 하나 뿐
    - 4였다면 -> 1,3,6 중에 3보다 작은 애 몇 개인지 찾아야 함 -> 1, 3
    - 7 -> 1,3,6 중에 3보다 작은 애 몇 개인지 찾아야 함 -> 3, 6
    - 8 -> 1,3,6 중에 3보다 작은 애 몇 개인지 찾아야 함 -> 1, 3, 6
[접근] 이분 탐색
- 자기보다 작은 애가 최초로 나오는 지점 찾기 -> 그 녀석의 인덱스 + 1 을 개수에 더하기
- 4 -> 1,3,6 중에 4보다 작은 애 몇 개인지 찾아야 함 -> 1,3 찾는 경우
    - 3 < 4 -> 6을 보기
    - 6 > 4 -> 어라, 찾았다. 3이 정답이야
*/
public class Main {
	private static int solution(int[] a, int[] b) {
		int count = 0;
		Arrays.sort(a);
		Arrays.sort(b);
		for (int target : a) {
			count += search(target, b);
		}
		return count;
	}

	private static int search(int target, int[] b) {
		int left = 0;
		int right = b.length - 1;
		int count = 0;

		while (true) {
			int middle = (left + right) / 2;
			if (target > b[middle]) {
				count = middle + 1;
				left = middle + 1;
			} else {
				right = middle - 1;
			}
            
			if (left > right) {
				return count;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

			int[] b = new int[m];
			for (int i = 0; i < m; i++) {
				b[i] = sc.nextInt();
			}

			System.out.println(solution(a, b));
		}

		sc.close();
	}
}