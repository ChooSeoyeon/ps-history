#include <string>
#include <vector>
#include <algorithm>
using namespace std;

/*
[문제 설명]
- 다양한 크기의 명합 수납할 수 있는 가장 작은 지갑
- 가로,세로 상관 없이 큰 쪽, 작은 쪽으로 구분!
- 모든 명함 길이를 큰 쪽, 작은 쪽으로 나눠 저장한 후
- 큰 쪽 중 가장 큰 값, 작은 쪽 중 가장 큰 값으로 지갑 만들면 됨
[문제 접근]
- 완전 탐색_브루트포스
*/

int solution(vector<vector<int>> sizes) {
    int answer = 0;
    int big = 0;
    int small = 0;
    
    // sizes.size()는 명함 개수
    for(int i=0; i<sizes.size(); i++) {
        big = max(big, max(sizes[i][0], sizes[i][1])); // 둘 중 더 큰 애들 중 최대값
        small = max(small, min(sizes[i][0], sizes[i][1])); // 둘 중 더 작은 애들 중 최대값
        
        // if(sizes[i][0] > sizes[i][1]) {
        //     big.push_back(sizes[i][0]);
        //     small.push_back(sizes[i][1]);
        // }
        // else  {
        //     big.push_back(sizes[i][1]);
        //     small.push_back(sizes[i][0]);
        // }
    }
    
    // int biggest = *max_element(big.begin(), big.end());
    // int smallest = *max_element(small.begin(), small.end());
    // answer = biggest * smallest;
    answer = big * small;
    
    return answer;
}