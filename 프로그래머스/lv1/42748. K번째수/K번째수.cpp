#include <string>
#include <vector>
#include <algorithm> 

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    for(int i=0; i<commands.size(); i++) {
        int start = commands[i][0];
        int end = commands[i][1];
        int index = commands[i][2];
        
        vector<int> slice(array.begin() + start - 1, array.begin() + end);
        
        sort(slice.begin(), slice.end());
        
        answer.push_back(slice[index-1]);
        
        // for (int &j: slice) {
        //     std::cout << j << ' ';
        // }
        // cout << endl;
    }
    
    return answer;
}