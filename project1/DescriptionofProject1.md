Project 1
=========

### Due Friday, September 22, 2017 - 5:00pm

The goal of this project is to implement a program that maintains a database of movie information and reviews. You will use the following features:

- Classes
- Methods
- File Input
- Iteration
- `ArrayList`

You will implement four classes as part of this assignment. `Movie` will track information about one `Movie`. `MovieList` will maintain a list of `Movie` and provide methods to find information about the collection of `Movie` objects, including the highest and lowest budget; shortest and longest duration; average duration, budget, and IMDB score; and all `Movie` objects with an IMDB score over a threshold. The `MovieListBuilder` will create a `MovieList` by reading information about many movies from a text file.

### `Movie`

- **Data Members** - A `Movie` should have *at least* the following data members:
    * `title` - a `String` representing the title
    * `budget` - a `long` representing the movie's budget
    * `duration` - an `int` representing the movie's duration
    * `imdbScore` - a `double` representing the movie's IMDB score
- **Methods** - `Movie` will support a constructor that takes initial values for all data members,`get` methods for all data members and a `toString` method that returns a `String` of the following format: `<title> - Budget: $<budget> IMDB score: <imdbScore> Length: <long/average/short>` See requirement below regarding the length.
    * Example: `WALL·E  - Budget: $180000000 IMDB score: 8.4  Length: average`
    * Example: `The Silence of the Lambs  - Budget: $19000000 IMDB score: 8.6  Length: long`

### `MovieList`

- **Data Members** - A `MovieList` should have *at least* the following data members:    
    * `movies` - An `ArrayList` containing objects of type `Movie`.
 
- **Methods** - The `MovieList` will implement a default constructor and the following methods:
    * `public void addMovie(Movie movie)` - Takes as input a `Movie` object and adds it to the `ArrayList` of `Movie` in the `MovieList`.
    * `public String toString()` - Returns a string representation of the `MovieList`. Each line of the `String` will contain information about a single `Movie` in the format returned by the `Movie.toString` method. An example follows:
      	
      	```
		Avatar  - Budget: $237000000 IMDB score: 7.9  Length: long
		Harry Potter and the Half-Blood Prince  - Budget: $250000000 IMDB score: 7.5  Length: long
		Sanctuary; Quite a Conundrum  - Budget: $200000 IMDB score: 5.4  Length: short
		```
		
    * `public double averageBudget()` - Returns the average budget of all `Movie` obects in the `MovieList`.
    * `public double averageDuration()` - Returns the average duration of all `Movie` obects in the `MovieList`.
    * `public double averageScore()` - Returns the average imdbScore of all `Movie` obects in the `MovieList`.
    * `public String titleHighestBudget()` - Returns the title of the `Movie` with the largest budget.
    * `public String titleLowestBudget()` - Returns the title of the `Movie` with the smallest budget.
    * `public String titleShortestDuration()` - Returns the title of the `Movie` with the shortest duration.
    * `public String titleLongestDuration()` - Returns the title of the `Movie` with the longest duration.
    * `public ArrayList<Movie> scoreGreaterThan(double score)` - Takes as input a score and returns a list of all `Movie` objects that have an imdbScore *greater than* the score passed as input.

### `MovieListBuilder`

The `MovieListBuilder` will create a new `MovieList` from a [CSV file](https://en.wikipedia.org/wiki/Comma-separated_values). We will be using the CSV file provided in the Kaggle IMDB 5000 dataset. 

<!-- 
(https://www.kaggle.com/deepmatrix/imdb-5000-movie-dataset). 
-->

The first line of the CSV file describes the columns of the data and will be exactly as follows:

```
color,director_name,num_critic_for_reviews,duration,director_facebook_likes,actor_3_facebook_likes,actor_2_name,actor_1_facebook_likes,gross,genres,actor_1_name,movie_title,num_voted_users,cast_total_facebook_likes,actor_3_name,facenumber_in_poster,plot_keywords,movie_imdb_link,num_user_for_reviews,language,country,content_rating,budget,title_year,actor_2_facebook_likes,imdb_score,aspect_ratio,movie_facebook_likes
```

Subsequent lines will provide actual values for the data specified by the first line. Here is a complete example of a valid file:

```
color,director_name,num_critic_for_reviews,duration,director_facebook_likes,actor_3_facebook_likes,actor_2_name,actor_1_facebook_likes,gross,genres,actor_1_name,movie_title,num_voted_users,cast_total_facebook_likes,actor_3_name,facenumber_in_poster,plot_keywords,movie_imdb_link,num_user_for_reviews,language,country,content_rating,budget,title_year,actor_2_facebook_likes,imdb_score,aspect_ratio,movie_facebook_likes
Color,James Cameron,723,178,0,855,Joel David Moore,1000,760505847,Action|Adventure|Fantasy|Sci-Fi,CCH Pounder,Avatar ,886204,4834,Wes Studi,0,avatar|future|marine|native|paraplegic,http://www.imdb.com/title/tt0499549/?ref_=fn_tt_tt_1,3054,English,USA,PG-13,237000000,2009,936,7.9,1.78,33000
Color,David Yates,375,153,282,10000,Daniel Radcliffe,25000,301956980,Adventure|Family|Fantasy|Mystery,Alan Rickman,Harry Potter and the Half-Blood Prince ,321795,58753,Rupert Grint,3,blood|book|love|potion|professor,http://www.imdb.com/title/tt0417741/?ref_=fn_tt_tt_1,973,English,UK,PG,250000000,2009,11000,7.5,2.35,10000
Color,Thomas L. Phillips,13,82,120,84,Joe Coffey,785,,Comedy|Horror|Thriller,Julianna Pitt,Sanctuary; Quite a Conundrum ,133,1111,John Lucas,,nudity|party|pirate|swimsuit|three word title,http://www.imdb.com/title/tt2049518/?ref_=fn_tt_tt_1,8,English,USA,,200000,2012,98,5.4,16.0,424
```

:warning: Do not download the original dataset from Kaggle. I have cleaned the data to make it easier for your program to parse. 

Download the revised data set here: [movie_metadata.csv](https://raw.githubusercontent.com/CS112-F17/projects/master/resources/movie_metadata.csv) Depending on your browser, you should be able to do something like File > Save Page As. Navigate to your project1 directory and save the file as "movie_metadata.csv". *Make sure to use this file name.* 

:warning: Do not modify the file downloaded in any way. If you change the formatting then your program will work for the modified format and will not work for our test cases (which may result in a 0!). This means you should **not** open the file in Excel and then save it. If you want to view the file contents in Excel or another program it is highly advised that you *make a copy* of the file and open the copy in Excel.

Your `MovieListBuilder` class will contain a default constructor and one method defined as follows:

```
public MovieList buildMovieList(String filename)
```
The logic of the method will be as follows:

1. Instantiate a new `MovieList`.
2. Create a `File` with the given `filename`.
3. Create a new `Scanner` to read input from the file created in step 2. If a `FileNotFoundException` is generated, return `null`.
4. Specify that that `Scanner` will `useDelimiter(",|\n")`. This indicates that the newline character as well as the comma (,) will separate tokens read by the `Scanner`.
5. Read in the first line and ignore it.
6. As long as there are additional lines in the file:
  - Use the `Scanner` `next` method to read in all data from the next line.
  - If appropriate, create a new `Movie` containing the data specified. See requirement below.
  - Add the `Movie` to the `MovieList`.
7. Return the `MovieList`.
 
### `Driver`

The `Driver` will implement the `main` method.

It must take as a command line parameter the name of the file to be processed. It will be run as follows: `project1 srollins$ java Driver test.csv` where `test.csv` may be replaced by another file name.

The logic of the method will be as follows:

1. If the file name parameter is not present, print an error message and exit the program.
2. Create a new `MovieListBuilder`.
3. Invoke the `buildMovieList` method and save the `MovieList` returned in a temporary variable.
4. If the `MovieList` is `null` (for example, because the file was not found), print an error message and exit the program.
5. Display the string `All Movies:`. 
6. Use the `MovieList.toString` method to display the entire `MovieList`.
7. Display the result of the `titleLowestBudget` method in a string formatted as follows: `Lowest budget: <title>`. 
8. Display the result of the `titleLongestDuration` method in a string formatted as follows: `Longest duration: <title>`. 
9. Display the result of the `titleHighestBudget` method in a string formatted as follows: `Highest budget: <title>`. 
10. Display the result of the `titleShortestDuration` method in a string formatted as follows: `Shortest duration: <title>`. 
11. Display the result of the `averageScore` method in a string formatted as follows: `Average score: <score>`. The output will have two numbers to the right of the decimal.
12. Display the result of the `averageBudget` method in a string formatted as follows: `Average budget: <budget>`. The output will have two numbers to the right of the decimal.
13. Display the result of the `averageDuration` method in a string formatted as follows: `Average duration: <duration>`. The output will have two numbers to the right of the decimal.
14. Display the string `Movies with IMDB score greater than 8:`
15. Use iteration and the `Movie.toString` method to display information about all `Movie` objects returned when invoking the `scoreGreaterThan` method with an input of 8.
16. Display the string `Movies with IMDB score greater than 9:`
17. Use iteration and the `Movie.toString` method to display information about all `Movie` objects returned when invoking the `scoreGreaterThan` method with an input of 9.


Example output follows:

```
All Movies:
Avatar  - Budget: $237000000 IMDB score: 7.9  Length: long
Harry Potter and the Half-Blood Prince  - Budget: $250000000 IMDB score: 7.5  Length: long
Sanctuary; Quite a Conundrum  - Budget: $200000 IMDB score: 5.4  Length: short
Pirates of the Caribbean: On Stranger Tides  - Budget: $250000000 IMDB score: 6.7  Length: long
Memento  - Budget: $9000000 IMDB score: 8.5  Length: average
The Shawshank Redemption  - Budget: $25000000 IMDB score: 9.3  Length: long

Lowest budget: Sanctuary; Quite a Conundrum 
Longest duration: Avatar 
Highest budget: Harry Potter and the Half-Blood Prince 
Shortest duration: Sanctuary; Quite a Conundrum 
Average score: 7.55
Average budget: 128533333.33
Average duration: 134.00
Movies with IMDB score greater than 8:
	Memento  - Budget: $9000000 IMDB score: 8.5  Length: average
	The Shawshank Redemption  - Budget: $25000000 IMDB score: 9.3  Length: long
Movies with IMDB score greater than 9:
	The Shawshank Redemption  - Budget: $25000000 IMDB score: 9.3  Length: long
```

### Other Requirements and Hints

1. As you are developing and testing the program create a small file `test.csv` with just a few movies in it. 
2. The `Movie.toString` method will append the "long", "short", or "average" depending on the value of the `duration` variable. If the `duration` is greater than 120 then the `String` will read "long". If the `duration` is less than 90 then the `String` will read "short". Otherwise, it will read "average". It is recommend you perform this check in the `toString` method.
3. As you read data from the file you will need to *ignore* many fields. This simply means that you should use the `next` method to read in the information, but you won't actually use it.
4. The csv file is encoded using [UTF-8](https://en.wikipedia.org/wiki/UTF-8) encoding. To make sure you are reading the data using the correct encoding specify UTF-8 when you create your `Scanner` object as follows: `Scanner input = new Scanner(file, "UTF-8")`. This will likely be embedded in a try-with-resources.
5. For some rows, the csv file has missing data. Though `Scanner` has convenient methods like `nextInt` to read in an integer, if the data is missing and the cell is blank then `nextInt` will generate an exception. To deal with this situation, you will read in all fields using the `next` method, which returns a `String`. For `duration`, `budget`, and `imdbScore` you will then need to convert the `String` to the appropriate type (`int`, `long`, or `double`). The algorithm you will use as follows:
  - Use `next` to read in the data and save to a `String` variable.
  - If the `String` is *not* empty (hint: `str.trim().isEmpty()`) then convert it to the appropriate type using `Integer.parseInt`, `Long.parseLong` or `Double.parseDouble` as appropriate.
6. After reading in a full line (make sure to read every column!), create a `Movie` object *only* if the duration is not 0 and the budget is not 0 and the score is not 0 and the title is not empty. If any value is 0 or empty, do not create a `Movie` object - just go on to the next line.

### Submission Requirements

1. For this assignment, you will submit four files: `Movie.java`, `MovieList.java`, `MovieListBuilder.java`, and `Driver.java`

2. Make sure your code follows all requirements in the [Style Guidelines](https://github.com/CS112-F17/notes/blob/master/style.md).

3. Follow the instructions in the [SVN Guide](https://github.com/CS112-F17/notes/blob/master/svn_guide.md) for submitting your solution by the deadline.

4. Make sure you have submitted your work in an SVN directory: `https://www.cs.usfca.edu/svn/<username>/cs112/project1`

<!--### Grading Rubric

The general rubric we will use to grade your solution may be found here: [Grading Rubric](https://github.com/CS112-S17/notes/blob/master/grading_rubric.md)
-->
### Academic Dishonesty

Any work you submit is expected to be your own original work. If you use any web resources in developing your code you are required to cite those resources. The only exception to this rule is code that is posted on the class website. The URL of the resource you used in a comment in your code is fine. If I google even a single line of uncited code and find it on the internet you may get a 0 on the assignment or an F in the class. You may also get a 0 on the assignment or an F in the class if your solution is at all similar to that of any other student.
