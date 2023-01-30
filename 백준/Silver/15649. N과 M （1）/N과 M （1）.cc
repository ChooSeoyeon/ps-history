#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;
typedef long long ll;

/*
[문제 설명]
- 1부터 N까지 중에서 M개를 고른 수열
[문제 접근]
- 백트래킹
*/

int n, m;
int ans[9];
bool visited[9];

void backtracking(int lv) {
	if (lv == m) { // M개를 모두 골랐다면 출력하고 return
		for (int i = 0; i < m; i++) {
			cout << ans[i] << " ";
		}
		cout << "\n";
		return;
	}
	for (int i = 1; i <= n; i++) { // 1부터 N까지 중에서
		if (!visited[i]) { // 안 가본 곳 고르기
			visited[i] = true; // 갔다고 표시하기
			ans[lv] = i; // 간 거 기록하기
			backtracking(lv + 1); // 한 층 더 깊이가서 한 개 더 고름
			visited[i] = false; // 출력하고 돌아온 거니까 다음 번 탐색을 위해 갔던 기록 없앰
		}
	}
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;

	backtracking(0);

	return 0;
}