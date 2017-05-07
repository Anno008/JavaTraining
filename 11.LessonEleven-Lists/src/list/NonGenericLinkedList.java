package list;


public class NonGenericLinkedList {
	private Node head, tail = null;
	private int size;

	public void add(Object item) {
		Node temp = new Node(item);

		if (size == 0)
			head = temp;
		else
			tail.next = temp;

		tail = temp;
		size++;
	}
	
	public Object get(int index) {
		if(index > size || index < 0)
			return null;
		
		Node temp = head;
		for (int i = 0; i < index; i++)
			temp = temp.next;
		
		return temp.data;
	}
	
	public Object exists(int index)
	{
		return get(index) == null ? false : true;
	}

	public void remove(Object item) {
		if (head == null)
			return;

		if (head.data.equals(item))
			head = head.next;
		else {
			Node temp = head;
			while (temp.next != null) {
				if (temp.next.data.equals(item))
					temp.next = temp.next.next;

				temp = temp.next;
			}
		}
		
		size--;
	}

	public Object[] getAll() {
		Object[] temp = new Object[size];
		Node firstItem = head;

		for (int i = 0; i < size; i++) {
			temp[i] = firstItem.data;
			firstItem = firstItem.next;
		}

		return temp;
	}

	public int size() {
		return size;
	}

	public Object getFirst() {
		return head.data;
	}

	public Object getLast() {
		return tail.data;
	}

	private class Node {
		public Node next;
		public Object data;

		public Node(Object next) {
			this.data = next;
			next = null;
		}
	}
}
