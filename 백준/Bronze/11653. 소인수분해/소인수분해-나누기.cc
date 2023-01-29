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

	for (int i = 2; 1 < n; i++) { // n이 더이상 나눌 수 없는 1이 될 때까지 n을 나눔
		while (n % i == 0) { // 그 수가 n을 나누어떨어지게 하는지 봄. 나누어떨어지지 않을 때까지 나눔.
			cout << i << "\n";
			n /= i; // 나누어떨어지니까 실제로 나눠줌.
		}
	}

	return 0;
}
