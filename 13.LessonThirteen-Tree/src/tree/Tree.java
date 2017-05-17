package tree;

import java.util.ArrayList;

public class Tree<E> {
		private Node<E> root;
		
		public Node<E> add(Node<E> parent, E data) {
			Node<E> newNode = new Node<>(data, parent);
			
			if (parent == null) 
				root = newNode;
			else 
				parent.children.add(newNode);
			
			return newNode;
		}
		
		public Node<E> find(E element) {
			return pronadji(root, element);
		}
		
		private Node<E> pronadji(Node<E> parent, E data) {
			if (parent.data.equals(data)) 
				return parent;
			
			for (Node<E> element : parent.children) {
				Node<E> rezultat = pronadji(element, data);
				if (rezultat != null) 
					return rezultat;
			}
			
			return null;
		}
		
		public void print() {
			if (root != null) {
				print(root, 0);
			}
		}
		
		private void print(Node<E> cvor, int indent) {
			for (int i = 0 ; i < indent; i++) { 
				System.out.print("\t");
			}
			System.out.println(cvor.data);
			for (int i = 0; i < cvor.children.size(); i++) {
				print(cvor.children.get(i), indent + 1);
			}
		}
		
		public boolean remove(Node<E> cvor) {
			if (cvor == root) {
				root = null;
				return true;
			} else {
				return cvor.parent.children.remove(cvor);	
			}
			
		}
		
		@SuppressWarnings("hiding")
		public class Node<E> {
			private E data;
			private Node<E> parent;
			private ArrayList<Node<E>> children = new ArrayList<>();
			
			Node(E data, Node<E> parent) {
				this.data = data;
				this.parent = parent;
			}	
			
			public E getData() {
				return data;
			}
		}
}
