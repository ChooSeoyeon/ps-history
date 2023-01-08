#include<iostream>
#include<algorithm>
#include<vector>
#include<string>

using namespace std;
typedef long long ll;

/*
[문제 설명]
- 나이, 가입순대로 오름차순 정렬
- 나이 우선해서 정렬
[문제 접근]
- 비교함수 이용해서 원하는 순서로 정렬하기
- 들어오는 순서를 인덱스로 저장해서 가입순대로 정렬할 때 사용하기
*/
struct member {
	string name;
	int age, index;
};

bool compare(const member& a, const member& b) {
	if (a.age != b.age) // 나이가 다르면 나이 순으로 정열
		return a.age < b.age;
	else // 나이가 같으면 가입한 순으로 정열
		return a.index < b.index;
}

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n;
	struct member x;
	vector<struct member> v;

	cin >> n; // 회원 수
	for (int i = 0; i < n; i++) {
		cin >> x.age >> x.name; // 나이, 이름 입력받음
		x.index = i; // 입력받은 순서를 반복문 인덱스 이용해 저장함
		v.push_back(x);
	}

	sort(v.begin(), v.end(), compare);

	for (int i = 0; i < n; i++) {
		cout << v[i].age <<" "<< v[i].name << "\n";
	}

	return 0;
}