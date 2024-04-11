import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 기숙사의 각 방에 진단 키트 제공했는데, 방마다 받은 키트의 수가 다름
- 모든 방이 같은 수의 키트 가지도록 방끼리 키트 주고받음
- 키트는 바로 옆방에만 넘겨줄 수 있고, 바로 옆방으로 키트 한 개를 건네줄 때 혼잡도가 1 증가함
- 최대한 가까운 방끼리 키트 주고받을 때, 혼잡도가 최소임. 혼잡도의 최솟값 구하기
[접근]
- 앞에서부터 순서대로 보기
    - 예시: 2 6 3 2 5 4 6 -> 기준값: 28/7 = 4
    - [0] 은 [1] 로부터 2개 받는다 -> 4 4 3 2 5 4 6 -> 2
    - [2] 은 [4] 로부터 1개 받는다 -> 4 4 4 2 4 4 6 -> 2
    - [3] 은 [6] 로부터 2개 받는다 -> 4 4 4 4 4 4 4 -> 6
[메모]
[오답]
- 처음에 사용했던 방식
    - 넘치는 애들과 부족한 애들을 각자의 인덱스로 넘치거나 부족한 값만큼 반복해 더하기
        - 예시: [0]2 [1]6 [2]3 [3]2 [4]5 [5]4 [6]6 -> 기준값: 28/7 = 4
        - 넘치는 애들: 1+1+4+6+6 = 18
        - 부족한 애들: 0+0+2+3+3 = 8
        - 계산: (1-0)+(1-0)+(4-2)+(6-3)+(6-3)= 18 - 8 = 10
    - 각각 빼고 더했을 땐 시간복잡도 초과 떠서, 한 번에 더하고 한 번에 뺌
    - (2 2 6 2) 은 4가 나와야 하는데 2가 나오는 반례를 찾음
    - 해당 방식으론 불가한 거 깨달아서 그리디로 방향 바꿈
- int 써서 틀렸어서 long 씀
*/
public class Main {
    private static long solution(int n, int[] numbers) {
        long sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        long target = sum / n;

        long answer = 0;
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (numbers[i] < target) {
                if (numbers[j] > target) {
                    numbers[j]--;
                    numbers[i]++;
                    answer += Math.abs(i - j);
                } else {
                    j++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        System.out.println(solution(n, numbers));

        br.close();
    }
}