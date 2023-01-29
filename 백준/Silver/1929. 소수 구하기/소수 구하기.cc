#include<iostream>
#include<vector>

using namespace std;

/*
[문제 설명]
- M이상 N이하의 소수 모두 출력
[문제 접근]
- 에라토스테네스의 체 이용
	- 소수들의 배수들을 다 제거. 이때 작은 소수부터 봄.
*/


int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int m, n;
	cin >> m >> n;

	vector<bool> isprime; // 소수인지 여부 (true면 소수, false면 합성수)
	isprime.assign(n+1, true); // 크기 n+1만큼(isprime[0]~isprime[n]) true로 초기화(일단 모두 소수라고 가정)
	isprime[1] = false; // 1은 소수 아니므로 false

	// 에라토스테네스의 체
	for (int i = 2; i * i <= n; i++) { // n의 제곱근까지만 검사하면 됨. n=15라면, 1,3,5,15 중 3까지만 보면 됨. 5는 아래 for문에서 5*5=25라 아예 걸리지 않아서.
		if (isprime[i]) { // 소수라면(2, 3, 5...)
			for (int j = i * i; j <= n; j += i) { // 그 수의 배수들은 소수가 아니라고 체크해줌. 
				isprime[j] = false; // 이때 j=i*2부터 할 필요 없음. i=5라면, 5*2, 5*3, 5*4는 이미 지워져있어서(false로 되어있어서)
			}
		}
	}

	for (int i = m; i <= n; i++) {
		if (isprime[i]) cout << i << "\n";
	}

	return 0;
}
