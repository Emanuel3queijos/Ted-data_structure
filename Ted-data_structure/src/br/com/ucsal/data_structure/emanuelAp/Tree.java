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

	// method to insert an element on the tree
	public String insert(Integer value) {
		Node localNode = root;
		Node node = new Node(value);

		if (isNull(root)) {
			root = node;
			return "Value added to the root";
		}

		while (localNode != null) {
			node.parent = localNode;
			if (value == localNode.value) {
				return "The value already exists in the tree, not inserted";
			} else if (value < localNode.value) {
				localNode = localNode.left;
				if (isNull(localNode)) {
					node.parent.left = node;
					return "Node added to the left";
				}
			} else {
				localNode = localNode.right;
				if (isNull(localNode)) {
					node.parent.right = node;
					return "Node added to the right";
				}
			}
		}
		return "Value was not inserted";
	}

// method to check if the node is null
	public boolean isNull(Node node) {
		return node == null;
	}

	// method to insert an element right
	public void insertRight(Integer value, Node parent) {
		Node newNode = new Node(value);
		parent.right = newNode;
		newNode.parent = parent;
	}

// method to insert an element left
	public void insertLeft(Integer value, Node parent) {
		Node newNode = new Node(value);
		parent.left = newNode;
		newNode.parent = parent;
	}

	// method to remove an element right
	public Integer removeRight(Node parent) {
		if (parent.right == null) {
			return -1;
		}
		Integer value = parent.right.value;
		parent.right = null;
		return value;
	}

// method to remove an element left
	public Integer removeLeft(Node parent) {
		if (parent.left == null) {
			return -1; // Indicar que não há elemento para remover à esquerda
		}
		Integer value = parent.left.value;
		parent.left = null;
		return value;
	}

	// method to show the size of the tree
	public Integer size() {
		return size(root);
	}

	private Integer size(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}

// method for Check if node is leaf
	public String isLeaf(Node node) {

		if (isNull(node))
			return "the node is null";

		return (node.left == null) && (node.right == null) ? "node is a leaf" : "node isn't a leaf";

	}

	// method to get elements on the left of the tree

	public void getElementsLeft() {
		getElementsLeft(root.left);

	}

	public void getElementsLeft(Node node) {
		System.out.println(node.value);

		if (!isNull(node.left)) {
			getElementsLeft(node.left);

		}

	}

	public void getElementsRight() {
		getElementsLeft(root.right);

	}

	public void getElementsRight(Node node) {
		System.out.println(node.value);

		if (!isNull(node.right)) {
			getElementsLeft(node.right);

		}

	}

// methods for print the tree
	public void printTree() {
		printTree(root, "  ");
	}

	private void printTree(Node node, String indent) {
		if (node == null) {
			return;
		}

		System.out.println(indent + node.value);

		if (node.right != null) {
			System.out.println(indent + " │");
			System.out.println(indent + " ├─");
			printTree(node.right, indent + " │ ");
		}

		if (node.left != null) {
			System.out.println(indent + " │");
			System.out.println(indent + " └─");
			printTree(node.left, indent + "   ");
		}
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		// dont putch negative elements s2
		Integer[] values = { 2, 7, 2, 1, 8, 9, 8, 7, 3, 0, 10, 6, -1 };

		for (int i = 0; i < values.length; i++) {
			String inserted = tree.insert(values[i]);
			System.out.println(inserted + " " + values[i]);
		}

		tree.printTree();
		tree.getElementsLeft();
	}

}
