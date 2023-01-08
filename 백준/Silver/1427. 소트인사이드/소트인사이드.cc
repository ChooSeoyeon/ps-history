#include<iostream>
#include<algorithm>
#include<vector>
#include<string>
//#include<typeinfo>

using namespace std;
typedef long long ll;

/*
[문제 설명]
- 주어진 수의 각 자리수를 내림차순으로 정렬
[문제 접근]
- 정렬
*/
int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	string n;
	vector<int> v;

	cin >> n; // 숫자를 문자열로 입력받기. 정수로 입력받으면 길이 구하는 로직 따로 필요해서, string으로 입력받아 length()함수 이용함
	//cout << typeid(n[0]).name();
	for (int i = 0; i < n.length(); i++) {
		v.push_back(n[i] - '0'); // 문자열의 각 문자를 숫자로 바꿔서 저장. 
		// 이때, (int)쓰면 '1'의 아스키코드값 49저장되므로 쓰면 안됨
	}

	sort(v.rbegin(), v.rend()); // 내림차순 정렬

	for (int i = 0; i < n.length(); i++) {
		cout << v[i];
	}

	return 0;
}
