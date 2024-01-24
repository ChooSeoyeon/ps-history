import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
[설명]
- 양수, 플러스, 마이너스로 이뤄진 식에 괄호 적절히 쳐서 식의 값 최소로 만드는 프로그램 만들기
[접근] 그리디
- 앞에서부터 보며 연산을 진행하는데, 뺄셈과 덧셈 연산자가 연달아 나오면 그 부분 계산 괄호로 묶은 거로 처리해서 계산해주기
	- 이때, 괄호로 묶은 거로 처리는 매우 간단함. 덧셈 연산자만 뺄셈 연산자로 바꿔 계산하면 됨
	1) 55-50 = 5
	2) 55-(50+40) = 5-45 = -35
		(!뺄셈과 덧셈이 연달아 나왔어) -> 뺼셈이 나올 땐 표시해두고 바로 다음 계산 때 참고하기에 알 수 있음
	3) 55-(50+40+50) = -35-50 = -85
		(!덧셈이 더 연달아 나왔어) -> 아까전에 덧셈이었는데 뺄셈이 된 친구를 뺄셈인 것 양 표시해두면 다음 계산 때 참고할 수 있음
	4) 55-(50+40+50)-1 = -85-1 = -86
		(뺄셈이 나왔을 땐 부호를 바꾸지 않고 그대로 계산)
	5) 55-(50+40+50)-1+50 = -86-50
- 각 단계의 최적의 해 : 이전 연산이 뺄셈이었다면 덧셈은 뺄셈으로 바꾼다.(최적의 괄호 치기) 다른 경우는 모두 연산 그대로 진행한다.
- 전체의 최적의 해 : 연산 끝까지 다 했으면 반복 종료
[메모]
- 식의 값이 최소로 나오기 위해선 빼는 게 크고 더하는 게 작아야 함
- 빼는 게 크려면, 뺄셈 연산자와 덧셈 연산자가 연달아 나오는 곳을 괄호로 묶는 포인트로 두면 됨
	- 덧셈 뒤에선 묶어도 값에 변화가 없기에 덧셈과 뒤에 무언가 연달아 나오는 꼴은 고려 x
		1 + (2 - 3) + (2 + 4) = 1 + 2 - 3 + 2 + 4
	- 뺄셈 뒤에선 묶었을 때 값의 변화가 있음
		- 뺄셈 뒤에 연달아 뺄셈이 나오면 값이 괄호로 묶었을 때 오히려 값이 커짐
			1 - (2 - 3) > 1 - 2 - 3
		- 뺄셈 뒤에 연달아 덧셈이 나왔을 때만 괄호로 묶었을 때 값이 작아짐
			1 - (2 + 3) - (1 + 5) < 1 - 2 + 3 - 1 + 5
- 괄호가 세 수 이상을 감싸는 것도 문제 x (뺄셈 뒤에 덧셈 연산자가 두개, 세개, 네개든 연달아 오면 거기까지 괄호쳐주면 됨)
- 괄호가 중첩되어 있는 상황은 가정 x (곱셈, 나눗셈이 없어서 중첩으로 인한 이득은 볼 수 없음)
- 그리디 쓸 수 있는 이유 : 앞에서부터 괄호 치는 게 최적의 해를 찾을 수 있는 방법이라서?
*/
public class Main {
	private static int solution(String exp) {
		Queue<Integer> tempOperand = new LinkedList<>();
		Queue<Integer> operand = new LinkedList<>();
		Queue<Character> operator = new LinkedList<>();
		for (char c : exp.toCharArray()) {
			if (c == '+' || c == '-') {
				int number = 0;
				while (!tempOperand.isEmpty()) {
					number += (int)Math.pow(10, tempOperand.size() - 1) * tempOperand.poll();
				}
				operand.add(number);
				operator.add(c);
			} else {
				tempOperand.add(c - '0');
			}
		}
		int number = 0;
		while (!tempOperand.isEmpty()) {
			number += (int)Math.pow(10, tempOperand.size() - 1) * tempOperand.poll();
		}
		operand.add(number);

		int result = 0;
		boolean isMinus = false;
		int sign = 1;
		int size = operator.size() + operand.size();
		for (int i = 0; i < size; i++) {
			if (i % 2 != 0) {
				char c = operator.remove();
				if (c == '-') {
					sign = -1;
					isMinus = true;
				} else {
					if (isMinus) {
						sign = -1;
						isMinus = true;
					} else {
						sign = 1;
						isMinus = false;
					}
				}
			} else {
				int num = operand.remove();
				result += num * sign;
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String exp = br.readLine();
		System.out.println(solution(exp));

		br.close();
	}
}