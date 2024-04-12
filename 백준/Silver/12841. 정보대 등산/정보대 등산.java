import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 왼쪽 길과 오른쪽 길의 중간중간엔 횡단보도 있고, 횡단보도는 한 번만 건널 수 있음
	- 1번 지점부터 n번 지점까지 횡단보도 한 개씩 있음
	- 왼쪽 1번 지점이 출발지, 오른쪽 n번 지점이 도착지임
- 최소한으로 걷기 위해 건너야 하는 횡단보도 지점의 번호와 걸어야 할 거리 구하기
	- 만일 최소 거리로 갈 수 있는 지점이 여러 곳일 땐 번호가 낮은 지점을 구하기
[접근] 구간합 |_| 꼴로 같은 인덱스 가짐
-                   mid[0]  left[0]..[n-1]
- right[0]          mid[1]  left[1]..[n-1]
- right[0]..[1]     mid[2]  left[2]..[n-1]
- right[0]..[n-2]   mid[n-1]     left[n-1]
- right[0]..[n-1]   mid[n]
- 처음에 _| 형태로 전부 더한값 구하고, 이후엔 한칸씩 _| 을 버리고, |-를 더하기
[메모]
- 각 지점의 횡단보도 거리: 2 3 1 4
	- 왼쪽 길의 각 지점 사이 거리 : 1 2 3
	- 오른쪽 길의 각 지점 사이 거리 : 2 5 6
[오답]
- 별 생각 없이 완전탐색으로 풀었는데 N^2이라 10^12승으로 시간초과는 안떴지만 틀렸음. 구간합으로 풀어 해결함
*/
public class Main {
    private static long[] solution(int[] crosswalk, int[] left, int[] right) {
        long distance = crosswalk[0];
        for (int r : right) {
            distance += r;
        }

        long minCrosswalk = 0;
        long minDistance = distance;
        for (int i = 1; i < crosswalk.length; i++) {
            distance = distance - crosswalk[i - 1] - right[i - 1] + crosswalk[i] + left[i - 1];
            if (distance < minDistance) {
                minCrosswalk = i + 1;
                minDistance = distance;
            }
        }

        return new long[]{minCrosswalk, minDistance};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] crosswalk = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            crosswalk[i] = Integer.parseInt(input[i]);
        }

        int[] left = new int[n - 1];
        input = br.readLine().split(" ");
        for (int i = 0; i < n - 1; i++) {
            left[i] = Integer.parseInt(input[i]);
        }

        int[] right = new int[n - 1];
        input = br.readLine().split(" ");
        for (int i = 0; i < n - 1; i++) {
            right[i] = Integer.parseInt(input[i]);
        }

        long[] answer = solution(crosswalk, left, right);
        System.out.println(answer[0] + " " + answer[1]);

        br.close();
    }
}
