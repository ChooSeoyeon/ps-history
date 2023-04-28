/*
[설명]
- 번호 순대로 끝말잇기 단어 말함 (마지막 다음은 첫번째)
- 한글자안됨 (2~50 소문자)
- 사람 수 n, 말한 단어 words
- 가장 먼저 탈락한 사람 번호 & 몇 번째에 탈락한건지 [번호,차례] return
- 탈락자 없으면 [0,0] return
[접근]
- 반복문(단어개수만큼 반복)으로 이어지는지랑, 겹치는지 보기
*/
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        for(int i=1; i<words.length; i++) {
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) || check(words, i)) {
                answer[0]=(i%n)+1;
                answer[1]=(i/n)+1;
                System.out.println(words[i-1] + " " + words[i]);
                break;
            }
        }

        return answer;
    }
    
    public boolean check(String[] words, int num) {
        for(int i=0; i<num; i++) {
            if(words[i].equals(words[num])) return true;
        }
        return false;
    }
}