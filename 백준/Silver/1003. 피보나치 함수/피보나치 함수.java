import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 아래 코드에서 fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하기
    int fibonacci(int n) {
        if (n == 0) { // fibonacci(0)
            printf("0");
            return 0;
        } else if (n == 1) { // fibonacci(1)
            printf("1");
            return 1;
        } else {
            return fibonacci(n‐1) + fibonacci(n‐2);
        }
    }
[접근] DP
- 점화식: D[i] = D[i-1] + D[i-2]
- 바텀-업 방식: 가장 작은 부분 문제부터 문제 해결하면서 점점 큰 문제로 확장해나가는 방식
[메모]
- fibonacci(3) 호출
    -> fibonacci(2) + fibonacci(1)
    -> fibonacci(1) + fibonacci(0) + fibonacci(1)
*/
public class Main {
    static long[] memoryZero;
    static long[] memoryOne;

    private static long[][] solution(int n, int[] numbers) {
        memoryZero = new long[41];
        memoryOne = new long[41];
        memoryZero[0] = 1;
        memoryOne[0] = 0;
        memoryZero[1] = 0;
        memoryOne[1] = 1;

        for (int i = 2; i <= 40; i++) {
            memoryZero[i] = memoryZero[i - 1] + memoryZero[i - 2];
            memoryOne[i] = memoryOne[i - 1] + memoryOne[i - 2];
        }

        long[][] answers = new long[n][2];
        for (int i = 0; i < n; i++) {
            answers[i][0] = memoryZero[numbers[i]];
            answers[i][1] = memoryOne[numbers[i]];
        }
        return answers;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        long[][] answers = solution(n, numbers);
        for (long[] answer : answers) {
            System.out.println(answer[0] + " " + answer[1]);
        }

        br.close();
    }
}
