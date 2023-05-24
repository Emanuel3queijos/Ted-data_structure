//******************************
//
//https://github.com/mano3queijos
//
//******************************
package br.com.ucsal.data_structure.emanuelAp;

public class Tree {
	public class Node {

		public Node left;
		public Node right;
		public Integer value;

		public Node(Integer value) {
			this.value = value;
			left = null;
			right = null;
		}

	}

	public Node root;

	public Tree() {
		root = null;
	}

	public boolean insert(Integer value) {

		Node localNode = root;

		Node node = new Node(value);

		if (isNull()) {
			root = node;
			return true;
		}

		while (localNode != null) {

		}

		return false;

	}

	public boolean isNull() {
		if (root == null) {
			return true;
		}
		return false;
	}

}
