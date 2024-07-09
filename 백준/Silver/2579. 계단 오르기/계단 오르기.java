import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 계단 오르기 게임: 맨 아래부터 맨 위까지 가는 게임, 계단을 밟으면 그 계단에 쓰인 점수 얻게 됨
	- 계단은 한 번에 한 계단 혹은 두 계단씩 오를 수 있음
	- 연속된 세 개 계단 모두 밟을 수 없음(단 시작점은 계단에 포함 x)
	- 마지막 도착 계단은 무조건 밟아야 함
- 각 계단에 쓰인 점수가 주어질 때 게임에서 얻을 수 있는 총 점수의 최댓값 구하기
[접근] DP
- 연속: 전거 비연속 + 자기
    - a(1) = x(1)
    - a(n) = a(n-1)  + x(n)
- 비연속: 전전거 큰거 + 자기
    - b(1) = x(1), b(2) = x(2)
    - b(n) = max(a(n-2),b(n-2)) + x(n)
[오답]
- 계단의 개수가 300이하 자연수라서, 1개일 떄도 있는데 이때를 고려안해서 ArrayIndexOutOfBounds 뜸
*/
public class Main {
    private static int solution(int[] steps) {
        if (steps.length == 2) {
            return steps[1];
        }
        
        int l = steps.length;
        int[] a = new int[l];
        int[] b = new int[l];

        a[1] = steps[1];
        b[1] = steps[1];
        b[2] = steps[2];
        for (int i = 2; i < l; i++) {
            a[i] = b[i - 1] + steps[i];
            if (i == 2) {
                continue;
            }
            b[i] = Math.max(a[i - 2], b[i - 2]) + steps[i];
        }

        return Math.max(a[l - 1], b[l - 1]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] steps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(steps));

        br.close();
    }
}
