/*
[설명]
- 약관 동의 얻어 수집된 1~n번으로 분류되는 개인정보 n개
- 개인정보 보관 유효기간은 약관마다 다름
- 오늘 날짜로 파기해야 할 개인정보 번호들 구하기
- 단, 모든 달은 28일까지 있다고 가정
- 파기해야 할 개인정보 번호 오름차순으로 1차원 배열에 담아 반환
    - 오늘 날짜 today("2022.05.19")
    - 약관 유효기간("A 6") 담은 1차원 배열 terms
    - 개인정보 정보("2021.05.02 A") 담은 1차원 배열 privacies
[접근] LocalDate, HashMap
- 예시
    - 오늘 날짜 : 2022.05.19
    - 1번 : 2021.05.02 + 6 = 2021.11.02 이후
    - 2번 : 2021.07.01 + 12 = 2022.07.01 이후
    - 3번 : 2022.02.19 + 3 = 2022.05.19 이후
    - 4번 : 	2022.02.20 + 3 = 2022.05.20 이후
- HashMap에 약관 종류와 유효기간 저장
- LocalDate로 오늘 날짜와 개인정보 수집 일자를 관리
- 오늘 날짜 >= 개인정보 수집 일자에 약관 유효기간 더한 값 : 파기 ? 보관
- 파기 시엔 정답 리스트에 해당 인덱스 추가
*/
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> termMap = new HashMap<String, Integer>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);
        
        for(int i=0; i<terms.length; i++) {
            String[] term = terms[i].split(" ");
            termMap.put(term[0], Integer.valueOf(term[1]));
        }
        
        for(int i = 0; i<privacies.length; i++) {
            String privacy[] = privacies[i].split(" ");
            LocalDate startDate = LocalDate.parse(privacy[0], formatter);
            LocalDate endDate = startDate.plusMonths(termMap.get(privacy[1]));
            if(todayDate.compareTo(endDate) >= 0) { // todayDate - endDate
                list.add(i+1);
            }
        }
        
        int[] answer = list.stream()
                .mapToInt(i -> i)
                .toArray();
        Arrays.sort(answer);
        return answer;
    }
}