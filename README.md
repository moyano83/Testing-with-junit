# Testing with JUnit

## Table of contents:
1. [Chapter 1: Getting Started](#Chapter1)
2. [Chapter 2: Writing Well-structured Tests](#Chapter2)
3. [Chapter 3: Developing Independently Testable Units](#Chapter3)


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
your component behaves as specified, ascertain that your production and test code follow the best programming standards you
 can think of. 
 
## Chapter 2: Writing Well-structured Tests<a name="Chapter2"></a>

### The four phases of a unit test
#### Using a common test structure
The common structure of a unit test is as follows:

    * The first section establishes the SUT's (system under test) related state prior to any test activities, it is also
     called the fixture of a test
    * After the fixture has been initialized, it is time to invoke that functionality of the SUT this is just a single method
    * The last section veriies that the outcome actually matches the speciied behavior
    * A test should leave its environment in the same condition as it was in before the execution of the test
    
The above structure is often referred as setup, exercise, verify and teardown. This common structure and clean separation
 increases readability tremendously.
 
#### Setting up the fixture
A test's fixture setup includes all the activities necessary to prepare a well-defined input state on which a component's
 functionality is invoked.
JUnit offers the possibility to execute a common test setup implicitly with the annotation _@Before_ applied to a public, 
nonstatic method that has no return value and arguments.

#### What goes up must come down
JUnit supports implicit teardown in conjunction with the _@After_ annotation. Alternatively, one would have to handle this 
with a try-finally and ensure that the clean-up gets done even if a test fails but this decreases readability since it 
creates an overhead of inner blocks.

#### Verification
a unit test verifies only one behavior at a time. We define behavior as the outcome of a component's functionality applied
 under given circumstances.
 
### Choosing the next functionality to test
#### Start with the happy path
The happy path delivers the highest business value, and gets us closer to the component's expected capabilities. In addition 
corner case code can be integrated easily into a main scenario most of the time.
Sometimes, it may also be suitable to begin with a low hanging fruit (very simple functionality) because you probably gain
 some insights on the more complex tasks ahead.
 
#### Conclude with corner cases
It is necessary to recognize the corner cases and cover them with tests, one might limit the allowed attribute values in a
 class to an appropriate range. But how can we make sure that we have tested all the necessary corner cases? the acronym
*CORRECT* is a checklist that one can go through to localize potential hotspots. *CORRECT* stands for:

    * Conformance: Does a value conform to an expected format?
    * Ordering: Is a set of values ordered appropriately?
    * Range: Is a value within a minimum and maximum definition?
    * Reference: Is there a reference to anything external that isn't controlled by your component (notifications)?
    * Existence: Does the value exist (for example not null, non-zero, present in a set, and so on)?
    * Cardinality: Are there exactly enough values?
    * Time (absolute and relative): Is everything happening in order? At the right time? In time? 
    
#### After the war
In rare cases, it may happen that we think we are done with all the boundary conditions, but have still overlooked
something due to a conceptual error or the like. At this development stage, it can be valuable to use a code coverage
tool to ind out if we have missed any paths of execution. Such gaps may be an indication of a more fundamental problem in
your test case called _faults of omission_. Code coverage can detect holes and, therefore, potential trouble with respect
 to our component's correctness but completeness of coverage doesn't ensure that we have tested every potential behavior. 
 
### Getting the test names right
#### Test prefix
A good test name has to have clarity, simplicity, and density of expression.

#### Behavior-expressing patterns
A test name should express a speciic requirement and should include the expected input or state and the expected result
for that input or state. The resulting pattern of this proposal separates the different responsibilities with underscores, 
and looks like this: `UnitOfWork_StateUnderTest_ExpectedBehavior`. The idea is that anyone should get a fairly good
 understanding of the component's behavior simply by browsing through the method names of a component's test case.
However, people claim that unit test names ought to focus on the scenario. A popular approach in this area starts with the 
_should_ prefix to express the test's intention, resulting in something as follows
`shouldExpectedBehaviorWhenUnitOfWorkOnStateUnderTest`.
A one liner is simply not able to cope with the information density of a complex behavior, that's what 
_behavior-driven-development_ (BDD) tries to solve. BDD test writing style consists of tests in a textual Given-When-Then
 structure, which maps each line to an annotated Java test step method. The different step types can be mapped to our 
 four -phase test structure like this: given = > setup, when => exercise, and then => verify.
 
#### Reducing names to the essentials
BDD turnaround was to remind us that we already have the complete behavior specification in our unit test so we don't need to
force this information redundantly into the test's name. Test cases share some common setup state which can be omitted in
the name, leaving us with the structure `UnitOfWork_StateUnderTest` (the underscore can be replaced with a more fluent
 readable version using words like _to_, _with_, or _if_ to get a better binding between the segments).
 
 
## Chapter 3: Developing Independently Testable Units<a name="Chapter3"></a>