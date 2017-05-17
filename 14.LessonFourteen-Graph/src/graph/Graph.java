package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Graph<T> {
	HashSet<Node<T>> processed;
	ArrayDeque<Node<T>> discovered;

	public void print(Node<T> start) {
		discovered = new ArrayDeque<Node<T>>();
		processed = new HashSet<Node<T>>();

		discovered.add(start);

		while (discovered.size() > 0) {
			Node<T> temp = discovered.poll();
			if (processed.contains(temp))
				continue;

			System.out.println(temp);
			processed.add(temp);
			discovered.addAll(temp.getNeighbors());
		}
	}

	public ArrayList<Node<T>> findPath(Node<T> origin, Node<T> destination) {
		discovered = new ArrayDeque<Node<T>>();
		processed = new HashSet<Node<T>>();
		ArrayList<Node<T>> path = new ArrayList<Node<T>>();
		HashMap<Node<T>, Node<T>> previous = new HashMap<Node<T>, Node<T>>();

		discovered.add(origin);
		while (discovered.size() > 0) {
			Node<T> temp = discovered.poll();

			if (processed.contains(temp))
				continue;

			for (Node<T> n : temp.getNeighbors())
				if (!processed.contains(n))
					previous.put(n, temp);

			processed.add(temp);
			discovered.addAll(temp.getNeighbors());

			if (temp.getData().equals(destination.getData())) {
				Node<T> np = temp;
				while (!np.equals(origin)) {
					path.add(np);
					np = previous.get(np);
				}
				System.out.println(np);
			}
		}
		Collections.reverse(path);
		return path;
	}
}
