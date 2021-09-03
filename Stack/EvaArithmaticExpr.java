import java.util.*;
public class EvaArithmaticExpr {
	static int evaExpression(String expr) {
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < expr.length(); i++) {
			char ch = expr.charAt(i);
			if (Character.isDigit(ch)) {
				s.push(ch - '0');
			} else {
				int a = s.pop();
				int b = s.pop();
				switch (ch) {
				case '+':
					s.push(a + b);
					break;
				case '-':
					s.push(a - b);
					break;
				case '/':
					s.push(a / b);
					break;
				case '*':
					s.push(a * b);
					break;
				}
			}
		}
		return s.pop();
	}
	public static void main(String[] args) {
		String expr = "231*+9-";
		int a = evaExpression(expr);
		System.out.println(a + "is value");
	}
}