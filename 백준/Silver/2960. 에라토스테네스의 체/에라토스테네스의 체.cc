#include<iostream>
#include<vector>

using namespace std;
typedef long long ll;

/*
[문제 설명]
- N까지 에라토스테네스의 체 적용
- 체 적용 중 k번째로 지워지는 수 구하기
[문제 접근]
- 에라토스테네스의 체
*/
int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n, k;
	cin >> n >> k;

	int cnt = 0; // 몇 번째 지웠는지 카운트
	vector<bool> isprime; // 소수인지 여부 (true면 소수, false면 합성수)
	isprime.assign(n + 1, true); // 크기 n+1만큼(isprime[0]~isprime[n]) true로 초기화(일단 모두 소수라고 가정)
	isprime[1] = false; // 1은 소수 아니므로 false

	// 에라토스테네스의 체
	for (int i = 2; i <= n; i++) { // 원래는 n의 제곱근까지만 검사하면 됨. n=15라면, 1,3,5,15 중 3까지만 보면 됨. 5는 아래 for문에서 5*5=25라 아예 걸리지 않아서. 허나 5도 카운트해야해서 여기는 n까지 검사함
		if (isprime[i]) { // 소수라면(2, 3, 5, 7,...)

			cnt++; // 소수도 지운다네요,, 카운트 1 증가
			if (cnt == k) { // k번째 지운 거였다면
				cout << i; // 해당 숫자를 출력
				return 0;
			}

			for (int j = i * i; j <= n; j += i) { // 그 수의 배수들은 소수가 아니라고 체크해줌. 이때 j=i*2부터 할 필요 없음. i=5라면, 5*2, 5*3, 5*4는 이미 지워져있어서(false로 되어있어서)
				if (isprime[j]) { // 이전에 지웠던 걸 중복해서 지우는 거 배제시킴
					isprime[j] = false; 

					cnt++; // 지웠으므로 카운트 1 증가
					if (cnt == k) { // k번째 지운 거였다면
						cout << j; // 해당 숫자를 출력
						return 0;
					}
				}				
			}
		}
	}

	return 0;
}