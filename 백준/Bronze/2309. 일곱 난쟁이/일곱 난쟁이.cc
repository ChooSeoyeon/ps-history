#include<iostream>
#include<algorithm>
using namespace std;

/*
[문제 설명]
- 일곱 난쟁이의 키의 합이 100
- 9명의 사람들 키만 보고 그중 7명 난쟁이 누구인지 찾아 키를 오름차순으로 출력
[문제 접근]
- 완전탐색 - 브루트포스
- 7명씩 뽑아서 합이 100이 되나 살펴봄
- 9C7보다 9C2가 효율적이므로 2명을 뽑아서 전체 합에서 2명의 키를 뺸 값이 100이 되나 살펴봄
*/

int height[9];
int sum = 0;

int main(void) {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	// 9명 키 입력받고 그 합을 저장하는 반복문
	for (int i = 0; i < 9; i++) {
		cin >> height[i];
		sum += height[i];
	}

	sort(height, height + 9); // 오름차순 정렬하기

	for (int i = 0; i < 9; ++i) { // 첫 번째 난쟁이가 아닌 친구 선택해서 전체 합에서 제외
		sum -= height[i];

		for (int j = 0; j < 9; ++j) { // 두 번째 난쟁이가 아닌 친구 선택 전체 합에서 제외
			if (i != j) {
				sum -= height[j];
				if (sum == 100) { // 남은 7명이 난쟁이가 맞는지 판별 (7명의 합이 100인지 확인)
					for (int k = 0; k < 9; k++) { // 100이 맞다면 7명의 난쟁이 키 출력
						if (k != i && k != j) cout << height[k] << "\n";
					}
					break;
				}
				sum += height[j]; // 100이 아니라면
			}
		}
		sum += height[i]; // 100이 아니라면
	}
}
