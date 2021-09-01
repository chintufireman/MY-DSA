class Stack {
	final int max = 100;
	int top;
	char a[] = new char[max];
	Stack() {
		top = -1;
	}
	void push(char data) {
		a[++top] = data;
		System.out.println(data + "pushed");
	}
	char pop() {
		if (top == -1) {
			System.out.println("stack underflow");
			return 0;
		} else {
			char x = a[top];
			--top;
			return x;
		}
	}
	static void reverse(StringBuffer st) {
		int x = st.length();
		Stack s = new Stack();
		for (int i = 0; i < x ; i++ ) {
			s.push(st.charAt(i));
		}
		for (int i = 0; i < x ; i++ ) {
			char ch = s.pop();
			st.setCharAt(i, ch);
		}
	}
}
public class RevStringUsingStack {
	public static void main(String[] args) {
		StringBuffer s = new StringBuffer("GeeksQuiz");
		Stack.reverse(s);
		System.out.println("Reversed string is " + s);

	}
}