/*

LinkedList.java
Author: Kevin Gao

This class manipulates information from Node objects with different methods.
*/

import java.util.ArrayList;

public class LinkedList
{
	// Data Members
	private Node head;
	private int sum;

	/**
		* Constructor
	**/
	public LinkedList()
	{
		head = null;
	}

	public void addAtHead(Integer data)
	{
		// If LinkedList has no previous elements
		if (head == null)
		{
			head = new Node(data);
		}
		else
		{
			// Create new temp Node to store data
			Node temp = new Node(data);
			
			// New node refers to old head
			temp.setNext(head);
			
			// Move head so that it refers to the new node
			head = temp;
		}
	}

	public void addAtTail(Integer data)
	{
		// If LinkedList has no previous elements
		if (head == null)
		{
			head = new Node(data);
		}
		else
		{
			Node temp = new Node(data);
			temp.setNext(null);

			Node last = head;

			// Find where the last Node is on the List
			while (last.getNext() != null)
			{
				last = last.getNext();
			}

			// Set the next value on the list to the new data
			last.setNext(temp);
		}
	}

	public String toString()
	{
		// Data Members
		Node currentNode = head;
		String result = "";

		while (currentNode != null)
		{
			result += currentNode.getData() + "\n";
			currentNode = currentNode.getNext();
		}

		return result;
	}

	public void sum(Node currentNode)
	{	
		// Stop recursion once end of the list is reached
		if (currentNode == null)
		{
			return;
		}
		else
		{
			sum += currentNode.getData();
			currentNode = currentNode.getNext();

			// Recursively keep adding to the sum from all elements of the LinkedList
			sum(currentNode);
		}
	}

	public int getSumOfList()
	{
		// Data Members
		Node currentNode = head;
		sum = 0;

		// Call recursive method to get sum
		sum(currentNode);

		// Return sum
		return sum;
	}

	public void set(Integer data, int index)
	{
		// Data Members
		Node currentNode = head;
		int count = 0;

		// Make sure that the index given is greater than 0 (valid)
		if (index < 0)
		{
			System.out.println("Cannot place data in invalid position.");
		}

		// Keep incrementing down the list till it gets to the index desired
		while (count < index)
		{
			currentNode = currentNode.getNext();
			count++;
		}

		// Sets the element at the current position equal to the data
		currentNode.setData(data);
	}

	public void printElementsBackwards(Node currentNode)
	{	
		// Stop recursion once end of the list is reached
		if (currentNode == null)
		{
			return;
		}
		else
		{
			// Keeps recusively calling method, with the order of Nodes passed through reversed
			printElementsBackwards(currentNode.getNext());
			System.out.println(currentNode.getData());
		}
	}

	public int getIth(int i)
	{
		Node currentNode = head;
		int data = 0;
		int count = 0;

		if (i < 0)
		{
			return 0;
		}

		while (count < i)
		{
			currentNode = currentNode.getNext();
			count++;q
		}

		if (currentNode != null)
		{
			data = currentNode.getData();
		}

		return data;
	}

	public void removeLastN(int n)
	{
		
	}

	public void helpPrintBackwards()
	{
		Node currentNode = head;

		printElementsBackwards(currentNode);
	}
}