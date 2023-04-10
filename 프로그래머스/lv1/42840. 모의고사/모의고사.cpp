#include <string>
#include <vector>
#include <algorithm>

using namespace std;

/*
[문제 설명]
- 1번 : 12345 반복
- 2번 : 21232425 반복
- 3번 : 3311224455 반복
- 시험 최대 10000문제
[문제 접근]
- 완전 탐색_브루트포스
*/

vector<int> solution(vector<int> answers) {
    vector<int> answer;

    vector<int> a = {1,2,3,4,5};
    vector<int> b = {2,1,2,3,2,4,2,5};
    vector<int> c = {3,3,1,1,2,2,4,4,5,5};

    vector<int> cnt(3); // 3개의 원소를 0으로 초기화

    for(int i; i<answers.size(); i++){
        if(a[i % a.size()] == answers[i]) cnt[0]++;
        if(b[i % b.size()] == answers[i]) cnt[1]++;
        if(c[i % c.size()] == answers[i]) cnt[2]++;
    }

    int biggest = *max_element(cnt.begin(), cnt.end()); // 가장 큰 원소 값 저장
    // if(acnt>bcnt) biggest=acnt;
    // else biggest=bcnt;
    // if(ccnt>biggest) biggest=ccnt;

    for(int i=0; i<cnt.size(); i++) {
        if(cnt[i] == biggest) answer.push_back(i+1);
    }
    // if(acnt==biggest) answer.push_back(1);
    // if(bcnt==biggest) answer.push_back(2);
    // if(ccnt==biggest) answer.push_back(3);

    return answer;
}
