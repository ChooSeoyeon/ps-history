#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

/*
[문제 설명]
- 나이, 가입순대로 오름차순 정렬
- 나이 우선해서 정렬
[문제 접근]
- 비교함수 이용해서 원하는 순서로 정렬하기
- 들어오는 순서를 인덱스로 저장해서 가입순대로 정렬할 때 사용하기
*/
bool sosu(int num) {
	if (num < 2) return false;
	int a = (int) sqrt(num);
	for (int i = 2; i <= a; i++) if (num % i == 0) return false;
	return true;
}

int solution(string numbers) {
    int answer = 0;
    vector<int> v;
    sort(numbers.begin(),numbers.end()); // 미리 정렬
    
    string tmp = "";
    do {
        for(int i=0; i<numbers.length(); i++) {
            tmp+=numbers[i];
            v.push_back(stoi(tmp));  // 순열 값 저장 "011"
            // 011 -> 0, (0)1, (0)11
            // 101 -> 1, 10, 101
            // 110 -> 1, 11, 110
            cout << stoi(tmp) << endl;
        }
        cout << endl;
        tmp = "";
        
    } while(next_permutation(numbers.begin(),numbers.end()));
    
    // 중복 제거
    sort(v.begin(), v.end());
    v.erase(unique(v.begin(), v.end()), v.end());

	for(int i: v){
		cout << i << endl;
		if (sosu(i)) {
			answer++;
		}
	}
    
    return answer;
}