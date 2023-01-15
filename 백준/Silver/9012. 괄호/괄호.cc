#include<iostream>
#include <string>
#include <stack>
#include <algorithm>
#include<vector>

using namespace std;
typedef long long ll;
/*
[문제 설명]
- 괄호 문자열 : 두 개의 괄호 기호만으로 구성된 문자열
- 올바른 괄호 문자열(VPS) : 괄호의 모양이 바르게 구성된 문자열
- VPS 속의 VPS, VPS끼리 접합 가능
- 주어진 괄호 문자열이 vps면 YES, 아니면 NO 출력
[문제 접근]
- 스택 이용
- 1. 여는 괄호 나오면 push
- 2. 닫는 괄호 나오면 스택이 비어있으면 push, 비어있지 않다면 pop해서 현재 닫는괄호와 짝지어주기
- 괄호문자열의 모든 문자를 대상으로 앞에서부터 순서대로 검사해 1이나 2 적용
- 모든 검사가 끝났을 때 스택이 비어있으면 모두가 짝을 찾아간 것이므로 YES, 비어있지 않다면 NO
*/

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
			if (ch == '(') s.push(ch);
		}

		if (s.empty()) cout << "YES\n";
		else cout << "NO\n";
	}
	return 0;
}
