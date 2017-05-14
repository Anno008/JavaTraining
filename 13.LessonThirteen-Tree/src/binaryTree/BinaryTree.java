package binaryTree;

public class BinaryTree {
	public Node root;

	public void add(int element) {
		Node newNode = new Node(element);
		if (root == null) {
			root = newNode;
			return;
		}

		Node current = root;
		Node parent = null;

		while (true) {
			parent = current;
			if (element < current.data) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}

	public boolean find(int element) {
		return find(root, element);
	}

	public boolean delete(int element) {
		if (root == null)
			return false;

		if (root.data == element) {
			root = null;
			return true;
		}

		return delete(root, element);
	}

	public void print() {
		print(root, 0);
	}
	
	private void print(Node node, int tab) {
		for (int i = 0; i < tab; i++)
			System.out.print("\t");

		System.out.println(node.data);

		if (node.right != null)
			print(node.right, tab + 1);
		if (node.left != null)
			print(node.left, tab + 1);
	}

	private boolean find(Node node, int element) {
		if (node == null)
			return false;

		if (node.data == element)
			return true;

		return node.data > element ? find(node.left, element) : find(node.right, element);
	}

	private boolean delete(Node node, int element) {
		if (node.data > element) {
			if (node.left == null)
				return false;
			if (node.left.data == element) {
				node.left = null;
				return true;
			} else
				return delete(node.left, element);
		}

		else {
			if (node.right == null)
				return false;
			if (node.right.data == element) {
				node.right = null;
				return true;
			} else
				return delete(node.right, element);
		}
	}

	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}
}
