package list;

public class Stack {

	private Node head;
	private int size;



	public void push(Object obj) {
		Node newNode = new Node(obj);

		if (head == null)
			head = newNode;
		else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = newNode;
		}
		size++;
	}

	public void pop() {
		if (size == 0)
			return;

		Node temp = head;
		for (int i = 1; i < size; i++) {
			temp = temp.next;
		}
		
		temp = null;
		size--;
	}

	public Object peek() {
		if (size == 0)
			return null;

		Node temp = head;
		for (int i = 1; i < size; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	public int size() {
		return size;
	}

	private class Node {
		public Node next;
		public Object data;

		public Node(Object data) {
			this.data = data;
		}
	}
}
