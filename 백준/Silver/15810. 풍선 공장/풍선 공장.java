import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 풍선 만드는 N명의 스태프 있음. 각 스태프의 하나의 풍선을 만드는 데 걸리는 시간은 다양함
- M개의 풍선 만들기 위해 최소 몇 분이 걸릴지 구하기
[접근] 매개변수탐색
- 각 시간으로 나눠봄으로써 N개의 풍선을 만들 수 있는지 확인할 수 있음
    - 13/5 + 13/7 + 13/3 = 2 + 1 + 4 = 7 (x)
    - 14/5 + 14/7 + 14/3 = 2 + 2 + 4 = 8 (x)
    - 15/5 + 15/7 + 15/3 = 3 + 2 + 5 = 10 (o)(10개 만들어야 한다면 여기부터 N개의 풍선 만들 수 있음)
    - 16/5 + 16/7 + 16/3 = 3 + 2 + 5 = 10 (o)
- 1~10^6 중
    - 1부터 10^6까지 순회(N)하며 정답을 찾는 건(N) N^2 이라 10^6*10^6이 되어 시간초과남
    - 매개변수탐색(logN)을 사용하며 정답을 찾는 건(N) NlogN 이라 시간초과 안남
[메모]
- x x x x x o o o o 형태에서 x는 찾을 값보다 작은 것, o는 찾을 값보다 큰 것으로 취급함
    - x라면 오른편을 탐색하고, o라면 왼편을 탐색하면 됨
    - x의 최대값 찾으면 경계값 찾을 수 있음
[오답]
- 하나씩 확인하려다 시간초과 떴었음. 매개변수탐색 써서 해결함
- 수가 커서 overflow 나서 틀리는 거 같아 long으로 바꿈
- 1 1 1 로 8개 만드려할 때 3이 나와야 하는데 2가 나오는 반례 찾음
    - 탐색 조건을 left < right이 아닌 left <= right으로 변경해 해결함
    - (left=1,right=2,middle=1,count=3) 까지 돌던게 (left=2,right=2,middle=2,count=6) 까지 돌게 됨
- 1 로 8개 만드려할 때 8이 나와야 하는데 9가 나오는 반례 찾음
    - o에서 끝날 땐 그 값 그대로 쓰고, x에서 끝났을 땐 +1 해서 값 쓰도록 변경해 일단 간단히 해결함
    - 플래그 대신 result를 저장해두게 해서 제대로 해결함
*/
public class Main {
    private static long solution(int[] times, int target) {
        long min = Integer.MAX_VALUE;
        for (int time : times) {
            min = Math.min(min, time);
        }

        long left = 1;
        long right = min * target;
        long result = 0;

        while (left <= right) {
            long middle = (left + right) / 2;
            if (canMakeBalloon(times, middle, target)) {
                result = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return result;
    }

    private static boolean canMakeBalloon(int[] times, long middle, int target) {
        long count = 0;
        for (int time : times) {
            count += middle / time;
        }
        return target <= count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] times = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(input[i]);
        }

        System.out.println(solution(times, m));

        br.close();
    }
}
