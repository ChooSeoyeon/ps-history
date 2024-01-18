import java.util.Arrays;
import java.util.Collections;

/*
[설명]
- 100억 이하의 수의 각 자리수를 내림차순으로 정렬하기
[접근]
- long으로 받아도 되지만, scanner 써서 편하게 받기 위해 string으로 받음
[메모]
*/
public class Main {
	private static String solution(String n) {
		Integer[] numbers = new Integer[n.length()];
		for (int i = 0; i < n.length(); i++) {
			numbers[i] = (int)n.charAt(i) - '0';
		}
		Arrays.sort(numbers, Collections.reverseOrder());

		StringBuilder stringBuilder = new StringBuilder();
		for (Integer number : numbers) {
			stringBuilder.append(number);
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) throws Exception {
		java.util.Scanner sc = new java.util.Scanner(System.in);

		String n = sc.next();
		System.out.println(solution(n));

		sc.close();
	}
}