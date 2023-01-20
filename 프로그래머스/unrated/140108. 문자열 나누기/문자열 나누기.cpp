#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    int num = s.length();
    int i, j;
    for (i = 0; i < num; i++) {
        int count_x = 0;
        int count_else = 0;
        int x = s[i];
        for (j = i; j < num; j++) {
            if (s[j] == x) count_x++;
            else count_else++;
            if (count_x == count_else) break;
        }
        i=j;
        answer++;
    }

    return answer;
}