Lab 2
=====

### Due Friday, September 1, 2017 - 5:00pm

The goal of this assignment is to practice implementing programs that use the following elements:

- Classes
- Command line input and output
- Mathematical operations
- Conditional operations

<!--Conditions (simple if/else)
Expressions (conversions)
Simple class with getters
-->

## Requirements
1. **Part 1 (15 points)**: 
  - Create a class `Movie`. 
      * A `Movie` has the following data members:
          * `title` - a `String` denoting the title of the movie
          * `duration` - an `int` denoting the length of the movie
          * `budget` - a `long` denoting the budget of the movie
      * Implement two constructors:
          * A constructor that takes as input `title`, `duration`, and `budget`.
          * A constructor that takes as input `title` and `duration` and sets `budget` to be a default value of 0.
      * Implement get and set methods for every data member. 
      * Implement a `toString` method that prints a nicely formatted string describing the movie, e.g., "The Silence of the Lambs  - Budget: $19000000 Length: long". Following "Length" should be either long, short, or average. Long is a duration greater than 120 minutes, short is a duration less than 90 minutes, and all other durations will be average.
  - Create a class `MovieDriver`. 
      * Instantiate **three** different `Movie`, each with a different title and duration. At least one should be have a default budget of 0 and one should not. 
      * Use the `toString` method to print the information about each object.
2. **Part 2 (35 points)**: 
  - Create a class `ConversionsHelper`. The class will contain the following methods:
      * `public double bitsToBytes(int bits)` - takes as input a number of bits and converts to bytes. A byte is 8 bits.
      * `public double celsiusToFahrenheit(int tempInCel)` - takes as input a temperature in celsius and converts to fahrenheit. Tfar = Tcel * 9/5 + 32.
      * `public int dayOfYear(int day, String month)` - takes as input a day and month and returns the day number of the year. Assume the year is 2017 (not a leap year). January 1 is day number 1. February 1 is day number 32. December 31 is day number 365. Return -1 if the day is invalid for the specified month or if the month is not a valid month. The parameter month must be the complete month spelled out beginning with a capital letter. 
  - Create a class `ConversionsDriver`. The logic in the `main` method of `ConversionsDriver` will be as follows:
      * Create an instance of `ConversionsHelper`
      * Prompt the user for a number of bits
      * Print the result of using the `bitsToBytes` method to convert the user's value to bytes.
      * Prompt the user for a temperature in celsius.
      * Print the result of using `celsiusToFahrenheit` to convert the user's value to fahrenheit.
      * Prompt the user for a day.
      * Prompt the user for a month.
      * Print the result of using `dayOfYear` to convert the user's input to the day number.

 
### Submission Requirements

1. For this assignment, you will submit the following files: `Movie.java`, `MovieDriver.java`, `ConversionsHelper.java`, and `ConversionsDriver.java`.

2. Make sure your code follows all requirements in the [Style Guidelines](https://github.com/CS112-F17/notes/blob/master/style.md).

3. Follow the instructions in the [SVN Guide](https://github.com/CS112-F17/notes/blob/master/svn_guide.md) for submitting your solution by the deadline.

4. Make sure you have submitted your work in an SVN directory: `https://www.cs.usfca.edu/svn/<username>/cs112/lab2`

<!--### Grading Rubric

The general rubric we will use to grade your solution may be found here: [Grading Rubric](https://github.com/CS112-S17/notes/blob/master/grading_rubric.md)

For this assignment, your solution must compile, run, produce correct output, be well designed, and follow the [Style Guidelines](https://github.com/CS112-S17/notes/blob/master/style.md).
-->
### Academic Dishonesty

Any work you submit is expected to be your own original work. If you use any web resources in developing your code you are required to cite those resources. The only exception to this rule is code that is posted on the class website. The URL of the resource you used in a comment in your code is fine. If I google even a single line of uncited code and find it on the internet you may get a 0 on the assignment or an F in the class. You may also get a 0 on the assignment or an F in the class if your solution is at all similar to that of any other student.