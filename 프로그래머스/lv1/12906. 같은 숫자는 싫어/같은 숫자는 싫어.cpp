#include <vector>
#include <iostream>
#include <queue>

using namespace std;

/*
[문제 설명]
- 배열에서 겹치는 숫자 제외하기. 단, 순서는 유지
[문제 접근]
- 큐(First in First out)
*/


vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    queue<int> q; // 사용 예) s.push(), s.pop(), s.front(), s.back(), s.empty()
    int temp = -1;
    
    for(int i: arr) {
        if(temp != i) {
            temp = i;
            q.push(i);
        }   
    }
    int size= q.size();
    for(int i=0; i<size; i++) {
        answer.push_back(q.front());
        q.pop();
    }
    
    return answer;
}