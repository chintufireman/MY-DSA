class QueueImpl {
	int capacity, front, rear, size;
	int a[];
	public QueueImpl(int capacity) {
		this.capacity = capacity;
		this.front = this.size = 0;
		rear = (capacity - 1);
		this.a = new int[this.capacity];
	}
	boolean isFull(QueueImpl q) {
		if (q.size == q.capacity) {
			return true;
		} else
			return false;
	}
	boolean isEmpty(QueueImpl q) {
		return (q.size == 0);
	}

	public void enqueue(int d) {
		if (isFull(this)) {
			return;
		}
		this.rear = (this.rear + 1) % this.capacity;
		this.a[this.rear] = d;
		this.size = this.size + 1;
		System.out.println(d + "has been enqueued");
	}
	public int dequeue() {
		if (isEmpty(this)) {
			return Integer.MIN_VALUE;
		}
		int data = this.a[this.front];
		this.front = this.front + 1;
		this.size = this.size - 1;
		System.out.println(data + "has been dequeueq");
		return data;
	}
}
public class QueueArrayImpl {
	public static void main(String[] args) {
		QueueImpl q = new QueueImpl(1000);
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		int item = q.dequeue();
		item = q.dequeue();
	}
}