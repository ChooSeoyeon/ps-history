#include<iostream>

using namespace std;
typedef long long ll;

/*
[문제 설명]
- 두 수 A, B의 최소공배수 구하기
[문제 접근]
- 유클리드 호제법
- 최소공배수*최대공약수=a*b
- long long
*/

// 최대공약수
ll gcd(ll a, ll b) {
	if (!b) return a; // b가 0이라면
	return gcd(b, a % b);
}

// 최소공배수
ll lcm(ll a, ll b) {
	return a / gcd(a, b) * b;
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	ll a, b;
	cin >> a >> b;

	cout << lcm(a, b) << "\n";
	return 0;
}