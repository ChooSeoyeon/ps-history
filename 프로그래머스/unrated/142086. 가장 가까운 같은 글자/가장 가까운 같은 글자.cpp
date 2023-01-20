#include <string>
#include <vector>
using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    int num=s.length();
    int i, j;
    for(i=0;i<num;i++){
        if(i==0) answer.push_back(-1);
        else{
            for(j=i-1;j>=0;j--){
                if(s[i]==s[j]) {
                    answer.push_back(i-j);
                    break;
                }
            }
            if(j<0) answer.push_back(-1);
        }
    }
    return answer;
}