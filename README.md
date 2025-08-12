**Ho To Run:**

* Make sure Java 8 is installed
* make sure Mave is insrtalled
* to run the tests use this command 
  * `mvn test -Dcucumber.options="src/test/resources/features/{feature file name}.feature:{ScienarioLine}"`
  
  
**Frame Work Architecture:**
* this framework combination between Page Object Model and BDD
* Hook has been split into 2 files to run some code before/After the test is start and the other before each Scenario
* For the locator we use ENUM