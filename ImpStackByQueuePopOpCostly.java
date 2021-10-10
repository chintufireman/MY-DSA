import java.util.*;
public class ImpStackByQueuePopOpCostly {
	static class Stack {
		static Queue<Integer> q1 = new LinkedList<>();
		static Queue<Integer> q2 = new LinkedList<>();
		static int curr_size;
		public Stack() {
			curr_size = 0;
		}
		static void push(int data) {
			q1.add(data);
		}
		static void pop() {
			if (q1.isEmpty()) {
				System.out.println("Underflow");
				return;
			}
			while (q1.size() != 1) {
				q2.add(q1.peek());
				q1.remove();
			}

			q1.remove();
			curr_size--;
			Queue<Integer> q = q1;
			q1 = q2;
			q2 = q;
		}
		static int top() {
			if (q1.isEmpty()) {
				System.out.println("Stack Underflow");
				return -1;
			}
			while (q1.size() != 1) {
				q2.add(q1.peek());
				q1.remove();
			}
			int temp = q1.peek();
			q2.add(temp);
			q1.remove();
			Queue q = q1;
			q1 = q2;
			q2 = q;
			return temp;
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
		s.push(4);
		System.out.println("popped " + s.top());
		s.pop();
		System.out.println("popped " + s.top());
		s.pop();
		System.out.println("popped " + s.top());
		s.pop();
		System.out.println("popped " + s.top());
		s.pop();
		s.pop();
	}
}