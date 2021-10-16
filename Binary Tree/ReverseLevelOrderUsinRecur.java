import java.util.*;

public class ReverseLevelOrderUsinRecur {


	static class Node {
		int key;
		Node left, right;

		Node(int item) {
			key = item;
			left = right = null;
		}
	}

	static class BinaryTree {
		Node root;
		BinaryTree() {root = null;}
		BinaryTree(int item) {
			root = new Node(item);
		}

		int height(Node root) {
			if (root == null)
				return 0;
			int lheight = height(root.left);
			int rheight = height(root.right);

			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}

		void printCurrentLevel(Node root, int level) {
			if (root == null)
				return;
			if (level == 1)
				System.out.print(root.key + " ");
			else if (level > 1) {
				printCurrentLevel(root.left, level - 1);
				printCurrentLevel(root.right, level - 1);
			}
		}

		void printLevelOrder(Node root) {
			int h = height(root);
			for (int i = h; i > 0 ; i-- ) {
				printCurrentLevel(root, i);
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
		tree.printLevelOrder(tree.root);
	}
}