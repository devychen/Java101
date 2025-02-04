# Lab 7

### Main contents
- [the Java Stream API](http://tutorials.jenkov.com/java-functional-programming/streams.html)
- **the corresponding lecture on java 8 features**

## Exercise 1: Lambda expressions - filename finder using properties

In the current version of your `FilenameFinder`, you used `equals()` to decide when a file name matches the parameter `entryName`. Please rewrite your `FilenameFinder` and use a 
`Predicate` as a criteria for file name selection. If you do not trust your own version of `FilenameFinder`, you may use the provided class.

Change the signature of the `findEntryAtPath` method to:

~~~java
public static List<String> findEntryAtPath(String path, Predicate<String> matcher)
~~~

and replace the `equals()` method call with a `Predicate`.

Add a JUnit test class and assess the `findEntryAtPath` method with at least the 
following searches:

* Number of entries named "file1.txt" in directory "src/test/resources/"
* Number of entries which end in ".txt" in directory "src/test/resources/"
* Number of entries in "src/test/resources/" which contain "ile"
* Number of entries in "src/test/resources/" which have an 'f' in the beginning

## Exercise 2: Stream filter using predicates

Complete the method `public List<Word> search(Predicate<Word> needle)` in class `CorpusSearch`.

Add a JUnit test class and assess the `search` method with at least the 
following searches:

* Search number of all words representing word form "in" 
* Search number of all words representing POS tag "APPR" and form "für"
* Search number of all words where the POS tag begins with "VV"
* Search number of all words where the POS tag is "APPR" and the form is either "für" or "in"

## Notes:
We will only accept solutions that use lambda expressions (exercise 1) and lambda expressions and streams (exercise 2). 
Don't forget to comment and add/update JavaDoc (tests do not require JavaDoc)

