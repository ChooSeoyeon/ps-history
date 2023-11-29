import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashSet<String> nonDuplicateReport = new HashSet<>(List.of(report));
        HashMap<String, HashSet<String>> reportHistory = new HashMap<>(); // key : 신고 당한 사람, value : 신고한 사람들
        HashMap<String, Integer> reportMailHistory = new HashMap<>(); // key : 신고 처리 메일 받은 사람, value : 메일 받은 횟수
        for (String id : id_list) {
            reportHistory.put(id, new HashSet<>());
            reportMailHistory.put(id, 0);
        }
        for (String r : nonDuplicateReport) {
            String[] tokens = r.split(" ");
            String reporter = tokens[0];
            String target = tokens[1];

            Set<String> reporters = reportHistory.get(target);
            reporters.add(reporter);
        }
        for (String target : reportHistory.keySet()) {
            Set<String> reporters = reportHistory.get(target);
            if (reporters.size() >= k) {
                for (String reporter : reportHistory.get(target)) {
                    reportMailHistory.put(reporter, reportMailHistory.get(reporter) + 1);
                }
            }
        }
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            Integer num = reportMailHistory.get(id_list[i]);
            answer[i] = num;
        }
        return answer;
    }
}