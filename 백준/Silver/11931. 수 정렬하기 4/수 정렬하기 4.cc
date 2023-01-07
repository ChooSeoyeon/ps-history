#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;
typedef long long ll;

/*
[문제 설명]
- N개 수를 내림차순으로 정렬
[문제 접근]
- 비교함수를 이용해서 내림차순 정렬
*/
bool compare(int a, int b) {
	return a > b;
}

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

	sort(v.begin(), v.end(), compare);

	for (int i = 0; i < n; i++) {
		cout << v[i] << "\n";
	}

	return 0;
}
