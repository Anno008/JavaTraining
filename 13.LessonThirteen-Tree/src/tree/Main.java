package tree;

public class Main {
	public static void main(String[] args){
		Tree<String> tree = new Tree<>();
		
		tree.add(null, "Root");
		
		Tree<String>.Node<String> root = tree.find("Root");
		tree.add(root, "First gen child 1");
		tree.add(root, "First gen child 2");
		tree.add(root, "First gen child 3");
		
		Tree<String>.Node<String> child = tree.find("First gen child 3");
		tree.add(child, "Second gen child 1");
		tree.add(child, "Second gen child 2");
		tree.add(child, "Second gen child 3");
		
		Tree<String>.Node<String> child2 = tree.find("First gen child 2");
		tree.add(child2, "Second gen child 1");
		tree.add(child2, "Second gen child 2");
		tree.add(child2, "Second gen child 3");
		
		tree.remove(child2);
		
		tree.print();
	}
}
