# PS-history
알고리즘 문제를 풀며 주석에 정리해둔 생각들을 쉽게 다시 찾아보기 위해 BaekjoonHub의 auto push 기능을 활용한 리포지토리입니다.

주석은 아래와 같은 형식으로 달고 있습니다.
```
#include<iostream>

using namespace std;
typedef long long ll;

/*
[문제 설명]
- 모든 자리가 1로만 이루어진 두 수 A, B의 최대공약수 구하기
[문제 접근]
- 유클리드 호제법
- long long
- 1로만 이루어진 수들은 나눴을 때 나머지도 1로만 나옴
- 1111111/111=...1 -> 7/3=...1
- 111111/111=...111 -> 6/3=...3
- 11111/111=...11 -> 5/3=...2
- 1111/111=...1 -> 4/3=...1
- 111/111=...0 -> 3/3=...0
*/

// 최대공약수
ll gcd(ll a, ll b) {
	if (!b) return a; // b가 0이라면
	return gcd(b, a % b);
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	ll a, b;
	cin >> a >> b;

	for (ll i = 0; i < gcd(a, b); i++) {
		cout << "1";
	}
	return 0;
}

```
