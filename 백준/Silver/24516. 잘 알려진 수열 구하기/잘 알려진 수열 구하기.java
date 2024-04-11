import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 아래 두 조건에 맞는 길이가 N인 수열 아무거나 하나 구해서 출력해보기
	- 수열의 모든 원소는 서로 다르고, 수열의 원소는 1이상 100,000 이하의 정수임
	- 수열의 연속한 부분 수열 중에, 길이가 k인 모든 연속한 부분 수열의 합은 k로 나누어떨어짐
[접근]
- 길이가 2일 떄(4) -> 1+3(4), 3+5(8), 5+7(12), 7+9(16), 9+11(20), 11+13(24)
- 길이가 3일 때(6) -> 1+3+5(9), 3+5+7(15), 5+7+9(21), 7+9+11(27), 9+11+13(33)
- 길이가 4일 때(8) -> 1+3+5+7(16), 3+5+7+9(24), 5+7+9+11(32), 7+9+11+13(40)
- 길이가 5일 때(10) -> 1+3+5+7+9(25), 3+5+7+9+11(35), 5+7+9+11+13(45)
- 길이가 6일 때(12) -> 1+3+5+7+9+11(36), 3+5+7+9+11+13(48)
- 길이가 7일 때(14) -> 1+3+5+7+9+11+13(49)
[메모]
*/
public class Main {
    private static int[] solution(int n) {
        int[] numbers = new int[n];
        int k = 1;
        for (int i = 0; i < n; i++) {
            numbers[i] = k;
            k += 2;
        }
        return numbers;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = solution(n);
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }

        br.close();
    }
}
