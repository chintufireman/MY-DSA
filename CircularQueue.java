import java.util.*;

public class CircularQueue {
	int rear, front, size;
	ArrayList<Integer> queue = new ArrayList<>();

	public CircularQueue(int size) {
		this.size = size;
		this.front = -1;
		this.rear = -1;
	}
	public void enQueue(int data) {
		if ((front == 0 && rear == size - 1) || (rear == (front - 1))) {
			System.out.println("Queue overflow");
			return;
		} else if (front == -1) {
			front = 0;
			rear = 0;
			queue.add(rear, data);
		} else if (rear == (size - 1) && front != 0) {
			rear = 0;
			queue.set(rear, data);
		} else {
			rear = rear + 1;
			if (front <= rear) {
				queue.add(rear, data);
			} else
				queue.set(rear, data);
		}
	}
	public int deQueue() {
		if (front == -1) {
			System.out.println("Queue underflow");
			return -1;
		}
		int temp = queue.get(front);
		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (front == size - 1) {
			front = 0;
		} else {

			front = front + 1;
		}
		return temp;
	}
	public void displayQueue() {
		if (front == -1) {
			System.out.println("queue underflow");
			return;
		}
		if (rear >= front) {
			for (int i = front; i <= rear ; i++ ) {
				System.out.println(queue.get(i));
				System.out.print(" ");
			}
		} else {
			for (int i = front; i <= size - 1; i++) {
				System.out.println(queue.get(i));
				System.out.print(" ");
			}

			for (int i = 0; i <= rear; i++) {
				System.out.println(queue.get(i));
				System.out.println(" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		CircularQueue q = new CircularQueue(5);
		q.enQueue(14);
		q.enQueue(22);
		q.enQueue(13);
		q.enQueue(-6);

		q.displayQueue();

		int x = q.deQueue();

		if (x != -1) {
			System.out.print("Deleted value = ");
			System.out.println(x);
		}

		x = q.deQueue();
		if (x != -1) {
			System.out.print("Deleted value = ");
			System.out.println(x);
		}

		q.displayQueue();
		q.enQueue(9);
		q.enQueue(20);
		q.enQueue(5);

		q.displayQueue();
		q.enQueue(20);
	}

}