import java.util.*;

public class ReverseQueueByRecursion {
	static Queue<Integer> queue;

	static Queue<Integer> reverseQueue(Queue<Integer> q) {
		if (q.isEmpty()) {
			return q;
		}
		int front = q.peek();
		q.remove();
		q = reverseQueue(q);
		q.add(front);

		return q;
	}

	static void displayQueue(Queue<Integer> q) {
		if (q.isEmpty())
			return;
		Queue<Integer> temp = q;
		while (!temp.isEmpty()) {
			System.out.print(temp.peek() + " ->");
			temp.remove();
		}
	}
	public static void main(String[] args) {
		queue = new LinkedList<Integer>();
		queue.add(56);
		queue.add(27);
		queue.add(30);
		queue.add(45);
		queue.add(85);
		queue.add(92);
		queue.add(58);
		queue.add(80);
		queue.add(90);
		queue.add(100);
		queue = reverseQueue(queue);
		displayQueue(queue);
	}
}