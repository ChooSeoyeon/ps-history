import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- given: 정수 N (10^6)
- return: 연산 세 개 적절히 사용해서 N을 1로 만들려 할 때, 연산을 하는 횟수의 최솟값
    - X가 3으로 나누어 떨어지면, 3으로 나눔
    - X가 2로 나누어 떨어지면, 2로 나눔
    - 1을 뺌
[접근] dp 혹은 dfs
- a[n] = min(a[n/2], a[n/3], a[n-1]) + 1 (계산한 인덱스 값은 정수여야만 함)
    - a[1] = 0, a[2] = 1, a[3] = 1
    - 아래부터 계산
        - a[4] = min(a[2], a[3]) + 1 = 2
        - a[5] = min(a[4]) + 1 = 3
        - a[6] = min(a[3], a[2], a[5]) + 1 = 2
        - a[7] = min(a[6]) + 1 = 3
        - a[8] = min(a[4], a[7]) + 1 = 3
        - a[9] = min(a[3], a[8]) + 1 = 2
        - a[10] = min(a[5], a[9]) + 1 = 3
[메모]
- dfs 되는 이유
    - 최대 10^6번 깊이(-1연산)
    - 최대 3^12~2^18 너비 (10^6 = 약 2^18 -> 3갈래씩 계속 곱해진다해도 2연산이 최대 18번임)
    - 2600만
- 그리디 안되는 이유
    - 반례 10 존재
        - 10/2 = 5      - 10-1 = 9
        - 5-1 = 4       - 9/3 = 3
        - 4/2 = 2       - 3/3 = 1
        - 2/2 = 1
*/
public class Main {

    private static int[] memory;

    private static int solution(int n) {
        memory = new int[n + 3]; // n+1 해도 되지만, n=1,2일때도 동일하게 처리하기 위해 n+3으로 잡음
        memory[1] = 0;
        memory[2] = 1;
        memory[3] = 1;
        for (int i = 4; i <= n; i++) {
            memory[i] = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                memory[i] = Math.min(memory[i], memory[i / 2] + 1);
            }
            if (i % 3 == 0) {
                memory[i] = Math.min(memory[i], memory[i / 3] + 1);
            }
            memory[i] = Math.min(memory[i], memory[i - 1] + 1);
        }

        return memory[n];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));

        br.close();
    }
}