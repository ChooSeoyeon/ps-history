import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 펜린드롬 : 숫자 순서 뒤집어도 원래와 똑같은 수
- N보다 크거나 같고, 소수이면서, 팬린드롬인 수 중, 가장 작은 수를 구하기
[접근]
- N보다 크거나 같은 펜린드롬인 수 찾아가며, 소수인지 확인하기?
- 펜린드롬인 수 확인 방법
	- 그냥 string 에 넣고 뒤집기..?
[메모]
- 소수 먼저 모두 구하고, 앞에서부터 팬린드롬인 수 찾기 (하나 찾으면 종료) <- 로 하면 안됨
*/
public class Main {
	private static int solution(int n) {
		int target;
		while (true) {
			target = n;

			if (isPalindrome(target)) {
				if (isPrime(target)) {
					break;
				}
			}

			n++;
		}

		return target;
	}

	private static boolean isPalindrome(int n) {
		StringBuilder st = new StringBuilder();
		String tmp = String.valueOf(n);
		st.append(tmp);
		st.reverse();
		return st.toString().equals(tmp);
	}

	private static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		System.out.println(solution(n));

		br.close();
	}
}