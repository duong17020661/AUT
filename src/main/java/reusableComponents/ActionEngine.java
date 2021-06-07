package reusableComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import testBase.DriverFactory;
import testBase.ExtentFactory;

public class ActionEngine {

	//Customized sendkeys method-> To log sendkeys message for every occ.
	public void sendKeys_custom(WebElement element, String fieldName, String valueToBeSent) {
		try {
			element.sendKeys(valueToBeSent);
			//log success message in exgent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "");
		} catch (Exception e) {
			//log failure in extent
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "");
		}
	}

	public void uploadFile_custom(WebElement element, String fieldName, String valueToBeSent) {
		try {
			element.sendKeys(valueToBeSent);
<<<<<<< HEAD
			DriverFactory.getInstance().getDriver().findElement(By.id("terms")).click();
			DriverFactory.getInstance().getDriver().findElement(By.id("send")).click();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "");
=======
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Tải tệp tin : "+valueToBeSent);
>>>>>>> 21fbe2ae0a9c0d6103b884be7203e210639c6c46
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "");
		}
	}

	//Customized sendkeys method-> To log sendkeys message for every occ.
	public void selectedCheckbox_custom(WebElement element, WebElement checkElement, String fieldName, int value) {
		try {
			if (element.isSelected() && value == 0) {
				checkElement.click();
			}
			else if (element.isSelected() && value == 1) {
//				checkElement.click();
			}
			else if (!element.isSelected() && value == 0) {
//				checkElement.click();
			}
			else if (!element.isSelected() && value == 1) {
				checkElement.click();
			}
			//log success message in exgent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "");
		} catch (Exception e) {
			//log failure in extent
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "");
		}
	}

	//custom click method to log evey click action in to extent report
	public void click_custom(WebElement element, String fieldName) {
		try {
			element.click();
			//log success message in exgent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "");
		} catch (Exception e) {
			//log failure in extent
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, ""+e);
		}
	}


<<<<<<< HEAD
	//clear data from field
	public void clear_custom(WebElement element,String fieldName) {
		try {
			element.clear();
			Thread.sleep(250);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "");
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "");

		} 
	}

=======
>>>>>>> 21fbe2ae0a9c0d6103b884be7203e210639c6c46
	//custom mouseHover 
	public void moveToElement_custom(WebElement element,String fieldName){
		try{
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			Actions actions = new Actions(DriverFactory.getInstance().getDriver());		
			actions.moveToElement(element).build().perform();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "");
			Thread.sleep(1000);
		}catch(Exception e){
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "");

		}
	}


	//Select dropdown value value by visibleText
	public void selectDropDownByVisibleText_custom(WebElement element, String fieldName, String ddVisibleText) throws Throwable {
		try {
			Select s = new Select(element);
			s.selectByVisibleText(ddVisibleText);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "");
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "");
		}
	}

<<<<<<< HEAD
	//Select dropdown value value by value
	public void selectDropDownByValue_custom(WebElement element, String fieldName, String ddValue) throws Throwable {
		try {
			Select s = new Select(element);
			s.selectByValue(ddValue);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "");
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "");
		}
	}
=======
>>>>>>> 21fbe2ae0a9c0d6103b884be7203e210639c6c46

	//String Asserts
	public void assertEqualsString_custom(String expvalue, String actualValue, String locatorName) throws Throwable {
		try {
<<<<<<< HEAD
			if(actualValue == null) {
				ExtentFactory.getInstance().getExtent().log(Status.PASS, "");
=======
			if(expvalue.equals(actualValue) == true) {
				ExtentFactory.getInstance().getExtent().log(Status.PASS, "String Assertion is successful on field "+ locatorName + " Expected value was: "+ expvalue + " actual value is: "+actualValue);
>>>>>>> 21fbe2ae0a9c0d6103b884be7203e210639c6c46
			}else {
				ExtentFactory.getInstance().getExtent().log(Status.FAIL, "String Assertion FAILED on field "+ locatorName + " Expected value was: "+ expvalue + " actual value is: "+actualValue);
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.assertTrue(false, e.toString());
		}
	}

<<<<<<< HEAD
	//Get text from webelement
	public String getText_custom(WebElement element, String fieldName) {
		String text = "";
		try {
			text = element.getText();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "");
			return text;
		} catch (Exception e) {		
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "");

		}
		return text;
	}

=======
>>>>>>> 21fbe2ae0a9c0d6103b884be7203e210639c6c46
}
