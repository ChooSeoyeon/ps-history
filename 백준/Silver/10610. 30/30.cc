#include<iostream>
#include<algorithm>
#include<vector>
#include<string>

using namespace std;
typedef long long ll;

/*
[문제 설명]
- 주어진 수의 각 자리수를 재정렬해 가장 큰 30의 배수로 만들기
- 30의 배수가 될 수 없으면 -1을 출력
[문제 접근]
- 30의 배수 판별법: 각 자리수를 전부 더한게 3의 배수 && 끝의 자리가 0
- 각 자릿수 전부 더한게 3의 배수가 아니라면 가능성이 아예 없는거니 -1 출력
- 가능성 있다면 가장 큰 수가 되게 정렬(내림차순)하면 됨
- 내림차순 정렬하면 자연스럽게 0이 끝의 자리로 가서 30의 배수가 됨
- 끝의 자리가 0이 아니라면 30의 배수가 아닌 거므로 -1 출력
*/
int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	string n; // 숫자를 문자열로 입력받음
	vector<int> v; // 문자열을 숫자배열에 저장 -> 정렬
	int sum = 0; // 각 자리수의 합

	cin >> n; // 숫자를 문자열로 입력받기

	for (int i = 0; i < n.length(); i++) {
		v.push_back(n[i] - '0'); // 문자열의 각 문자를 숫자로 바꿔서 저장
		sum += v[i]; // 각 자리수의 합 구하기
	}

	if (sum % 3 != 0) { // 각 자리수를 전부 더한게 3의 배수가 아니라면
		cout << "-1\n"; // 30의 배수가 될 수 없음
		return 0;
	}

	sort(v.rbegin(), v.rend()); // 내림차순 정렬

	if (v.back() != 0) { // 정렬 결과의 끝의 자리가 0이 아니라면
		cout << "-1\n"; // 30의 배수가 될 수 없음
		return 0;
	}

	for (int i = 0; i < n.length(); i++) {
		cout << v[i];
	}

	return 0;
}