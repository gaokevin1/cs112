Lab 3
=====

### Due Friday, September 8, 2017 - 5:00pm

The goal of this assignment is to practice implementing programs that use the following elements:

- Classes
- Methods
- Complex logic

<!--Conditions (simple if/else)
Expressions (conversions)
Simple class with getters
-->

## Requirements
1. **Part 1 (35 points)**: 
  - Copy your class `ConversionsHelper` to a `lab3` directory and implement the methods specified as follows:
  
	```java
		/**
	 	 * Converts the given hour from the fromTZ (timezone) to the toTZ (timezone).
		 * 
		 * Valid time zones are PST, MST, CST, and EST.
		 * MST is PST + 1
		 * CST is MST + 1
		 * EST is CST + 1
		 *
		 * If fromTZ or toTZ is not a valid time zone the method will return -1.
		 * 
		 * Uses 24 hour clock and accounts for new day.
		 * Hour 22 in PST is hour 1 in EST 
		 * 
		 * Hour may be a valid integer from 0 to 23. If hour is outside of that range 
		 * the method will return -1;
		 *
		 * 
		 * @param hour
		 * @param fromTZ
		 * @param toTZ
		 * @return
		 */
		public int timeZone(int hour, String fromTZ, String toTZ) {
			//TODO: Replace with your code.
			return 0;
		}
	```

	```java
		/**
		 * Calculates total calories burned running given weight in pounds and duration 
		 * of exercise in minutes. 
		 * 
		 * Use the following formulas:
		 * Calories per minute = (.0175) X (MET) X (weight in Kilograms)
		 * MET (Metabolic equivalent of task) = 10 for running (at 6mph) - use this value
		 * Weight in Kg = Weight in pounds / 2.2
		 * 
		 * @param weightInPounds
		 * @param durationInMinutes
		 * @return
		 */
		public double caloriesBurnedRunning(int weightInPounds, int durationInMinutes) {
			//TODO: Replace with your code.
			return 0;
		}
	```
  - Copy your class `ConversionsDriver` to the `lab3` directory and add the following logic at the end of your `main` method.
      * Prompt the user for an hour.
      * Prompt the user for a from TZ.
      * Prompt the user for a to TZ.
      * Print the result of using `timeZone` to convert the user's input to the new hour.
      * Prompt the user for a weight in pounds.
      * Prompt the user for a running duration in minutes.
      * Print the result of using `caloriesBurnedRunning` to convert the user's values to calories.
2. **Part 2 (15 points)**:  Create a class `Counter` that represents a simple tally counter and a class `CounterDriver` that creates two `Counter` objects and tests their methods. `Counter` will have a single `int` data member to keep track of the count. The constructor will initialize the data member to 0. The class will also implement the following methods:
  - `click` - takes no input, returns nothing, and increases the count
  - `getCount` - takes no input and returns the current count
  - `reset` - takes no input, returns nothing, and resets the counter to 0
 
### Submission Requirements

1. For this assignment, you will submit the following files: `Counter.java`, `CounterDriver.java`, `ConversionsHelper.java`, and `ConversionsDriver.java`.

2. Make sure your code follows all requirements in the [Style Guidelines](https://github.com/CS112-F17/notes/blob/master/style.md).

3. Follow the instructions in the [SVN Guide](https://github.com/CS112-F17/notes/blob/master/svn_guide.md) for submitting your solution by the deadline.

4. Make sure you have submitted your work in an SVN directory: `https://www.cs.usfca.edu/svn/<username>/cs112/lab3`

<!--### Grading Rubric

The general rubric we will use to grade your solution may be found here: [Grading Rubric](https://github.com/CS112-S17/notes/blob/master/grading_rubric.md)

For this assignment, your solution must compile, run, produce correct output, be well designed, and follow the [Style Guidelines](https://github.com/CS112-S17/notes/blob/master/style.md).
-->
### Academic Dishonesty

Any work you submit is expected to be your own original work. If you use any web resources in developing your code you are required to cite those resources. The only exception to this rule is code that is posted on the class website. The URL of the resource you used in a comment in your code is fine. If I google even a single line of uncited code and find it on the internet you may get a 0 on the assignment or an F in the class. You may also get a 0 on the assignment or an F in the class if your solution is at all similar to that of any other student.