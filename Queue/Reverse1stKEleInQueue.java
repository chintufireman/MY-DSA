import java.util.*;

public class Reverse1stKEleInQueue {
	static void reverseKQueue(Queue<Integer> q, int k) {
		Stack<Integer> s = new Stack<>();
		if (q.isEmpty() || k > q.size() - 1) {
			return;
		}
		for (int i = 0; i < k ; i++ ) {
			s.add(q.peek());
			q.remove();

		}
		while (!s.isEmpty()) {
			q.add(s.peek());
			s.pop();
		}
		for (int i = 0; i < q.size() - k ; i++ ) {
			q.add(q.peek());
			q.remove();
		}

	}

	static void print(Queue<Integer> q) {
		Queue<Integer> temp = q;
		while (!temp.isEmpty()) {
			System.out.print(temp.peek() + "->");
			temp.remove();
		}
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(60);
		queue.add(70);
		queue.add(80);
		queue.add(90);
		queue.add(100);
		int k = 5;
		reverseKQueue(queue, k);
		print(queue);
	}
}