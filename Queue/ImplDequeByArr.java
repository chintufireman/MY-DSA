import java.util.*;
class Deque {
	static final int MAX = 100;
	int arr[];
	int f;
	int r;
	int size;

	public Deque(int size) {
		arr = new int[MAX];
		this.f = -1;
		this.r = 0;
		this.size = size;
	}

	boolean isFull() {
		return ((f == 0 && r == size - 1) || f == r + 1);
	}
	boolean isEmpty() {
		return (f == -1);
	}

	void insertFront(int data) {
		if (isFull()) {
			System.out.println("Queue overflow");
			return;
		}
		if (f == -1) {
			f = 0;
			r = 0;
		} else if (f == 0) {
			f = size - 1;
		} else {
			f = f - 1;
		}
		arr[f] = data;
	}
	void insertRear(int data) {
		if (isFull()) {
			System.out.println("Queue overflow");
			return;
		}
		if (f == -1) {
			f = 0;
			r = 0;
		} else if (r == size - 1) {
			r = 0;
		} else
			r = r + 1;
		arr[r] = data;
	}

	void deleteFront() {
		if (isEmpty()) {
			System.out.println("Stack underflow");
			return ;
		}
		if (f == r) {
			f = -1;
			r = -1;
		} else {
			if (f == size - 1)
				f = 0;
			else
				f = f + 1;

		}

	}
	void deleteRear() {
		if (isEmpty()) {
			System.out.println("Stack underflow");
			return;
		}
		if (f == r) {
			f = -1;
			r = -1;
		} else if (r == 0) {
			r = size - 1;
		} else
			r = r - 1;
	}

	int getRear() {
		// check whether Deque is empty or not
		if (isEmpty() || r < 0) {
			System.out.println(" Underflow\n");
			return -1 ;
		}
		return arr[r];
	}
	int getFront() {
		// check whether Deque is empty or not
		if (isEmpty()) {
			System.out.println(" Underflow");
			return -1 ;
		}
		return arr[f];
	}

}
public class ImplDequeByArr {
	public static void main(String[] args) {
		Deque dq = new Deque(5);

		System.out.println("Insert element at rear end  : 5 ");
		dq.insertRear(5);

		System.out.println("insert element at rear end : 10 ");
		dq.insertRear(10);

		System.out.println("get rear element : " + dq.getRear());

		dq.deleteRear();
		System.out.println("After delete rear element new rear become : " +
		                   dq.getRear());

		System.out.println("inserting element at front end");
		dq.insertFront(15);

		System.out.println("get front element: " + dq.getFront());

		dq.deleteFront();

		System.out.println("After delete front element new front become : " +
		                   +  dq.getFront());
	}
}