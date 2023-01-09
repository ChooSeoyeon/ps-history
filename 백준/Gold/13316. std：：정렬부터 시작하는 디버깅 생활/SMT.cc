#include<stdio.h>
#include<algorithm>
#include<vector>
#include<stdlib.h>
#include<cassert>
#include<iostream>

using namespace std;

typedef pair<int, int> pii;

/*
[문제 설명]
- x >= 0, y >= 0
- x1 * y2 <= x2 * y1
- 위 조건 만족하게 (x,y)를 정렬
- std::sort를 썼을 때 반례를 찾기
[문제 접근]
- (0,0)이 두 번 들어가게 해서 테스트해보면 됨
*/
int main()
{
	int N, a, b;
	scanf("%d", &N);
	assert(2 <= N && N <= 1000);

	vector<pii> G;
	for (int i = 1; i <= N; i++) {
		scanf("%d %d", &a, &b);
		assert(0 <= a && a <= 1000 && 0 <= b && b <= 1000);
		G.push_back(pii(a, b));
	}
	sort(G.begin(), G.end(), [](const pii& l, const pii& r) { return l.first * r.second < l.second* r.first; });

	bool ch = false;
	for (int i = 0; i < N; i++) {
		for (int j = i + 1; j < N; j++) {
			ch |= G[i].first * G[j].second > G[i].second * G[j].first;
		}
	}

	cout << ch << endl; 

	for (int i = 0; i < N; i++) {
		cout << G[i].first << " " << G[i].second << endl;
	}
	return 0;
}
