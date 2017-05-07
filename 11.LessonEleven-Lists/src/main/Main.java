package main;

import list.*;

public class Main {
	public static void main(String[] args) {
		System.out.println("Linked list -----------------");
		NonGenericLinkedList list = new NonGenericLinkedList();
		
		Object p = "Pera";
		list.add(p);
		list.add("Mika");
		list.add("Jhon");
		list.add("Lubo");
		
		list.remove(p);
		list.addFirst("Wick");
		list.addFirst("Alex");
		
		System.out.println(list.size());
		System.out.println("First item " + list.getFirst());
		System.out.println("Last item " + list.getLast());
		System.out.println();
		
		for (Object item : list.getAll()) 
			System.out.println(item);
		
		System.out.println();
		System.out.println("Item at position: 10 " + list.get(10));
		
		System.out.println();
		System.out.println("Queue ----------------");
		Queue que = new Queue();
		que.enqueue("Added first");
		que.enqueue("Added second");
		que.enqueue("Added third");
		
		System.out.println("Queue peek, first item to be served: " + que.peek());
		System.out.println(que.size());
		
		System.out.println("Dequeueing...");
		que.dequeue();
		System.out.println("Queue peek after dequeue: " + que.peek());
		
		System.out.println();
		System.out.println("Stack ----------------");
		Stack stc = new Stack();
		stc.push("Added first");
		stc.push("Added second");
		stc.push("Added third");
		
		System.out.println(stc.size());
		System.out.println("Stack peek, first item to be served: " + stc.peek());
		
		System.out.println("Popping stack...");
		stc.pop();
		
		System.out.println("Stack peek after popping: " + stc.peek());
		
		System.out.println("Stack peek: " + stc.peek());
	}
}
