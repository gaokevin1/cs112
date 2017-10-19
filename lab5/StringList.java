/*

StringList.java
Author: Kevin Gao

This class is used to maintain a list of String objects using an array.
*/

/**
 * For full credit, your solution may not use the Arrays class or any
 * of the classes/methods in the Collections library.
 * @author srollins
 *
 */

public class StringList 
{
	/**
	 * TODO: Declare private data members including an array of String.
	 */
	private int count, size;
	private String[] a1;
	
	/**
	 * Construct a new StringList with a default size of 10.
	 */
	public StringList() 
	{
		this.count = 0;
		a1 = new String[10];
		this.size = a1.length;
	}

	/**
	 * Construct a new StringList with size provided by the parameter.
	 * @param size
	 */
	public StringList(int size) 
	{
		this.count = 0;
		a1 = new String[size];
		this.size = a1.length;
	}

	//TODO: Consider one or more private helper methods.

	/**
	 * Add the new item to the end of the list.
	 * 
	 * If the array is full it will be resized.
	 * 
	 * Return true if successful and false otherwise.
	 * @param item
	 * @return
	 */
	public boolean add(String item) 
	{
		// Looks to see where end is and adds String "item" at end
		for (int i = 0; i < size; i++)
		{
			if (a1[i] == null)
			{
				a1[i] = item;
				count++;
				
				// Returns true if adding was successful
				return true;
			}
		}

		// If array is full, resize array and add String "item" at the end
		size++;
			
		String[] newTempArray = new String[size];
   		System.arraycopy(a1, 0, newTempArray, 0, a1.length);

   		a1 = new String[size];
   		System.arraycopy(newTempArray, 0, a1, 0, size);
   		a1[size - 1] = item;
   		count++;

   		// Returns false if resizing occured
		return false;
	}

	/**
	 * Add a new item at the given position.
	 * 
	 * If the position is out of range, return false.
	 * Otherwise, insert the item in the specified position
	 * and return true to indicate success.
	 * 
	 * If the array is full it will be resized.
	 * @param position
	 * @param item
	 * @return
	 */
	public boolean add(int position, String item) 
	{
		// Data Members
		boolean confirm = false;

		// If adding position is less than the size of the array
		if (position < size)
		{
			// Only increase count if position is originally empty
			if (a1[position] == null)
			{
				count++;
			}

			a1[position] = item;
			confirm = true;
		}
		// Otherwise if position is greater than size of array
		else if (position > (size - 1) && position < (size + 1))
		{
			confirm = false;

			// If array is full, resize array and add String "item" at the end
			size++;

			String[] newTempArray = new String[size];
   			System.arraycopy(a1, 0, newTempArray, 0, a1.length);

   			a1 = new String[size];
   			System.arraycopy(newTempArray, 0, a1, 0, size);
   			a1[size - 1] = item;
   			count++;
		}

		// Returns confirm
		return confirm;
	}

	/**
	 * Remove the first instance of item. Make sure to 
	 * shift all other items up to ensure no "empty" spaces in the 
	 * array.
	 * 
	 * If the item does not appear in the array return false, otherwise
	 * return true.
	 * 
	 * @param position
	 * @return
	 */
	public boolean remove(String item) 
	{
		int position = 0;
		boolean contains = false;

		// Searches for desired element and removes it from array
		for (int i = 0; i < size; i++)
		{
			if (a1[i].equals(item) && contains == false)
			{
				position = i;
				a1[i] = null;
				count--;
				size--;
				contains = true;
			}
		}

		// Shifts elements up one spot after removal
		if (contains == true)
		{	
			// Creates new temp array
			String[] newTempArray = new String[size];

			// Shifts elements and removes empty spots
			for (int i = 0; i < a1.length - 1; i++) 
			{
				if (i < position)
				{
					newTempArray[i] = a1[i];
				} 
				else if (i == position)
				{
					newTempArray[i] = a1[i + 1];
				}
				else 
				{
					newTempArray[i] = a1[i + 1];
				}
			}

			// Replaces global array with new temp array elements
			a1 = new String[size];
			System.arraycopy(newTempArray, 0, a1, 0, size);
		}

		// Returns if contains true or false
		return contains;
	}

	/**
	 * Return true if the array contains item and false otherwise.
	 * 
	 * @param item
	 * @return
	 */
	public boolean contains(String item) 
	{
		// Looks to see if any array element equals the String "item";
		for (int i = 0; i < size; i++)
		{
			if (a1[i] != null && a1[i].equals(item))
			{	
				// If found, return true
				return true;
			}
		}

		// If not found, return false
		return false;
	}

	/**
	 * Return the number of valid items in the array.
	 * 
	 * @return
	 */
	public int size() 
	{
		// Returns count
		return count;
	}

	/**
	 * Return true if the list is empty and false otherwise.
	 * @return
	 */
	public boolean isEmpty() 
	{
		// If the length of the array is greater than 0, return false
		if (count > 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Return the index of the given item. 
	 * 
	 * If the item does not exist, return -1;
	 * 
	 * @param item
	 * @return
	 */
	public int indexOf(String item) 
	{
		// Searches for item in array
		for (int i = 0; i < size; i++)
		{
			if (a1[i] == item)
			{
				return i;
			}
		}

		// Return -1 if item not found
		return -1;
	}

	/**
	 * Return the last index of the given item.
	 * 
	 * If the item appears more than once you will return
	 * the index where it appears last.
	 * 
	 * If the item does not exist in the array return -1;
	 * @param item
	 * @return
	 */
	public int lastIndexOf(String item) 
	{
		// Data Members
		int index = -1;

		// Stores last found position of item in array
		for (int i = 0; i < size; i++)
		{
			if (a1[i] == item && i > index)
			{
				index = i;
			}
		}

		// Returns index of item
		return index;
	}

	/**
	 * Return a String representation of the array.
	 * Following is an example of the expected format:
	 * {A,B,C,D,E}
	 * For full credit your solution must iterate over
	 * the array and build the string. 
	 * 
	 * If the list is empty return {}.
	 * 
	 */
	public String toString() 
	{
		String result = "{";

		// Gets elements from array and adds it to the string
		for (int i = 0; i < size; i++)
		{
			if (a1[i] != null && i < size)
			{
				result += a1[i];
			}

			if (a1[i] != null && i < (size - 1))
			{
				result += ",";
			}

		}

		result += "}";

		// Returns result string
		return result;
	}

}