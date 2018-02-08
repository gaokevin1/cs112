/*

LinkedListDriver.java
Author: Kevin Gao

This class creates a LinkedList object and tests its various functions
*/

public class LinkedListDriver
{
	public static void main(String[] args)
	{
		// Creates a new LinkedList
		LinkedList l1 = new LinkedList();

		// Adds integers at the head of the LinkedList
		l1.addAtHead(5);
		System.out.println("LinkedList with newly added value at head: ");
		System.out.println(l1.toString());

		l1.addAtHead(10);
		l1.addAtHead(45);
		System.out.println("LinkedList with newly added value at head: ");
		System.out.println(l1.toString());

		l1.addAtHead(30);
		System.out.println("LinkedList with newly added value at head: ");
		System.out.println(l1.toString());
	
		// Adds integers at the tail of the LinkedList
		l1.addAtTail(50);
		System.out.println("LinkedList with newly added value at tail: ");
		System.out.println(l1.toString());

		l1.addAtTail(15);
		System.out.println("LinkedList with newly added value at tail: ");
		System.out.println(l1.toString());

		// Displays the sum of the data in the LinkedList
		System.out.println("Sum of List: " + l1.getSumOfList());

		System.out.println();

		// Adds the integers at the corresponding indexes of the LinkedList
		l1.set(13, 3);
		System.out.println("LinkedList with replaced value at index: ");
		System.out.println(l1.toString());

		l1.set(24, 4);
		System.out.println("LinkedList with replaced value at index: ");
		System.out.println(l1.toString());

		// Displays the sum of the data in the LinkedList
		System.out.println("Sum of List: " + l1.getSumOfList());

		System.out.println();

		// Displays all values stored in LinkedList in reverse order
		System.out.println("List Backwards: ");
		l1.helpPrintBackwards();

		System.out.println(l1.getIth(2));
	}
}