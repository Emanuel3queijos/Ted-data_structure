//**//
//
//
//**//
//****&&&&&&&&&&&&&&&&&&&&&&&*********************%*%*%****//https://github.com/mano3queijos
//**//	Emanuel Santos Almeida
//
//
//**//
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
					return insertLeft(node, node.parent);
				}
			} else {
				localNode = localNode.right;
				if (isNull(localNode)) {
					node.parent.right = node;
					return insertRight(node, node.parent);
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
	public String insertRight(Node newNode, Node parent) {
		parent.right = newNode;
		newNode.parent = parent;
		return "Node added to the right";

	}

// method to insert an element left
	public String insertLeft(Node newNode, Node parent) {
		parent.left = newNode;
		newNode.parent = parent;
		return "Node added to the left";

	}

	// method to remove an element right
	public Integer removeRight(Node parent) {
		if (isNull(parent.right)) {
			return -1;
		}
		Integer value = parent.right.value;
		parent.right = null;
		return value;
	}

// method to remove an element left
	public Integer removeLeft(Node parent) {
		if (isNull(parent.left)) {
			return -1; // indicate that there is no element to remove on the left
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
		if (isNull(node)) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}

// method for Check if node is leaf
	public String isLeaf(Node node) {

		if (isNull(node))
			return "the node is null";

		return (isNull(node.left)) && (isNull(node.right)) ? "node " + node.value + " is a leaf"
				: "node " + node.value + " isn't a leaf";

	}

	// method to get elements on the left of the tree

	public void getElementsLeft() {
		getElementsLeft(root.left);

	}

	private void getElementsLeft(Node node) {
		printTree(node, "");

	}

	// method to get elements on the right of the tree

	public void getElementsRight() {
		getElementsRight(root.right);

	}

	private void getElementsRight(Node node) {

		printTree(node, "");

	}

// methods for print the tree
	public void printTree() {
		printTree(root, "  ");
	}

	private void printTree(Node node, String indent) {
		if (isNull(node)) {
			return;
		}

		System.out.println(indent + node.value);

		if (!isNull(node.right)) {
			System.out.println(indent + " │");
			System.out.println(indent + " ├─");
			printTree(node.right, indent + " │ ");
		}

		if (!isNull(node.left)) {
			System.out.println(indent + " │");
			System.out.println(indent + " └─");
			printTree(node.left, indent + "   ");
		}
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		// dont putch negative elements s2
		Integer[] values = { 7, 2, 1, 8, 9, 8, 7, 3, 0, 10, 6, -1 };

		for (int i = 0; i < values.length; i++) {
			String inserted = tree.insert(values[i]);
			System.out.println(inserted + " " + values[i]);
		}

		tree.printTree();

		System.out.println(tree.isLeaf(tree.root.left.left.left.left));
		// tree.getElementsLeft();
//		tree.getElementsRight();
	}

}
