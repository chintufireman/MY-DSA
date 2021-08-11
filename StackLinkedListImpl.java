class StackImpl {
	Node root;

	class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
		}
	}
	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else
			return false;
	}
	public void push(int data) {
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
		} else {
			Node temp = root;
			root = newNode;
			newNode.next = temp;
		}
	}
	public int pop() {
		int popped = Integer.MIN_VALUE;
		if (root == null) {
			System.out.println("Stack underflow");

		} else {
			popped = root.data;
			root = root.next;
		}
		return popped;
	}
	public int peek() {
		if (root == null) {
			System.out.println("Stack empty");
			return Integer.MIN_VALUE;
		}

		else
			return root.data;
	}
}
public class StackLinkedListImpl {
	public static void main(String[] args) {
		StackImpl s = new StackImpl();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		int pop = s.pop();
		System.out.println(pop + "has been popped");
		int peek = s.peek();
		System.out.println(peek);
	}
}