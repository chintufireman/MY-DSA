class LevelOrderTravUsingRecur {
	static class Node {
		int key;
		Node left, right;
		public Node(int item) {
			this.key = item;
			left = right = null;
		}
	}

	static class BinaryTree {
		Node root;
		public BinaryTree() {
			root = null;
		}
		public BinaryTree(int item) {
			root = new Node(item);
		}

		int height(Node root) {
			if (root == null)
				return 0;
			else {
				int leftheight = height(root.left);
				int rightheight = height(root.right);

				if (leftheight > rightheight)
					return (leftheight + 1);
				else
					return (rightheight + 1);
			}
		}
		void printCurrentLevel(Node root, int l) {
			if (root == null)
				return;
			if (l == 1)
				System.out.print(root.key);
			else if (l > 1) {
				printCurrentLevel(root.left, l - 1);
				printCurrentLevel(root.right, l - 1);
			}
		}
		void printLevelOrderTraversal() {
			int h = height(root);
			int i;
			for (i = 1; i <= h ; i++ ) {
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
		tree.printLevelOrderTraversal();
	}

}