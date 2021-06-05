package Tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/java/Features/MyTest.feature",glue= "StepDefinition")
public class Runner extends AbstractTestNGCucumberTests
{

}