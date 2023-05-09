import java.util.*;

/*
[설명]
- 길이가 N인 숫자 입력받고 각 자릿수 다 더하기
- 1 < N < 100
[접근]
- 입력받을 숫자가 길이가 100이면 long이나 int로 저장 불가함. String으로 받아야 함
- String으로 받아서 char형 배열로 변환한 후, 각 원소 다 더할 때 숫자로 바꿔 더하기
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += cNum[i] - '0';
        }
        System.out.println(sum);
    }
}

