using namespace std;

/*
[문제 설명]
- 처음 이용료 : price원
- N번째 이용료 : price * N원
- count번 탔을 때 현재 갖고 있는 금액에서 얼마가 모자라는지 return
- 금액 안모자라면 0 return
[문제 접근]
- 반복문 혹은 가우스 공식 사용
- 조건연산자 사용 -> (조건식) ? 표현식1 : 표현식2;
*/

long long solution(int price, int money, int count)
{
    long long sum=1LL*price*(count+1)*count/2;
    return (money-sum<0)?(money-sum)*(-1):0;
}