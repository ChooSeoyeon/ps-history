#include<iostream>
#include <string>
#include <stack>
using namespace std;

int main()
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	cin.ignore();
	while (n--) { //2,1까진 반복. 0이 되면 종료
		string str;
		getline(cin, str);

		stack<char>s;
		for (char ch : str) { //범위 기반 for문: for(element:array) -> 루프는 각 array의 요소를 반복하여 element에 선언된 변수에 현재 배열 요소의 값을 할당한다.
			if (ch == ')') {
				if (s.empty()) {
					s.push(ch);
					break;
				}
				s.pop();
			}
			if(ch=='(') s.push(ch);
		}

		if (s.empty()) cout << "YES\n";
		else cout << "NO\n";
	}
	return 0;
}