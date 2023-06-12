#include<bits/stdc++.h>
using namespace std;

int n, m;
char board[50][50];
int ans = INT_MAX;

int main(void) {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m; 
	for (int i = 0; i < n; i++) { 
		for (int j = 0; j < m; j++) {
			cin >> board[i][j]; // 보드 입력받기
		}
	}

	for (int i = 0; i < n - 7; ++i) { // 행 시작점
		for (int j = 0; j < m - 7; ++j) { // 열 시작
			// 각 왼쪽 상단 끝 칸에서 순회하며 몇 개의 칸을 칠해야하는지 체크
			int cnt = 0;
			for (int a = 0; a < 8; ++a) {
				for (int b = 0; b < 8; ++b) {
					// 몇 개의 칸 칠해야하는지 체크하는 부분
					// 첫 번째 칸[0][0]의 색이 'B'라고 가정함
					if ((a%2==0 && b%2==0)||(a%2==1 && b%2==1)) { // [0][0], [0][2].. [1][1], [1][3].. [2][0], [2][2].. [3][1], [3],[3].. -> 'B'여야 함
						if (board[i + a][j + b] == 'W')cnt++; // 'W'라면 색칠해서 'B'로 바꿔줘야함. cnt 1증가.
					}
					else { // [0][1]. [0][3].. [1][0], [1][2]..[2][1], [2][3].. [3][0], [3],[2].. -> 'W'여야 함
						if(board[i + a][j + b] == 'B')cnt++; // 'B'라면 색칠해서 'W'로 바꿔줘야함.
					}
				}
			}
			if (cnt > 64 - cnt) cnt = 64 - cnt; // 만일 첫 번째 칸[0][0]의 색이 'W'인 경우(64-cnt)가 더 적게 칠하는 경우라면 이를 cnt값으로 가짐
			if (ans > cnt) ans = cnt; // 제일 적게 칠하는 경우의 칠한 칸의 개수를 기록
		}
	}
	cout << ans << "\n";
}