#include<iostream>
#include <queue>
using namespace std;

//use stl

int main()
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int test;
	cin >> test;

	string user;
	int x;
	queue<int> s;
	for (int i = 0; i < test; i++)
	{
		cin >> user;
		if (user == "push") {
			cin >> x;
			s.push(x);
		}
		else if (user == "pop") {
			if (!s.empty()) {
				cout << s.front() << "\n";
				s.pop();
			}
			else cout << -1 << "\n";
		}
		else if (user == "size") {
			cout << s.size() << "\n";
		}
		else if (user == "empty") {
			cout << s.empty() << "\n";
		}
		else if (user == "front") {
			if (!s.empty()) cout << s.front() << "\n";
			else cout << -1 << "\n";
		}
		else if (user == "back") {
			if (!s.empty()) cout << s.back() << "\n";
			else cout << -1 << "\n";
		}
	}
}