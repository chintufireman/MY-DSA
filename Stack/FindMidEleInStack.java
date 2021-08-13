class Stack {

	class DllNode {
		DllNode prev, next;
		int data;
		public DllNode(int data) {
			this.data = data;
		}
	}
	class MyStack {
		DllNode head;
		DllNode mid;
		int count;

	}
	MyStack createStack() {
		MyStack ms = new MyStack();
		ms.count = 0;
		return ms;
	}
	public void push(MyStack ms, int data) {
		DllNode n = new DllNode(data);
		n.next = ms.head;
		n.prev = null;

		ms.count = ms.count + 1;
		if (ms.count == 1) {
			ms.mid = n;
		} else {
			ms.head.prev = n;
			if (ms.count % 2 != 0) {
				ms.mid = ms.mid.prev;
			}
		}
		ms.head = n;
	}
	int pop(MyStack ms) {
		if (ms.count == 0) {
			System.out.println("Stack underflow");
			return -1;
		}
		int item = ms.head.data;

		ms.head = ms.head.next;
		if (ms.head != null) {
			ms.head.prev = null;
		}
		ms.count = ms.count - 1;
		if (ms.count % 2 == 0) {
			ms.mid = ms.mid.next;

		}
		return item;
	}
	int findMiddle(MyStack ms) {
		if (ms.count == 0) {
			System.out.println("Stack is empty");
		}
		return ms.mid.data;

	}

}
public class FindMidEleInStack {
	public static void main(String[] args) {
		Stack ob = new Stack();
		Stack.MyStack ms = ob.createStack();
		/*important thing to remember this is how
		inner classes are initialized*/
		ob.push(ms, 11);
		ob.push(ms, 22);
		ob.push(ms, 33);
		ob.push(ms, 44);
		ob.push(ms, 55);
		ob.push(ms, 66);
		ob.push(ms, 77);

		System.out.println("Item popped is " + ob.pop(ms));
		System.out.println("Item popped is " + ob.pop(ms));
		System.out.println("Middle Element is "
		                   + ob.findMiddle(ms));

	}
}