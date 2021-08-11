class LinkedList {
	Node head;

	class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	void push(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
	}

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print("->" + temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
	void sortList() {
		int count[] = {0, 0, 0};
		Node ptr = head;
		while (ptr != null) {
			count[ptr.data]++;
			ptr = ptr.next;
		}
		int i = 0;
		ptr = head;
		while (ptr != null) {
			if (count[i] == 0) {
				i++;
			} else {
				ptr.data = i;
				--count[i];
				ptr = ptr.next;
			}
		}
	}
}

class Sort0s1s2sLinkedList {
	public static void main(String args[]) {
		LinkedList llist = new LinkedList();

		/* Constructed Linked List is 1->2->3->4->5->6->7->
		   8->8->9->null */
		llist.push(0);
		llist.push(1);
		llist.push(0);
		llist.push(2);
		llist.push(1);
		llist.push(1);
		llist.push(2);
		llist.push(1);
		llist.push(2);

		System.out.println("Linked List before sorting");
		llist.printList();

		llist.sortList();

		System.out.println("Linked List after sorting");
		llist.printList();
	}
}

