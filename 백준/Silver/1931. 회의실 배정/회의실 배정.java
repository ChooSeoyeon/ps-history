import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
[설명]
- 시작 시간과 끝나는 시간이 각가 정해진 N개의 회의를 겹치지 않게 하면서 회의실 사용할 수 있는 회의의 최대 개수 찾기
[접근] 그리디
- 최선의 선택
	- 겹치는 구간에서 누가 택해졌는지가 핵심
	- 제일 빨리 끝나는 애 택하기 (시간 빨리 끝나는 애 순으로 정렬된 채로 시작하기)]
- 그리디
	- 해 선택 : 시간이 빨리 끝나는 애부터 강의를 넣기
	- 적절성 검사 : 앞 선 강의와 시간 겹치는지 보기 (앞 선 강의의 끝나는 시간만 보면 됨)
	- 해 검사 : 가장 마지막 강의까지 배정을 시도했다면 전부 넣은 것으로 최대한 강의를 많이 배정한 것이니 종료
[메모]
- comparator 원리 (오름차순 정렬 기준)(오른쪽이 커야 함)
	a - b 가 음수이면 오른쪽이 크다고 인식해 위치 안 바꿈
	a - b 가 양수이면 왼쪽이 크다고 인식해 a의 값과 b의 값이 서로 교환함
	a - b 가 0이라면 크기가 서로 같다고 인식해 위치 안 바꿈 <- TODO: 이 줄 맞는지 확인 필요
[오답]
- 이차원 배열 커스텀 정렬하는 법 모르겠어서 람다식은 다른 코드 참고함
- 참고하다가 의도치 않게 본 블로그가 이 문제 답을 커스텀 배열 예시 코드로 달아놔서 후다닥 꺼서 뒷부분 코드를 보진 않았지만, 코드가 짧다는 걸 알아버림
- 원래 겹치는 구간 등장할 때마다 카운트 세고, 다른 겹치는 강의들 제거하는 식으로 엄청 복잡하게 구현하려했었음
- 다시 간단히 생각해보니 위의 복잡한 과정은 앞에서부터 겹치지 않는 강의 넣어서 카운트 세는 것과 동일한 결과를 내기에 간단하게 풀이 바꿔서 풀어냄
- 왜 이게 가능하냐면, 어차피 시간 빨리 끝나는 애부터 넣는 게 최선의 선택이라 시간 빨리 끝나는 애들 순으로 정렬되었다면, 
- 앞에서부터 일단 겹치지만 않으면 넣어주면 그게 곧 최선의 선택인 거기 때문임
- 왜, 시간 빨리 끝나는 애들부터 넣는게 최선의 선택이냐면, 
	- 강의 시간이 짧은 건 걔네끼리 겹칠 수 있어서 강의를 최대로 넣을 수 있느냐에 대해 불분명한 반면에(의미가 없는 반면에)
	- 끝나는 시간이 빠른건 확실하게 뒤에 다른 강의가 들어올 공간을 최대로 창출해낸단 의미이기 때문임
*/
public class Main {
	private static int[][] numbers;

	private static int solution(int n) {
		Arrays.sort(numbers, (o1, o2) -> {
			if (o1[1] == o2[1]) { // 끝 시간 같을 땐 시작 시간 기준으로 정렬 (시작 시간 기준은 없거나 내림차순이어도 상관 없긴 함)
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1]; // 끝시간 기준으로 오름차순 정렬
		});

		int count = 0;
		int lastEndTime = 0;
		for (int i = 0; i < n; i++) {
			if (lastEndTime <= numbers[i][0]) {
				count++;
				lastEndTime = numbers[i][1];
			}
		}

		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		numbers = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			numbers[i][0] = Integer.parseInt(input[0]);
			numbers[i][1] = Integer.parseInt(input[1]);
		}

		System.out.println(solution(n));

		br.close();
	}
}