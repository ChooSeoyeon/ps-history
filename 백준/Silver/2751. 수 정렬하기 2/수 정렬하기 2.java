import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
[설명]
- 오름차순 정렬하기
[접근] 병합정렬로 풀기
- 가장 작은 단위로 쪼개기
- 두 그룹씩 합하기
	- 두 정렬된 배열을 하나의 정렬된 배열로 합치기
[메모]
[오답]
*/
public class Main {
	private static void solution(int n, int[] numbers) {
		Arrays.sort(numbers);
	}
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		solution(n, numbers);

		for (int number : numbers) {
			bw.write(number + "\n");
		}

		bw.flush();
		br.close();
	}
}