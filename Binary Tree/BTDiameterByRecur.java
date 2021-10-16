import java.util.*;

public class BTDiameterByRecur {
	static class Node {
		int data;
		Node left, right;
		Node(int item) {
			data = item;
			left = right = null;
		}
	}
	static class BinaryTree {
		Node root;
		BinaryTree() {root = null;}
		BinaryTree(int key) {root = new Node(key);}

		int height(Node node) {
			if (node == null)
				return 0;

			int lheight = height(node.left);
			int rheight = height(node.right);
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}

		int diameter(Node node) {
			if (node == null)
				return 0;
			int lheight = height(node.left);
			int rheight = height(node.right);

			int ldiameter = diameter(node.left);
			int rdiameter = diameter(node.right);

			return Mathm.ax(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
		}


	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.println(tree.diameter(tree.root));
	}

}