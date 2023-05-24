//******************************
//
//https://github.com/mano3queijos
//
//******************************
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
			return "value added to the root";
		}

		while (localNode != null) {
			node.parent = localNode;
			if (value == localNode.value) {
				return "the value already exists in the tree, not inserted";
			}

		}

		return "valor não inserido";

	}

	public boolean isNull() {
		if (root == null) {
			return true;
		}
		return false;
	}

}
