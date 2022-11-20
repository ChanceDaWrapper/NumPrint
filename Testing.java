package hw5;

import java.util.NoSuchElementException;

public class Testing {

	public static void main(String[] args) {
		
		
		//Create a Queue and test if empty
		Queue q = new Queue();
		if(!q.isEmpty()) {
			System.out.println("Test2 FAILURE");
			return;
		}
		
		//Dequeue an empty Queue
		try {
			int value = q.dequeue();
		} catch(NoSuchElementException e) {
			
		} catch(Exception e) {
			System.out.println("Test 2 FAILURE");
			return;
		}
	if(q.getHead() != null) {
		System.out.println("Test2 FAILURE");
		return;
	}
	
	//Enqueue 1 and test that head points to it
	q.enqueue(1);
	if(q.getHead().n != 1) {
		System.out.println("Test2 FAILURE");
		return;
	}
	
	//Dequeue the one and check if head points to null
	int value = q.dequeue();
	if(q.getHead() != null) {
		System.out.println("Test2 FAILURE");
		return;
	}
	
	System.out.println("Test2 SUCCESS");
	}

}
