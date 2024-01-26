import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 모든 자리가 1로만 이루어진 두 자연수 a, b의 최대공약수 구하기
[접근]
- 유클리드 호제법
- 111 % 111 = 0 -> 3 % 3 = 0
- 1111 % 111 = 1 -> 4 % 3 = 1
- 11111 % 111 = 11 -> 5 % 3 = 2
- 111111 % 111 = 0 -> 6 % 3 = 0
- 1111111 % 111 = 1 -> 7 % 3 = 1
- 11_111_111 % 111 = 11 -> 8 % 3= 2
[오답]
- 문제 안읽고 풀었다가 모든 자리 1로 이루어진거 읽지도 않고 풀려했음
- 문제 안읽고 풀었으니 당연히 안풀렸고 순간 타입 문제인지 알고 예전에 내가 푼 풀이 봐버렸는데 그때서야 문제 잘못 읽은 거 깨달음
*/
public class Main {
	private static String solution(long n, long m) {
		long number = gcd(n, m);
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < number; i++) {
			stringBuilder.append("1");
		}
		return stringBuilder.toString();
	}

	private static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		long n = Long.parseLong(input[0]);
		long m = Long.parseLong(input[1]);
		System.out.println(solution(n, m));

		br.close();
	}
}