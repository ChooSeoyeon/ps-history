#include<iostream>
#include<cmath>
using namespace std;

int main()
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int m, n;
	cin >> m >> n;
	bool* prime = new bool[n+1];

	prime[0] = false;
	prime[1] = false;
	for (int i = 2; i <= n; i++) {
		prime[i] = true;
	}
	
	for (int i = 2; i <= sqrt(n); i++) {
		if (prime[i]) {
			for (int j = i*2; j <= n; j+= i) {
				prime[j] = 0;
			}
		}
	}

	for (int i = m; i <= n; i++) {
		if(prime[i]) cout << i << "\n";
	}
}