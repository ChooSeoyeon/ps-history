#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    
    sort(citations.rbegin(), citations.rend());
    
    for(int i=0; i<citations.size(); i++) {
        cout << citations[i] << endl;
        if(citations[i] >= i+1) {
            answer = i+1;
        }
    }
    
    return answer;
}