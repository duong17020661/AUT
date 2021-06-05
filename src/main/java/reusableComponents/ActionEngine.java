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
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Nhập giá trị: "+valueToBeSent);
		} catch (Exception e) {
			//log failure in extent
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Nhập giá trị : "+fieldName + " không thành công với lỗi : "+e);
		}
	}

	public void uploadFile_custom(WebElement element, String fieldName, String valueToBeSent) {
		try {
			element.sendKeys(valueToBeSent);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Tải tệp tin : "+valueToBeSent);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "ải tệp tin : "+fieldName + " không thành công với lỗi : "+e);
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
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> CHọn giá trị thành công ");
		} catch (Exception e) {
			//log failure in extent
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Không thể chọn giá trị " +fieldName +", có lỗi xảy ra: "+e);
		}
	}

	//custom click method to log evey click action in to extent report
	public void click_custom(WebElement element, String fieldName) {
		try {
			element.click();
			//log success message in exgent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> CHọn giá trị thành công ");
		} catch (Exception e) {
			//log failure in extent
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Không thể chọn giá trị " +fieldName +", có lỗi xảy ra: "+e);
		}
	}


	//custom mouseHover 
	public void moveToElement_custom(WebElement element,String fieldName){
		try{
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			Actions actions = new Actions(DriverFactory.getInstance().getDriver());		
			actions.moveToElement(element).build().perform();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Hover thành công ");
			Thread.sleep(1000);
		}catch(Exception e){
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Không thể hover: " +fieldName +", có lỗi xảy ra: "+e);

		}
	}


	//Select dropdown value value by visibleText
	public void selectDropDownByVisibleText_custom(WebElement element, String fieldName, String ddVisibleText) throws Throwable {
		try {
			Select s = new Select(element);
			s.selectByVisibleText(ddVisibleText);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Giá trị: "+ ddVisibleText + " đã được chọn");
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Không thể chọn giá trị " +fieldName +"  , có lỗi xảy ra: "+e);
		}
	}


	//String Asserts
	public void assertEqualsString_custom(String expvalue, String actualValue, String locatorName) throws Throwable {
		try {
			if(expvalue.equals(actualValue) == true) {
				ExtentFactory.getInstance().getExtent().log(Status.PASS, "String Assertion is successful on field "+ locatorName + " Expected value was: "+ expvalue + " actual value is: "+actualValue);
			}else {
				ExtentFactory.getInstance().getExtent().log(Status.FAIL, "String Assertion FAILED on field "+ locatorName + " Expected value was: "+ expvalue + " actual value is: "+actualValue);
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.assertTrue(false, e.toString());
		}
	}

}
