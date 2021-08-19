/*
Im quitting or like keeping this program on hold as a very important because
im not able to solve it currently
*/

class KStack {
	int arr[];
	int top[];
	int next[];
	int free;
	int n, k;
	public KStack(int size, int sn) {
		this.n = size;
		this.k = sn;
		this.arr = new int[size];
		this.next = new int[size];
		this.top = new int[sn];
		this.free = 0;
		for (int i = 0; i < sn; i++) {
			top[i] = -1;
		}
		for (int j = 0; j < size - 1 ; j++ ) {
			next[j] = j + 1;
		}
		next[size - 1] = -1;
	}
	boolean isFull() {
		return (free == -1);
	}
	void push(int data, int sn) {
		if (isFull()) {
			System.out.println("Stack Overflow");
		}
		int i = free;
		free = next[i];
		next[i] = top[sn];
		top[sn] = i;
		arr[i] = data;

	}
	int pop(int sn) {
		if (isEmpty(sn)) {
			System.out.println("Stack underflow");
			return Integer.MAX_VALUE;
		}
		// Find index of top item in stack number 'sn'
		int i = top[sn];
		top[sn] = next[i]; // Change top to store next of previous top
// Attach the previous top to the beginning of free list
		next[i] = free;
		free = i;

		// Return the previous top item
		return arr[i];
	}
	boolean isEmpty(int sn) {
		return (top[sn] == -1);
	}

}
class KStackInArray {
	public static void main(String[] args) {
		// Let us create 3 stacks in an array of size 10
		int k = 3, n = 10;

		KStack ks = new KStack(k, n);

		ks.push(15, 2);
		ks.push(45, 2);

		// Let us put some items in stack number 1
		ks.push(17, 1);
		ks.push(49, 1);
		ks.push(39, 1);

		// Let us put some items in stack number 0
		ks.push(11, 0);
		ks.push(9, 0);
		ks.push(7, 0);

		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		System.out.println("Popped element from stack 1 is " + ks.pop(1));
		System.out.println("Popped element from stack 0 is " + ks.pop(0));
	}
}