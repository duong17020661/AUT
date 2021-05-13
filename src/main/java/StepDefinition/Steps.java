package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Steps {
    WebDriver driver;

    @Given("^open the Firefox and launch the application$")
    public void open_the_Firefox_and_launch_the_application() throws Throwable
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Downloads\\geckodriver.exe");
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/v4");
    }

    @When("^enter the Username and Password$")
    public void enter_the_Username_and_Password() throws Throwable
    {
        driver.findElement(By.name("uid")).sendKeys("username12");
        driver.findElement(By.name("password")).sendKeys("password12");
    }

    @Then("^reset the credential$")
    public void Reset_the_credential() throws Throwable
    {
        driver.findElement(By.name("btnReset")).click();
    }

}
