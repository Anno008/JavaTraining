package list;

public class Queue {
	private Node head;
	private int size;

	public void enqueue(Object obj) {
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

	public void dequeue() {
		Node temp = head;
		head = temp.next;
		size--;
	}

	public Object peek() {
		if (size == 0)
			return null;

		return head.data;
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
