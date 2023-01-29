#include<iostream>

using namespace std;
typedef long long ll;

/*
[문제 설명]
- 두 개 자연수 입력받아 최대 공약수와 최소 공배수 출력
[문제 접근]
- 최대 공약수는 유클리드 호제법 활용
	- 유클리드 호제법 -> A % B = R -> GCD(A, B) = GCD(B, R)
	- A,B는 순서 상관 없음
		- ex) GCD(20,12) = GCD(12,8) = GCD(8,4) = GCD(4,0) = 4
		- ex) GCD(12,20) = GCD(20,8) = GCD(8,4) = GCD(4,0) = 4
- 최소 공배수는 두 수의 곱이 최대공약수와 최소공배수의 곱임을 활용
	- A * B = GCD(A, B) * LCM(A, B)
	- LCM(A, B) = A / GCD(A, B) * B
	- 오버플로우 방지를 위해 `*B`보다 `/GCD(A, B)`를 먼저 함. 나눠주고 곱하기.
*/

// 최대공약수
int gcd(int a, int b) {
	if (!b) return a; // b가 0이라면
	return gcd(b, a % b);
}

// 최소공배수
int lcm(int a, int b) {
	return a / gcd(a, b) * b;
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int a, b;
	cin >> a >> b;

	cout << gcd(a, b) << "\n" << lcm(a, b) << "\n";

	return 0;
}