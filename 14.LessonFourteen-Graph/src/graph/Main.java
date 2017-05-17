package graph;

public class Main {
	public static void main(String[] args) {
		Node<String> berlin = new Node<String>("Berlin");
		Node<String> prague = new Node<String>("Prague");
		Node<String> vienna = new Node<String>("Vienna");
		Node<String> warsaw = new Node<String>("Warsaw");
		Node<String> budapest = new Node<String>("Budapest");
		Node<String> belgrade = new Node<String>("Belgrade");

		belgrade.add(budapest);
		
		budapest.add(vienna);
		budapest.add(prague);

		vienna.add(prague);

		prague.add(berlin);
		prague.add(warsaw);
		prague.add(budapest);

		berlin.add(prague);
		berlin.add(warsaw);

		warsaw.add(prague);
		warsaw.add(berlin);

		Graph<String> g = new Graph<String>();
		System.out.println("All nodes");
		g.print(belgrade);

		System.out.println("\nPath from belgrade to berlin");
		for (Node<String> n : g.findPath(belgrade, berlin))
			System.out.println(n);
	}
}
