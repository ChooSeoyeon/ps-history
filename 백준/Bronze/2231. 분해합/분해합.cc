#include<iostream>
using namespace std;
int main()
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int cnt = 0;
	int n, i;
	bool find=false;
	cin >> n;
	for (i = n; i>0 ; i=i/10) cnt++;
    
	for (i = n - 9 * cnt; i < n; i++)
	{
		int answer = 0;
		int k = i;
		while (k != 0){
			answer = answer +k % 10;
			k = k / 10;
        }

		if (i + answer == n){
			find = true;
			cout << i;
			break;
		}

	}
	if(find==false) cout << "0";
}