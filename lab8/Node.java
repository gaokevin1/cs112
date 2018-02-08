/*

Node.java
Author: Kevin Gao

This class holds an Integer as its data.
*/

public class Node
{
	// Data Members
	private Integer data;
	private Node next;

	/**
		* Constructor
	**/
	public Node(Integer data, Node next)
	{
		this.data = data;
		this.next = next;
	}

	public Node(Integer data)
	{
		this(data, null);
	}

	public int getData()
	{
		return this.data;
	}

	public Node getNext()
	{
		return this.next;
	}

	public void setData(Integer data)
	{
		this.data = data;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}

	public String toString()
	{
		return "";
	}
}