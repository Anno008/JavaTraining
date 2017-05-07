package main;

import list.NonGenericLinkedList;

public class Main {
	public static void main(String[] args) {
		NonGenericLinkedList list = new NonGenericLinkedList();
		
		Object p = "Pera";
		list.add(p);
		list.add("Mika");
		list.add("Jhon");
		
		list.remove(p);
		
		System.out.println(list.size());
		System.out.println("First item " + list.getFirst());
		System.out.println("Last item " + list.getLast());
		System.out.println();
		
		for (Object item : list.getAll()) 
			System.out.println(item);
		
		
		System.out.println(list.get(10));
	}
}
