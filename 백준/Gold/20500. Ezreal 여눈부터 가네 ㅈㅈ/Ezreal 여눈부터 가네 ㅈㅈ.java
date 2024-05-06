import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 0으로 시작하지 않고 1과 5로만 구성된 N자리 양의 정수 중 15의 배수가 몇 개인지 구하기
- 문제의 답을 1_000_000_007로 나눈 나머지 출력하기
[접근] 동적계획법
- 각자리합이 3의 배수면서, 일의 자리가 5인 수
    - 한자리씩 1이나 5를 더해가면서 3의 배수인지 확인하기
    -      15         55
    -   115   515  155   555
    - 를 3으로 나눴을 때 나머지 개수로 바라본다면
    -      0          1
    -    1    2    2     0
    -   2 0  0 1  0 1   1 2
    - 규칙: 0 -> 1, 2 / 1 -> 2, 0 / 2 -> 0, 1
    - 자릿수별로 나머지가 0, 1, 2인 값의 개수 저장해서 다음 자릿수의 나머지가 0, 1, 2인 값의 개수 구하기
    - 최종적으론 N자리수 수의 나머지가 0인 값을 출력하면 됨
[메모]
*/
public class Main {
    private static final long MOD = 1_000_000_007;

    private static long solution(int n) {
        long[][] memory = new long[n + 1][3];

        if (n >= 2) {
            memory[2][0] = 1;
            memory[2][1] = 1;
            memory[2][2] = 0;
        }
        for (int i = 3; i <= n; i++) {
            memory[i][0] = (memory[i - 1][1] + memory[i - 1][2]) % MOD;
            memory[i][1] = (memory[i - 1][0] + memory[i - 1][2]) % MOD;
            memory[i][2] = (memory[i - 1][0] + memory[i - 1][1]) % MOD;
        }

        return memory[n][0] % MOD;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));

        br.close();
    }
}
