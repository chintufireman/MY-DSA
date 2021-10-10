import java.util.*;

public class ImplKQueuesInArray {
	public static void main(String[] args) {
		int k = 3, size = 6;
		Queues q = new Queues(size, k);
		q.enqueue(1, 2);
		System.out.println("popped " + q.dequeue(2));
		System.out.println("popped" + q.dequeue(2));
	}
}

class Queues {
	int front[];
	int rear[];
	int next[];
	int size;
	int free;
	int arr[];
	int k;

	public Queues(int size, int k) {
		this.size = size;
		this.k = k;
		this.arr = new int[size];
		this.front = new int[k];
		this.rear = new int[k];
		this.next = new int[size];

		for (int i = 0; i < k; i++) {
			this.front[i] = this.rear[i] = -1;
		}
		for (int i = 0; i < size - 1; i++ ) {
			this.next[i] = i + 1;
		}
		this.next[size - 1] = -1;
		this.free = 0;
	}
	boolean isEmpty(int k) {
		return front[k] == -1;
	}
	boolean isFull() {
		return free == -1;
	}
	void enqueue(int data, int k) {
		if (isFull()) {
			System.out.println("queue overflow");
			return;
		}
		int nextFree = next[free];

		if (isEmpty(k))
			front[k] = rear[k] = free;
		else {
			next[rear[k]] = free;
			rear[k] = free;
		}
		next[free] = -1;
		arr[free] = data;
		free = nextFree;
	}
	int dequeue(int k) {
		if (isEmpty(k)) {
			System.out.println("queue underflow");
			return -1;
		}

		int frontIndex = front[k];
		front[k] = next[frontIndex];
		next[frontIndex] = free;
		free = frontIndex;
		return arr[frontIndex];
	}

}
