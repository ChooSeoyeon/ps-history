#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

/*
[문제 설명]
- h번 이상 인용된 논문이 h편 이상이고 
- 나머지 논문이 h번 이하 인용되었다면 
- h의 최댓값이 H-Index
[문제 접근]
- 내림차순 정렬 후, 앞에서부터 `h번 이상 인용된 논문 >= h편`인지 확인
- 내림차순되어 있어서 현재 논문의 뒷부분이 `h번 이하 인용`된 논문들인 건 
- 당연한 사실이라 확인할 필요 없음
- 원소의 값 == 인용 횟수
- 원소의 인덱스+1 == 몇 번째인지
*/


int solution(vector<int> citations) {
    int answer = 0;
    
    sort(citations.rbegin(), citations.rend());
    
    for(int i=0; i<citations.size(); i++) {
        cout << citations[i] << endl;
        if(citations[i] >= i+1) { // h번 이상 인용된 논문 >= h편
            answer = i+1; // 위 조건을 만족하는 최대치까지 갱신
            // answer = citations[i];로 하면 안되는 이유 : [8,7,6,6,6]이면 h=6가 아니라 5임
        }
    }
    
    return answer;
}
