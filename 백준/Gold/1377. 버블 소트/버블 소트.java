import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/*
[설명] https://www.acmicpc.net/problem/1377
- 버블 정렬의 swap이 한 번도 일어나지 않은 루프가 언제인지 인덱스 알아내기
[접근]
- 버블 정렬은 사용 불가 (10^5^2=10^10)
- 숫자가 뒤로 간단 건 한 턴에 갈 수도 있으므로 횟수와 관련 x
- 숫자가 앞으로 간단 건 한 턴에 한 번씩밖에 갈 수 없으므로 횟수와 관련 o
	- 그 턴에 swap이 일어났단 건 누군가는 무조건 앞으로 한 칸 가야 함
- 앞으로 이동한다는 건 명백한 게임 횟수를 의미함
- 앞으로 이동한 횟수는 swap이 일어난 게임 횟수이므로, 정답으론 앞으로 이동한 횟수에 1을 더한 값을 내면 됨
[메모]
- 매번 다른 애들이 앞으로 한 칸씩 이동할 수도 있는가? 놉 무조건 적어도 한 놈은 매번 이동함
- 왜 그러냐면, 루프에서 swap이 일어난단건 제자리를 찾아가야 하는 놈이 있단 뜻이고,
- 그 놈은 자기 자리가 자기보다 더 앞에 있어서 앞으로 매번 한 칸씩 가야 하기 때문임
- 참고로 자기 자리가 더 뒤에 있는 놈이 있다면, 자기 자리가 더 앞에 있는 놈은 무조건 존재함
- swap이 일어난단건 자기 자리가 더 뒤나 앞에 있는 놈들이 존재한단 뜻
[오답]
- 힌트 세 번이나 참고함
	- 메모리 초과는 bufferReader로 해결
	- 전/후 인덱스 비교
	- 인덱스 비교 시 +- 구분
*/
public class Main {
	private static int solution(int[] numbers, int n) {
		HashMap<Integer, Integer> before = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			before.put(numbers[i], i);
		}
		
		Arrays.sort(numbers);

		HashMap<Integer, Integer> after = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			after.put(numbers[i], i);
		}

		int maxSub = 0;
		for (int i = 1; i <= n; i++) {
			int number = numbers[i];
			int sub = before.get(number) - after.get(number);
			if (sub > maxSub) {
				maxSub = sub;
			}
		}
		return maxSub + 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] numbers = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(solution(numbers, n));

		br.close();
	}
}