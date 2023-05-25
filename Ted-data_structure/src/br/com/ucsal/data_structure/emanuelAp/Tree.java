package br.com.ucsal.data_structure.emanuelAp;

public class Tree {
	public class Node {
		public Node parent;
		public Node left;
		public Node right;
		public Integer value;

		public Node(Integer value) {
			this.value = value;
			left = null;
			right = null;
			parent = null;
		}
	}

	public Node root;

	public Tree() {
		root = null;
	}

	public String insert(Integer value) {
		Node localNode = root;
		Node node = new Node(value);

		if (isNull()) {
			root = node;
			return "Value added to the root";
		}

		while (localNode != null) {
			node.parent = localNode;
			if (value == localNode.value) {
				return "The value already exists in the tree, not inserted";
			} else if (value < localNode.value) {
				localNode = localNode.left;
				if (localNode == null) {
					node.parent.left = node;
					return "Node added to the left";
				}
			} else {
				localNode = localNode.right;
				if (localNode == null) {
					node.parent.right = node;
					return "Node added to the right";
				}
			}
		}
		return "Value was not inserted";
	}

	public boolean isNull() {
		return root == null;
	}

	// THE BEST LOGIC I CAN MAKE for this
	public void printTree() {
		printTree(root, "  ");
	}

	private void printTree(Node node, String indent) {
		if (node == null) {
			return;
		}

		System.out.println(indent + node.value);

		if (node.left != null) {
			System.out.println(indent + " │");
			System.out.println(indent + " ├─");
			printTree(node.left, indent + " │ ");
		}

		if (node.right != null) {
			System.out.println(indent + " │");
			System.out.println(indent + " └─");
			printTree(node.right, indent + "   ");
		}
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		Integer[] values = { -7, 7, 2, 1, 8, 9, 8, 7, 3, 0 };

		for (int i = 0; i < values.length; i++) {
			String inserted = tree.insert(values[i]);
			System.out.println(inserted + " " + values[i]);
		}

		tree.printTree();

	}
}
