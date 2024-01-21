import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
[설명]
- 오름차순 정렬하기
[접근] 병합정렬로 풀기
- 가장 작은 단위로 쪼개기
- 두 그룹씩 합하기
	- 두 정렬된 배열을 하나의 정렬된 배열로 합치기
[메모]
[오답]
- sout 썼다가 시간 초과 남. 개행 문자 따로 빼도 시간 초과 남
- bufferWriter 써도 시간 초과 남
- 배열을 로컬 변수로 각각 가지고 있다가 인자로 넘겨주는 방식에서, static 변수로 갖고 있게 바꿨더니 시간 초과 해결됨
*/
public class Main {
	private static int[] numbers = new int[1_000_001];
	private static int[] temp = new int[1_000_001];

	private static void solution(int n) {
		mergeSort(0, n);
	}

	private static void mergeSort(int start, int end) {
		if (end - start == 1) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(start, mid);
		mergeSort(mid, end);
		merge(start, end);
	}

	private static void merge(int start, int end) {
		int mid = (start + end) / 2;
		int left = start;
		int right = mid;
		for (int i = start; i < end; i++) {
			if (left == mid) {
				temp[i] = numbers[right++];
			} else if (right == end) {
				temp[i] = numbers[left++];
			} else if (numbers[left] <= numbers[right]) { // 합병 정렬의 stable sort 성질 만족시키기 위해서 크기 같을 땐 앞 쪽에 들어가게 해줌
				temp[i] = numbers[left++];
			} else {
				temp[i] = numbers[right++];
			}
		}
		for (int i = start; i < end; i++) {
			numbers[i] = temp[i];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		solution(n);

		for (int i = 0; i < n; i++) {
			bw.write(numbers[i] + "\n");
		}

		bw.flush();
		br.close();
	}
}