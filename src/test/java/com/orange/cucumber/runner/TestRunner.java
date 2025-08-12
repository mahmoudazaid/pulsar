// src/test/java/com/orange/cucumber/runner/TestRunner.java
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
  features = "src/test/resources/features",
  glue = "com.orange",
  plugin = {"pretty", "json:target/cucumber.json"},
  tags = "@cart"
)
public class TestRunner extends AbstractTestNGCucumberTests {}
