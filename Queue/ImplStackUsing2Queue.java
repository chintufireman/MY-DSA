import java.util.*;

public class ImplStackUsing2Queue {
	static class Stack {
		static Queue<Integer> q1 = new LinkedList<Integer>();
		static Queue<Integer> q2 = new LinkedList<Integer>();
		static int curr_size;

		public Stack() {
			curr_size = 0;
		}

		static void push(int data) {
			curr_size = curr_size + 1;

			q2.add(data);

			while (!q1.isEmpty()) {
				q2.add(q1.peek());
				q1.remove();
			}
			Queue<Integer> q = q1;
			q1 = q2;
			q2 = q;
		}
		static void pop() {
			if (q1.isEmpty()) {
				System.out.println("Underflow");
				return;
			}
			q1.remove();
			curr_size--;
		}
		static int top() {
			if (q1.isEmpty()) {
				System.out.println("Underflow");
				return -1;
			}
			return q1.peek();
		}
		static int size() {
			return curr_size;
		}

	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);

		System.out.println("poped " + s.top());
		s.pop();
		System.out.println("popped" + s.top());
		s.pop();
		System.out.println("popped" + s.top());
		s.pop();
	}
}