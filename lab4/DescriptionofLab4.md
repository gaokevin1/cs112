Lab 4
=====

### Due Friday, September 15, 2017 - 5:00pm

The goal of this assignment is to practice implementing programs that use the following elements:

- Iteration
- ArrayLists

## Requirements
1. **Part 1 (35 points)**:
  - Create a class `StringManipulations` that will provide several helper methods for manipulating Java `String` objects.
  - Implement the following methods:
  
	```java
	/**
	 * Returns a count of the number of times the character
	 * c appears in the String original.
	 * 
	 * Example: "hello there", 'e' -> 3
	 * Example: "hello there", 'z' -> 0
	 * 
	 * @param original
	 * @param c
	 * @return
	 */
	public int countChars(String original, char c) {
		//TODO: Replace with your code.
		return -1;
	}
	
	/**
	 * Returns the length of the longest word in a given sentence.
	 * 
	 * Example: "I love CS" returns 4 (length of 'love')
	 * Example: "Hi, there!" returns 6 (length of 'there!')
	 * 
	 * Any whitespace character (spaces, tabs, etc) separates words.
	 * For full credit, solution may *only* use the following methods:
	 * String .length()
	 * String .charAt(index)
	 * Character.isWhitespace(character)
	 * 
	 * @param original
	 * @return
	 */
	public int longestWord(String original) {
		//TODO: Replace with your code.
		return -1;
	}
	```
  
  - Create a class `StringManipulationsDriver`. Create an instance of `StringManipulations` and test the methods `countChars` and `longestWord` by calling each method at least three times with different input parameters and printing the result.

2. **Part 2 (15 points)**: Implement a program that reads the contents of a text file, stores each word in an `ArrayList`, sorts the list, then prints the  contents in order smallest to largest and largest to smallest.
  - Create a class `Sorter.java` with only a `main` method.
  - The logic of the `main` method will be as follows:
    * Create a new `ArrayList` of `String` to store the words in the file.
    * Open a file called `words.txt`. You *must* use this filename.
    * Read in the file a line at a time. Assume that each line contains one word.
    * Store each line in the `ArrayList`.
    * Sort the list. You may use the following to sort the list: `Collections.sort(words);`. This assumes that `words` is the name of your `ArrayList` variable. You will also need to import `java.util.Collections;`.
    * Print the contents of the list, one word on each line, in order from smallest to largest.
    * Print the contents of the list, one word on each line, in order from largest to smallest. *For full credit you may not use `Collections.reverse`.*
  - Given the following file words.txt:
  
```
I
Love
Computer
Science
```
 The output of your program will be as follows:

```
lab3 srollins$ java Sorter
Alphabetical A-Z:
Computer
I
Love
Science
    
Alphabetical Z-A:
Science
Love
I
Computer
```

 
### Submission Requirements

1. For this assignment, you will submit the following files: `StringManipulations.java`, `StringManipulationsDriver.java`, and `Sorter.java`.

2. Make sure your code follows all requirements in the [Style Guidelines](https://github.com/CS112-F17/notes/blob/master/style.md).

3. Follow the instructions in the [SVN Guide](https://github.com/CS112-F17/notes/blob/master/svn_guide.md) for submitting your solution by the deadline.

4. Make sure you have submitted your work in an SVN directory: `https://www.cs.usfca.edu/svn/<username>/cs112/lab4`

### Academic Dishonesty

Any work you submit is expected to be your own original work. If you use any web resources in developing your code you are required to cite those resources. The only exception to this rule is code that is posted on the class website. The URL of the resource you used in a comment in your code is fine. If I google even a single line of uncited code and find it on the internet you may get a 0 on the assignment or an F in the class. You may also get a 0 on the assignment or an F in the class if your solution is at all similar to that of any other student.