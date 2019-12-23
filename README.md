# Testing with JUnit

## Table of contents:
1. [Chapter 1: Getting Started](#Chapter1)
2. [Chapter 2: Writing Well-structured Tests](#Chapter2)


## Chapter 1: Getting Started<a name="Chapter1"></a>

### Why you should busy yourself with unit tests

    * Reducing the defect rate: Unit test serves to build up a safety net to guard your software from regression
    * Improving the code quality: Changing the existing code to make it more readable, thus enhancing it, isn't risky anymore
    * Increasing the development pace: If the technical debt gets too high, the system collapses and development pace slows
    * Enhancing the specification density: A good test suite at hand can be an additional source of information
    * Boosting confidence and courage: Adding new functionality is possible without expecting too much collateral damage
    
### Serving the starter
#### Understanding the nature of a unit test
A unit test is basically a piece of code written by a developer to verify that another piece code works correctly. A unit
 identifies a very small, specific area of behavior and not the implementing code itself. 

#### Writing the first test
Unit tests written with JUnit are grouped by plain Java classes, each of which is called a test case. It is a good idea to
start with the happy path, which is the normal path of execution and, ideally, the general business use case.
An executable JUnit test is a public, nonstatic method that gets annotated with _@Test_ and takes no parameters, the next
step could be a method stub that names a functionality of our component we want to test. To verify the invariables, JUnit 
offers the org.junit.Assert class, which provides a set of static methods to help developers to write so-called self-checking
tests. 

#### Writing test first
Writing tests before the production code even exists is good because the motivation to do it right is different, writing
tests after writing the code is usually done for justification or to silence the conscience and there will be more holes
in the test coverage compared to the test-first approach. This is because the class under test was not designed for testing.
Writing your tests first supports proper separation implicitly. TDD states that once you have picked your first work unit, 
write a test, make it run, and last, make it right. After you're done, start it all over again with the next piece of
functionality.
If you want to write clean code that works ensure that it works first and then take your time and clean it up second. Once 
your component behaves as speciied, ascertain that your production and test code follow the best programming standards you
 can think of. 
 
## Chapter 2: Writing Well-structured Tests<a name="Chapter2"></a>

### The four phases of a unit test