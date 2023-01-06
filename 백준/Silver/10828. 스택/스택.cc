#include<iostream>
#include <stack>
using namespace std;

//stl 이용

int main()
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int test;
	cin >> test;

	string user;
	int x;
	stack<int> s;
	for (int i = 0; i < test; i++)
	{
		cin >> user;
		if (user == "push") {
			cin >> x;
			s.push(x);
		}
		else if (user == "pop") {
			if (!s.empty()) {
				cout << s.top() << "\n";
				s.pop();
			}
			else cout << -1<<"\n";
		}
		else if (user == "size") {
			cout<< s.size() << "\n";
		}
		else if (user == "empty") {
			cout<< s.empty() << "\n";
		}
		else if (user == "top") {
			if (!s.empty()) cout << s.top() << "\n";
			else cout << -1<<"\n";
		}
	}
}