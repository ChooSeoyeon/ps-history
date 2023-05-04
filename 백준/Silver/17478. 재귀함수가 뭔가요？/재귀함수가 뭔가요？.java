import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
[설명]
- 문자열 찍기
[접근]
- 완전탐색 : 재귀
*/
public class Main {
    static String start = "\"재귀함수가 뭔가요?\"";
    static String cont = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static String cont2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static String cont3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    static String fin = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String fin2 = "라고 답변하였지.";
    static int n; // 반복 횟수

    public static void print_line(int lv, String str) {
        for(int i=0; i<lv; i++) {
            System.out.print("____");
        }
        System.out.println(str);
    }

    public static void recur(int level) {
        print_line(level, start);
        if(level==n) { // 종료 조건
            print_line(level, fin);
            print_line(level, fin2);
            return;
        }
        print_line(level, cont);
        print_line(level, cont2);
        print_line(level, cont3);
        recur(level+1); // 다음 단계
        print_line(level, fin2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recur(0);
    }
}