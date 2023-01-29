#include<iostream>
#include<vector>

using namespace std;

/*
[문제 설명]
- N을 소인수분해한 결과를 오름차순으로 출력. N이 1인 경우 아무것도 출력하지 않음
[문제 접근]
- 소수인 인수(약수)를 구하기
- 소수는 에라토스테네스의 체로 구하기
- N 이하의 모든 소수를 찾고서, N을 찾은 소수들로 나누기
*/
int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;

	vector<bool> isprime; // 소수인지 여부 (true면 소수, false면 합성수)
	isprime.assign(n + 1, true); // 크기 n+1만큼(isprime[0]~isprime[n]) true로 초기화(일단 모두 소수라고 가정)
	isprime[1] = false; // 1은 소수 아니므로 false

	// 에라토스테네스의 체
	for (int i = 2; i * i <= n; i++) { // n의 제곱근까지만 검사하면 됨. n=15라면, 1,3,5,15 중 3까지만 보면 됨. 5는 아래 for문에서 5*5=25라 아예 걸리지 않아서.
		if (isprime[i]) { // 소수라면(2, 3, 5...)
			for (int j = i * i; j <= n; j += i) { // 그 수의 배수들은 소수가 아니라고 체크해줌. 
				isprime[j] = false; // 이때 j=i*2부터 할 필요 없음. i=5라면, 5*2, 5*3, 5*4는 이미 지워져있어서(false로 되어있어서)
			}
		}
	}

	for (int i = 2; 1 < n; i++) { // n이 더이상 나눌 수 없는 1이 될 때까지 n을 소수로 나눔
		if (isprime[i]) { // 소수라면(2, 3, 5...)
			while (n % i == 0) { // 그 수가 n을 나누어떨어지게 하는지 봄. 나누어떨어지지 않을 때까지 나눔.
				cout << i << " ";
				n /= i; // 나누어떨어지니까 실제로 나눠줌.
			}
		}
	}

	return 0;
}
