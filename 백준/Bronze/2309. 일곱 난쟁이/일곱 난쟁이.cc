#include<bits/stdc++.h>
using namespace std;

int height[9];
int sum = 0;

int main(void) {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	//9명 키 입력받고 그 합을 저장하는 반복문
	for (int i = 0; i < 9; i++) { 
		cin >> height[i];
		sum += height[i];
	}
	// cout << sum << endl;
	
	sort(height, height + 9); //정렬하기

	for (int i = 0; i < 9; ++i) { // 첫 번째 난쟁이가 아닌 친구 선택해서 전체 합에서 제외
		sum -= height[i];
		
		for (int j = 0; j < 9; ++j) { // 두 번째 난쟁이가 아닌 친구 선택 전체 합에서 제외
			//cout << height[i] << "             " << sum << endl;
			if(i!=j) sum -= height[j];
			//cout << height[i] << " " << height[j] << " " << sum << endl;
			if (sum == 100) { // 남은 7명이 난쟁이가 맞는지 판별 (7명의 합이 100인지 확인)
				for (int k = 0; k < 9; k++) { // 100이 맞다면 7명의 난쟁이 키 출력
					if (k != i && k != j) cout << height[k]<<"\n";
				}
				break;
			}
			else {
				if(i!=j) sum += height[j]; // 100이 아니라면 
			}
		} 
		if (sum == 100) break;
		sum += height[i];
	}
}