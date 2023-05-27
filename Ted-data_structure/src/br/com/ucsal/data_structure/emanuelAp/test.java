package br.com.ucsal.data_structure.emanuelAp;

public class test {

	public static void main(String[] args) {
		Tree tree = new Tree();
		// don't put negative elements s2
		Integer[] values = { 7, 2, 1, 8, 9, 8, 7, 3, 0, 91, 10, 6, -1 };

		for (int i = 0; i < values.length; i++) {
			String inserted = tree.insert(values[i]);
			System.out.println(inserted + " " + values[i]);
		}

		// test method printTree
		tree.printTree();
		// test method getElementsLeft
		tree.getElementsLeft();
		// test method getElementsRight
		tree.getElementsRight();
		// test method isLeaf
		System.out.println(tree.isLeaf(tree.root.left.left.left.left));
		// test method size
		System.out.println(tree.size());
		// test function preOrder
		System.out.println(tree.preOrder());
		// test function inOrder
		System.out.println(tree.inOrder());
		// test function posOrder
		System.out.println(tree.posOrder());
		// test method insetNodeRight
		System.out.println(tree.insertNodeRight(10, tree.root));
		// tests of method insert
		System.out.println(tree.insert(101));
		System.out.println(tree.insert(12));
		// test of method isNull
		System.out.println(tree.isNull(null));
		tree.printTree();
		//test of methods remo
		System.out.println(tree.removeLeft(tree.root.left));
		System.out.println(tree.removeRight(tree.root.right));
		tree.printTree();

		// tree.getElementsLeft();
//		tree.getElementsRight();
	}
}
