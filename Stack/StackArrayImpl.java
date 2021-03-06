class Stack {
	static final int max = 1000;
	int a[] = new int[max];
	int top;

	Stack() {
		top = -1;
	}
	boolean push(int x) {
		if (top >= (max - 1)) {
			System.out.println("stack overflow");
			return false;
		} else {
			a[++top] = x;
			System.out.println(x + "pushed");
			return true;
		}
	}

	int pop() {
		if (top < 0) {
			System.out.println("stack underflow");
			return 0;
		} else {
			int x = a[top--];
			return x;
		}
	}
	boolean isEmpty() {
		return (top < 0);
	}

	int peek() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = a[top];
			return x;
		}
	}
}
class StackArrayImpl {
	public static void main(String args[]) {
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() + " Popped from stack");
		s.isEmpty();
		int x = s.peek();
		System.out.println(x);
	}
}