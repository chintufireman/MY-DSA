import java.util.*;

public class ReverseLvlByDeque {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.printLevelOrder(tree.root);

	}

	static class Node {
		int key;
		Node left, right;
		Node(int item) {key = item;}
	}
	static class BinaryTree {
		Node root;
		BinaryTree() {root = null;}
		BinaryTree(int item) {root = new Node(item);}

		void printLevelOrder(Node node) {
			Queue<Node> Q = new LinkedList<Node>();
			Stack<Node> S = new Stack<Node>();
			while (Q.isEmpty() == false) {
				/* Dequeue node and make it root */
				node = Q.peek();
				Q.remove();
				S.push(node);

				/* Enqueue right child */
				if (node.right != null)
					// NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
					Q.add(node.right);

				/* Enqueue left child */
				if (node.left != null)
					Q.add(node.left);
			}

			// Now pop all items from stack one by one and print them
			while (!S.empty()) {
				node = S.peek();
				System.out.print(node.key + " ");
				S.pop();
			}
		}
	}

}