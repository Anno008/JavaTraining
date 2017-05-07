package list;

public class GenericList<T> {
	private Node<T> head = null;
	private int size = 0;

	public void add(T obj) {
		Node<T> newNode = new Node<T>(obj);

		if (head == null)
			head = newNode;
		else {
			Node<T> temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = newNode;
		}
		size++;
	}

	public void add(T obj, int index) {
		Node<T> newNode = new Node<T>(obj);

		if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Node<T> temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
		size++;
	}

	public void remove(int index) {
		Node<T> temp = head;
		if (index == 0)
			head = temp.next;
		else {
			for (int i = 0; i < index - 1; i++)
				temp = temp.next;
			temp.next = temp.next.next;
		}
		size--;
	}

	public void remove(T obj) {
		if (head == null)
			return;

		if (head.data.equals(obj))
			head = head.next;
		else {
			Node<T> temp = head;
			while (temp.next != null) {
				if (temp.next.data.equals(obj)) {
					temp.next = temp.next.next;
					break;
				}
				temp = temp.next;
			}
		}
		size--;
	}

	public void removeAll() {
		head = null;
		size = 0;
	}

	public int getLength() {
		return size;
	}

	public Object get(int index) {
		Node<T> temp = head;
		for (int i = 0; i < index; i++)
			temp = temp.next;

		return temp.data;
	}

	@SuppressWarnings("hiding")
	private class Node<T> {
		public T data;
		public Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
}
