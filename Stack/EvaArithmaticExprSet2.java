import java.util.*;
public class EvaArithmaticExprSet2 {
	static int evaExpression(String s) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				continue;
			} else if (Character.isDigit(c)) {
				int n = 0;
				while (Character.isDigit(c)) {
					n = n * 10 + (int)(c - '0');
					i++;
					c = s.charAt(i);
				}
				i--;
				stack.push(n);
			} else {
				int a = stack.pop();
				int b = stack.pop();
				switch (c) {
				case '+':
					stack.push(b + a);
					break;
				case '-':
					stack.push(b - a);
					break;
				case '*':
					stack.push(b * a);
					break;
				case '/':
					stack.push(b / a);
					break;

				}
			}
		}
		return stack.pop();
	}
	public static void main(String[] args) {
		String exp = "100 200 + 2 / 5 * 7 +";
		System.out.println(evaExpression(exp));
	}
}