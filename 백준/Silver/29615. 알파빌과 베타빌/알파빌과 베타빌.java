import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
[설명]
- 대기명단에 대기 번호가 입주하는 순서대로 왼쪽에서 오른쪽으로 적혀 있음
- 대기 번호는 1부터 N까지의 서로 다른 정수임
- 한 번 명단 바꿀 때 번호 두 개를 선택해서 서로 위치 교환할 수 있음
- 민규의 모든 친구가 친구가 아닌 사람들보다 먼저 입주하도록 명단을 바꿀 때, 최소 교환 횟수 구하기
[접근]
- 제 자리가 아닌 애들의 개수 세면 됨
- 친구들 수 만큼의 인덱스 밖의 영역에 있는 애들의 개수 세면 됨
[메모]
*/
public class Main {
    private static int solution(int[] numbers, int[] friends) {
        List<Integer> numberList = new ArrayList<>();
        for (int number : numbers) {
            numberList.add(number);
        }

        int answer = 0;
        int maxIndex = friends.length - 1;
        for (int friend : friends) {
            int friendIndex = numberList.indexOf(friend);
            if (friendIndex > maxIndex) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        int[] friends = new int[m];
        for (int i = 0; i < m; i++) {
            friends[i] = Integer.parseInt(input[i]);
        }

        System.out.println(solution(numbers, friends));

        br.close();
    }
}
