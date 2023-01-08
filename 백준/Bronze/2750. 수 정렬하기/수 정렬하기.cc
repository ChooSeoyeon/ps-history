#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;
typedef long long ll;

/*
[문제 설명]
- N개 수를 오름차순으로 정렬
[문제 접근]
- 정렬
*/
int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n;
	int x;
	vector<int> v;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> x;
		v.push_back(x);
	}

	sort(v.begin(), v.end());

	for (int i = 0; i < n; i++) {
		cout << v[i] << "\n";
	}

	return 0;
}