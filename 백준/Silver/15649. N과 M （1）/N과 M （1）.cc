#include<iostream>
using namespace std;

int n, m;
int ans[9];
bool visited[9];

void backtracking(int lv) {
	if (lv == m) {
		for (int i = 0; i < m; i++) {
			cout << ans[i] << " ";
		}
		cout << "\n";
		return;
	}
	for (int i = 1; i <= n; i++) {
		if (!visited[i]) {
			visited[i] = true;
			ans[lv] = i;
			backtracking(lv + 1);
			visited[i] = false;
		}
	}
}

int main()
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> m;

	backtracking(0);
}