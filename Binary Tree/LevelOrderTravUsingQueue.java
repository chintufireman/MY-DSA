import java.util.*;

public class LevelOrderTravUsingQueue {
	static class Node {
		int key;
		Node left, right;
		public Node(int key) {
			this.key = key;
			left = right = null;
		}
	}
	static class BinaryTree {
		Node root;
		public BinaryTree() {
			root = null;

		}
		public BinaryTree(int item) {
			root  = new Node(item);
		}
		void printLevelOrder() {
			Queue<Node> queue = new LinkedList<Node>();

			queue.add(root);
			while (!queue.isEmpty()) {
				Node temp = queue.poll();
				System.out.print(temp.key);

				if (temp.left != null )
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.printLevelOrder();
	}
}