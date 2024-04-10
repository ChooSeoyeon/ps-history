import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 수열 a1,a2,.. an에 대해 아래 조건 만족하는 수열 b1, b2, ... bn을 좋은 수열이라 함
    - b1, b2, ... bn은 모두 양의 정수
    - bi != ai
    - b1 < b2 < ... < bn
- 좋은 수열 b1, b2, ... bn에 대하여 bn의 최솟값 구하기
[접근]
- a = [0, 1, 3, 2, 6, 7]
- b = [0, 2, 4, 5, 7, 8]
- b1 = b0보다 크고 a1과 같지 않은 수 = b0보다 1 큰 수, 그게 a1이랑 같다면 b0보다 2 큰 수 = 1 대신 2
- b2 = b1보다 크고 a2와 같지 않은 수 = b1보다 1 큰 수, 그게 a2랑 같다면 b1보다 2 큰 수 = 3 대신 4
- b3 = b2보다 크고 a3와 같지 않은 수 = b2보다 1 큰 수, 그게 a3과 같다면 b2보다 2 큰 수 = 5
- b4 = b3보다 크고 a4와 같지 않은 수 = b3보다 1 큰 수, 그게 a4와 같다면 b3보다 2 큰 수 = 6 대신 7
- b5 = b4보다 크고 a5와 같지 않은 수 = b4보다 1 큰 수, 그게 a5와 같다면 b4보다 2 큰 수 = 8
*/
public class Main {
    private static int solution(int[] a, int n) {
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int previous = b[i - 1];
            if (previous + 1 == a[i]) {
                b[i] = previous + 2;
            } else {
                b[i] = previous + 1;
            }
        }
        return b[n];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n + 1];
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                a[j] = Integer.parseInt(input[j - 1]);
            }
            System.out.println(solution(a, n));
        }

        br.close();
    }
}
