package list;

public class NonGenericList {
	private Node head = null;
	private int size = 0;

	public void add(Object obj) {
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

	public void add(Object obj, int index) {
		Node newNode = new Node(obj);
		
		if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Node temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
		size++;
	}

	public void remove(int index) {
		Node temp = head;
		if (index == 0)
			head = temp.next;
		else {
			for (int i = 0; i < index - 1; i++)
				temp = temp.next;
			temp.next = temp.next.next;
		}
		size--;
	}

	public void remove(Object obj) {
		if (head == null)
			return;
		
		if (head.data.equals(obj))
			head = head.next;
		else {
			Node temp = head;
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
		Node temp = head;
		for (int i = 0; i < index; i++)
			temp = temp.next;
		
		return temp.data;
	}

	private class Node {
		public Object data;
		public Node next;

		public Node(Object data) {
			this.data = data;
			this.next = null;
		}
	}
}
