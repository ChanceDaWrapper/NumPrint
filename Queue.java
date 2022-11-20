package hw5;

import java.util.NoSuchElementException;

public class Queue {
	private Node head;
	private Node tail;
	
	//Constructor
	public Queue() {
		head = null;
		tail = null;
	}
	
	//Checking if LinkedList is empty
	public boolean isEmpty() {
		return head == null;
	}
	
	public void enqueue(int value) {
		Node temp = new Node(value);
		
		if (head == null) {
			head = temp;
			tail = temp;
		}
		
		else {
			tail.next = temp;
			tail = temp;
		}
	}
	
	
	public int dequeue() {
		//If Queue is empty, nothing to dequeue
		
		if(isEmpty()) {
			throw new NoSuchElementException("Runtime Exception");
		}
		
		//A queue holding one node
		else if(head == tail) {
			int frontItem = head.n;
			head = null;
			tail = null;
			return frontItem;
		}
		
		//A queue holding many items		
		else {
			int frontItem = head.n;
			head = head.next;
			return frontItem;
			
		}
	}
	
	//Getting the list's head
	public Node getHead() {
		return head;		
	}
} 
