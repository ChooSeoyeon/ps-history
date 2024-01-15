import java.util.Scanner;

/*
[설명]
- A, C, G, T 로 이루어진 문자열에서 부분 문자열로 비밀번호 만들기
	- 비밀번호는 A, C, G, T 각각이 등장하는 개수가 특정 개수 이상이어야 함
[접근] 슬라이딩윈도우
- 4개짜리 윈도우를 옆으로 슬라이드하며 비밀번호 유효성 성립하는지 확인
- 비밀번호 유효성 검사
	- A, C, G, T 개수 업데이트
[메모]
- 개수를 매번 새로 센다면 똑같은 대상에 대한 카운트 반복해야 함
	(S*(P-S)) -> O(N^2)
- 개수를 새로 들어오는 요소에 대해서만 세어 업데이트한다면, 똑같은 대상에 대한 카운트 반복하지 않아도 됨
	S+(P-S) -> O(N)
*/

public class Main {
	private static int solution(String dnaArr, int p, int[] condition) {
		int answer = 0;
		int[] target = new int[4];
		for (int i = 0; i < p; i++) {
			int index = findDnaIndex(dnaArr.charAt(i));
			target[index]++;
		}
		if (isConditionMatch(condition, target)) {
			answer++;
		}
		for (int i = p; i < dnaArr.length(); i++) {
			int subIndex = findDnaIndex(dnaArr.charAt(i - p));
			int addIndex = findDnaIndex(dnaArr.charAt(i));
			target[subIndex]--;
			target[addIndex]++;
			if (isConditionMatch(condition, target)) {
				answer++;
			}
		}

		return answer;
	}

	private static int findDnaIndex(char dna) {
		if (dna == 'A') {
			return 0;
		} else if (dna == 'C') {
			return 1;
		} else if (dna == 'G') {
			return 2;
		} else {
			return 3;
		}
	}

	private static boolean isConditionMatch(int[] condition, int[] target) {
		boolean answer = true;
		for (int i = 0; i < 4; i++) {
			answer &= (condition[i] <= target[i]);
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();
		int p = sc.nextInt();
		String dnaArr = sc.next();
		int[] condition = new int[4];
		for (int i = 0; i < 4; i++) {
			condition[i] = sc.nextInt();
		}

		System.out.println(solution(dnaArr, p, condition));

		sc.close();
	}
}
