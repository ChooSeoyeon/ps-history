import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 덩굴의 균형 유지하면서 나무꼭대기에 도달할 수 있는 최소 원숭이 수 구하기
    - 덩굴은 시소처럼 양쪽 무게가 같아야(같은 수의 원숭이들이 매달려 있어야) 균형 유지됨
    - []는 덩굴이 나눠지는 지점을 의미함
    - 나무꼭대기에 도달하기 위해서 최소 한 마리 원숭이 필요함
[접근] 완전이진트리
- 최대 깊이에 따라 달라짐
    - 깊이 0 -> 2^0
    - 깊이 1 -> 2^1
    - 깊이 2 -> 2^2
    - 깊이 3 -> 2^3
- 최대 깊이는 닫히지 않은 [ 의 개수가 최대일 때의 개수와 같음
    - [ -> 깊이 1
    - [[ -> 깊이 2
    - [[[ -> 깊이 3
- 연속되어 같은 문자가 나오는 최대 횟수 x 구하기 -> 정답은 2^x
[메모]
- [] -> [ -> 깊이 1 -> 2^1
- [[]] -> [[ -> 깊이 2 -> 2^2
- [[][]] -> [[ ->  깊이 2 -> 2^2
- [[][[]]] -> [[[ -> 깊이 3 -> 2^3
[오답]
- 최대 깊이 생각할 때 단순히 연속된 [ 혹은 ]의 개수라 생각해서 틀렸었음
- 닫히지 않은 [ 의 개수로 생각하는 게 명확함
*/
public class Main {
    private static int solution(String tree) {
        int maxDepth = 0;
        int currentDepth = 0;
        for (char leaf : tree.toCharArray()) {
            if (leaf == '[') {
                currentDepth++;
            } else {
                currentDepth--;
            }
            if (currentDepth > maxDepth) {
                maxDepth = currentDepth;
            }
        }

        return (int) Math.pow(2, maxDepth);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String tree = br.readLine();
            System.out.println(solution(tree));
        }
        
        br.close();
    }
}
