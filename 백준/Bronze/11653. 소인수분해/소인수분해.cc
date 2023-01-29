#include<iostream>
#include<vector>

using namespace std;

/*
[문제 설명]
- N을 소인수분해한 결과를 오름차순으로 출력. N이 1인 경우 아무것도 출력하지 않음
[문제 접근]
- 소수인 인수(약수)를 구하기
- 소수를 찾고 그거로 나눠보지 않고, 2부터 모든 숫자로 나눠봄
*/
int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 2; i*i <= n; i++) { // n을 나눌 후보들 -> 2부터 n의 제곱근까지임
		while (n % i == 0) { // 그 수가 n을 나누어떨어지게 하는지 봄. 나누어떨어지지 않을 때까지 나눔.
			cout << i << "\n";
			n /= i; // 나누어떨어지니까 실제로 나눠줌.
		}
	}

	// n이 소수일 경우 위에 for문에 걸리지 않음 -> 따로 처리해주어야 함
	if (n != 1) {
		cout << n;
	}

	return 0;
}