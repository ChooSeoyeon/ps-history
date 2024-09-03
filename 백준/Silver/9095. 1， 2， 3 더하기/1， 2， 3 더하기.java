import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- given: 테스트 케이스의 개수 T, 각 테스트 케이스마다 정수 n(1~10) 주어짐
- return: n을 1,2,3의 합으로 나타내는 방법의 수
	- 합하는 숫자 같아도 순서 다르면 다른 방법으로 취급
[접근] DP
- 1~10까지 나타내는 방법 개수를 최초에 한 번 계산해서 배열에 저장해두고, 두고두고 사용하기
- D[i] = D[i-1] + D[i-2] + D[i-3]
[오답]
- 괜히 순서 고려 안한 경우의 수 다 구하고서 조합 계산하면 되겠다 생각해서 DFS+DP로 접근하다가
	- 영 이상해서 다른 사람 블로그 슬쩍 보고 매우 간단한 DP문제인거 깨달음 ㅠ
	- 케이스들도 다 써보고선 왜그랬대,,
	- 케이스 찾는데엔 도움되긴 했지만 음..
- 케이스를 찾지 말고 일부 케이스만으로 반복되는 규칙을 찾아보면 이런 실수 안하는 데에 도움 될듯함
	- 이 문제의 증명은 모르겠음
*/
public class Main {
	private static int[] solution(int[] numbers) {
		int[] memory = setMemory();
		int[] answers = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			answers[i] = memory[numbers[i]];
		}
		return answers;
	}
	
	private static int[] setMemory() {
		int[] memory = new int[11];
		memory[1] = 1;
		memory[2] = 2;
		memory[3] = 4;
		for (int i = 4; i < 11; i++) {
			memory[i] = memory[i - 1] + memory[i - 2] + memory[i - 3];
		}
		return memory;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		int[] answers = solution(numbers);
		for (int answer : answers) {
			System.out.println(answer);
		}

		br.close();
	}
}