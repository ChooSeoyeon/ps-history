import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 사과(A), 파인애플(P), 펜(p)들이 일렬로 세워져 있음
- 물건 순서 바꾸지 않고 옆에 있는 물건끼리 연결했을 때, pPAp 꼴 몇 개 만들 수 있는지 세기
- 하나의 펜(p)은 두 개의 pPAp 에 포함될 수 없음
[접근]
- String으로 받아서 pPAp 앞에서부터 발견하면 지워주기 -> 시간초과 뜸
- 앞에서부터 찾고, index 뒤로 넘기기 -> .indexOf("찾고 싶은 값", "탐색을 시작할 인덱스")
- pPAppPAp 에서 0부터 탐색해 찾았다면 그 다음엔 4부터 찾으면 됨 (i++ 되니까 +3 추가로 해주기)
[메모]
*/
public class Main {
    private static int solution(int n, String input) {
        String ppap = "pPAp";
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int index = input.indexOf(ppap, i);
            if (index == -1) {
                break;
            }
            answer++;
            i = index + 3;
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();

        System.out.println(solution(n, input));

        br.close();
    }
}
