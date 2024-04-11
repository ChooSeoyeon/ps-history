import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
[설명]
- 기숙사의 각 방에 진단 키트 제공했는데, 방마다 받은 키트의 수가 다름
- 모든 방이 같은 수의 키트 가지도록 방끼리 키트 주고받음
- 키트는 바로 옆방에만 넘겨줄 수 있고, 바로 옆방으로 키트 한 개를 건네줄 때 혼잡도가 1 증가함
- 최대한 가까운 방끼리 키트 주고받을 때, 혼잡도가 최소임. 혼잡도의 최솟값 구하기
[접근]
- 넘치는 애들과 부족한 애들을 각자의 인덱스로 넘치거나 부족한 값만큼 반복해 큐에 저장해두기
    - 예시: [0]2 [1]6 [2]3 [3]2 [4]5 [5]4 [6]6 -> 기준값: 28/7 = 4
    - 넘치는 큐: 1 1 4 6 6
    - 부족한 큐: 0 0 2 3 3
    - 계산: (1-0)+(1-0)+(4-2)+(6-3)+(6-3)=10
[메모]
- 시간복잡도 터질듯..
*/
public class Main {
    private static int solution(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        int target = sum / numbers.length;

        List<Integer> more = new ArrayList<>();
        List<Integer> less = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            int gap = numbers[i] - target;
            if (gap > 0) {
                for (int j = 0; j < gap; j++) {
                    more.add(i);
                }
            }
            if (gap < 0) {
                gap *= (-1);
                for (int j = 0; j < gap; j++) {
                    less.add(i);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < more.size(); i++) {
            answer += Math.abs(more.get(i) - less.get(i));
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

        System.out.println(solution(numbers));

        br.close();
    }
}
