import java.util.*;
public class CircularQueueLLImpl {

	static class CircularQueue {
		Node front, rear;
		CircularQueue() {
			front = rear = null;
		}
	}
	static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static void enqueue(CircularQueue q, int data) {
		Node temp = new Node(data);
		if (q.front == null)
			q.front = temp;
		else
			q.rear.next = temp;
		q.rear = temp;
		q.rear.next = q.front;
	}

	static int dequeue(CircularQueue q) {
		if (q.front == null) {
			System.out.println("queue underflow");
			return Integer.MIN_VALUE;
		}
		int value;
		if (q.front == q.rear) {
			value = q.front.data;
			q.front = null;
			q.rear = null;
		} else {
			value = q.front.data;
			q.front = q.front.next;
			q.rear.next = q.front;
		}
		return value;
	}
	static void displayeQueue(CircularQueue q) {
		if (q.front == null) {
			System.out.print("queue underflow");
			return;
		}
		Node temp = q.front;
		while (temp.next != q.front) {
			System.out.print(temp.data + " ->");
			temp = temp.next;
		}
		System.out.print(temp.data);
		System.out.println();
	}
	public static void main(String[] args) {
		CircularQueue q = new CircularQueue();
		enqueue(q, 1);
		enqueue(q, 2); enqueue(q, 3); enqueue(q, 4);

		displayeQueue(q);

		System.out.println(dequeue(q));
		System.out.println("->" + dequeue(q));

		displayeQueue(q);

		enqueue(q, 5); enqueue(q, 6);

		displayeQueue(q);
	}
}