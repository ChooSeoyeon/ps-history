#include<iostream>
using namespace std;

/*
[문제 설명]
- 처음 이용료 : price원
- N번째 이용료 : price * N원
- count번 탔을 때 현재 갖고 있는 금액에서 얼마가 모자라는지 return
- 금액 안모자라면 0 return
[문제 접근]
- 
*/

long long solution(int price, int money, int count)
{
    long long answer = -1;
    
    long long sum = 0; // sum이 int면 price, count가 최대치일 때 음수 나옴 -> 1000000000-(-774309592)=-1774309592
    // sum이 long이어야 제대로 계산됨 -> 1000000000-7815625000=6815625000
    for(int i=1; i<=count; i++) {
        sum += price*i;
        // cout << price*i << endl;
    }
    cout << money << "-" << sum << "=" << (money - sum) * (-1);
    if(money - sum < 0) answer = (money - sum) * (-1);
    else answer = 0;

    return answer;
}