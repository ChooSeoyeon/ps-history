import java.io.IOException;
import java.util.*;

/*
[설명]
- 사람(P)과 햄버거(H)가 랜덤 순서로 일렬로 놓여 있음
- 사람은 거리가 K 이하인 햄버거 먹을 수 있음
- 식탁의 길이(N), 햄버거를 선택할 수 있는 거리(K), 사람과 햄버거 위치(HHPHPPHHPPHPPPHPHPHP) 주어졌을 때,
- 햄버거 먹을 수 있는 사람의 최대 수 구하기
[접근] 그리디
- 각자의 자리에서 최대한 멀리있는 햄버거를 먹게 해주자.
- 순서는 앞에서부터 가보자.
- 먹을 수 있는 햄버거가 있으면, 햄버거를 N으로 바꿔주고 count를 1 올리자.
*/
public class Main {

    public static void main(String[] args) throws IOException {
        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        char[] ph = sc.next().toCharArray();

        // 출력
        System.out.println(countEatable(k, ph));
    }

    private static int countEatable(int k, char[] ph) {

        int cnt = 0;
        for (int i = 0; i < ph.length; i++) {
            if (ph[i] == 'P' && canEat(i, k, ph)) {
                cnt++;
            }
        }
        return cnt;
    }

    private static boolean canEat(int i, int k, char[] ph) {

        for (int j = i - k; j <= i + k; j++) {
            if (j == i) continue; // 본인은 제외
            if (j >= 0 && j < ph.length && ph[j] == 'H') {
                ph[j] = 'N';
                return true;
            }
        }
        return false;
    }
}
