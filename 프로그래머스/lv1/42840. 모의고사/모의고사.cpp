#include <string>
#include <vector>
#include <iostream>
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
    
    int acnt=0;
    int bcnt=0;
    int ccnt=0;
    
    for(int i; i<answers.size(); i++){
        if(a[i % a.size()] == answers[i]) acnt++;
        if(b[i % b.size()] == answers[i]) bcnt++;
        if(c[i % c.size()] == answers[i]) ccnt++;
    }
    
    int biggest = 0;
    
    if(acnt>bcnt) biggest=acnt;
    else biggest=bcnt;
    if(ccnt>biggest) biggest=ccnt;
    
    if(acnt==biggest) answer.push_back(1);
    if(bcnt==biggest) answer.push_back(2);
    if(ccnt==biggest) answer.push_back(3);
    
    return answer;
}