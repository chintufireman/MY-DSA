import java.util.*;

public class BTDiamByRecurOptimized {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		Height h = new Height();

		System.out.println(tree.diameterOpt(tree.root, h));
	}

	static class Height {
		int h;
	}

	static class Node {
		int key;
		Node left, right;

		Node(int item) {
			key = item;
		}
	}

	static class BinaryTree {
		Node root;


		int diameterOpt(Node root, Height height) {
			Height lh = new Height(), rh = new Height();
			if (root == null) {
				height.h = 0;
				return 0;
			}

			int ldiameter = diameterOpt(root.left, lh);
			int rdiameter = diameterOpt(root.right, rh);
			height.h = Math.max(lh.h, rh.h) + 1;
			return Math.max(lh.h + rh.h + 1,
			                Math.max(ldiameter, rdiameter));

		}


	}
}