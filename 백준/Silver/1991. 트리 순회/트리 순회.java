import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
[설명]
- 이진트리를 입력받아 전위/중위/후위 순회한 결과 출력하기
	- 전위: 루트-왼쪽자식-오른쪽자식
	- 중위: 왼쪽자식-루트-오른쪽자식
	- 후위: 왼쪽자식-오른쪽자식-루트
- 노드의 개수만큼 각 노드가 (노드, 왼쪽 자식 노드, 오른쪽 자식 노드) 꼴로 주어짐
[접근] 이진트리
- 트리를 2차원 배열로 표현
	- i: 본인
	- [i][1]: 왼쪽 자식
	- [i][2]: 오른쪽 자식
- 인덱스 연산으로 순회 -> 부모로 이동할 일 없고 자식으로만 이동하면되어서 저장해둔 자식으로 이동
	- 왼쪽 자식으로 이동: i = tree[i][1]
	- 오른쪽 자식으로 이동: i = tree[i][2]
[메모]
*/
public class Main {
	private static int n;
	private static char[][] tree;

	private static void solution(char[][] nodeInfo) {
		// 트리 표현
		tree = new char[26][2]; // left, right 저장
		for (int i = 0; i < n; i++) {
			int node = nodeInfo[i][0] - 'A';
			char left = nodeInfo[i][1];
			char right = nodeInfo[i][2];
			tree[node][0] = left;
			tree[node][1] = right;
		}

		preorder('A');
		System.out.println();
		inorder('A');
		System.out.println();
		postorder('A');
	}

	private static void preorder(char node) {
		if (node == '.') {
			return;
		}
		System.out.print(node);
		preorder(tree[node - 'A'][0]);
		preorder(tree[node - 'A'][1]);
	}

	private static void inorder(char node) {
		if (node == '.') {
			return;
		}
		inorder(tree[node - 'A'][0]);
		System.out.print(node);
		inorder(tree[node - 'A'][1]);
	}

	private static void postorder(char node) {
		if (node == '.') {
			return;
		}
		postorder(tree[node - 'A'][0]);
		postorder(tree[node - 'A'][1]);
		System.out.print(node);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		char[][] nodeInfo = new char[n][3];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				nodeInfo[i][j] = input[j].charAt(0);
			}
		}

		solution(nodeInfo);

		br.close();
	}
}