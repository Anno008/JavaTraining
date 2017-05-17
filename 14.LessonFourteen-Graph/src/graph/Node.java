package graph;

import java.util.ArrayList;

public class Node<T> {
	private T data;
	private ArrayList<Node<T>> neighbors = new ArrayList<Node<T>>();

	public Node(T data) {
		this.data = data;
	}

	public void add(Node<T> node) {
		if (neighbors.contains(node))
			return;

		neighbors.add(node);
	}

	public boolean remove(Node<T> node) {
		return neighbors.remove(node);
	}

	public boolean containsNeighbor(Node<T> other) {
		return neighbors.contains(other);
	}

	public ArrayList<Node<T>> getNeighbors() {
		return neighbors;
	}

	public T getData() {
		return this.data;
	}

	@Override
	public String toString() {
		return "Node: " + data;
	}
}
