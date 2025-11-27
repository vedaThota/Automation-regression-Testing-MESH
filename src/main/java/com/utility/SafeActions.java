
package com.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.Base.TestBase;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class SafeActions extends TestBase {
	JavascriptExecutor executor;

	public void clickOn(By loc, String eleName) {
		executor = (JavascriptExecutor) driver;
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
					driver.findElement(loc));
			driver.findElement(loc).click();

			test.log(Status.INFO, MarkupHelper.createLabel("Clicked on " + eleName, ExtentColor.BLUE));
			System.out.println("Clicked on " + eleName);
		} catch (Exception e) {
			takeScreenshotFor("Exception at " + eleName);
			test.log(Status.FAIL, MarkupHelper.createLabel("Exception at " + eleName, ExtentColor.RED));
			e.printStackTrace();
			Assert.assertTrue(false, "Unable to click on " + eleName);
		}
	}// click method

	public void jsClickOn(By locator, String eleName) {
		executor = (JavascriptExecutor) driver;
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
					driver.findElement(locator));
			executor.executeScript("arguments[0].click();", driver.findElement(locator));
//			((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", driver.findElement(locator));
			test.log(Status.INFO, MarkupHelper.createLabel("Clicked on " + eleName, ExtentColor.BLUE));
			System.out.println("Clicked on " + eleName);
		} catch (Exception e) {
			takeScreenshotFor("Exception at " + eleName);
			test.log(Status.FAIL, MarkupHelper.createLabel("Exception at " + eleName, ExtentColor.RED));
			e.printStackTrace();
			Assert.assertTrue(false, "Unable to click on " + eleName);
		}
	}

	public void typeText(By loc, String text, String eleName) {
		executor = (JavascriptExecutor) driver;
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
					driver.findElement(loc));
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", driver.findElement(loc));
			driver.findElement(loc).click();
			driver.findElement(loc).clear();
			driver.findElement(loc).sendKeys(text);

			test.log(Status.INFO,
					MarkupHelper.createLabel(text + " entered in " + eleName + " text field", ExtentColor.BLUE));
			System.out.println(text + " entered in " + eleName + " text field");
		} catch (Exception e) {
			takeScreenshotFor("Exception at " + eleName);
			test.log(Status.FAIL, MarkupHelper.createLabel("Exception at " + eleName, ExtentColor.RED));
			e.printStackTrace();
			Assert.assertTrue(false, "Unable to Type text on " + eleName);
		}
	}

	public void verifyElementIsDisplayed(By locator, String elementName) {
		executor = (JavascriptExecutor) driver;
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
					driver.findElement(locator));
			Boolean condtion = driver.findElement(locator).isDisplayed();
			System.out.println("MSG : " + driver.findElement(locator).getText());
			Assert.assertTrue(condtion, locator + " is not displayed on the screen so failed");
			test.log(Status.INFO,
					MarkupHelper.createLabel(elementName + " Displayed on the screen", ExtentColor.GREEN));

		} catch (Exception e) {
			takeScreenshotFor("Exception at " + elementName);
			e.printStackTrace();
			test.log(Status.FAIL,
					MarkupHelper.createLabel(elementName + " NOT displayed on the screen", ExtentColor.RED));
			Assert.assertTrue(false, "Seems element is not displayed on the screen " + elementName);
		}
	}

	public void verifyPageTitle(String titleName) {

		wait.until(ExpectedConditions.titleIs(titleName));
		String text = driver.getTitle();
		if (text.equals(titleName)) {
			test.log(Status.INFO, MarkupHelper.createLabel("Title verified successfully", ExtentColor.ORANGE));
		} else if (!text.equals(titleName)) {
			test.log(Status.FAIL, MarkupHelper.createLabel("Title not matched", ExtentColor.RED));
			Assert.assertEquals(text, titleName);
		}

	}

	String text = "";

	public String getTextFromUI(By locator, String eleName) {

		executor = (JavascriptExecutor) driver;
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
					driver.findElement(locator));
			text = driver.findElement(locator).getText();
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", driver.findElement(locator));
			test.log(Status.INFO, MarkupHelper.createLabel(text + " retrieved from the UI", ExtentColor.BLUE));
			System.out.println(text + " retrieved from the UI");
		} catch (Exception e) {
			test.log(Status.FAIL, MarkupHelper.createLabel("Exception at " + eleName, ExtentColor.RED));
			e.printStackTrace();
//			Assert.fail("Exception on " + eleName);
		}
		return text;
	}

	public String getTextFromUI_Dont_Capture_Text_InThe_Report(By locator, String eleName) {

		executor = (JavascriptExecutor) driver;
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
					driver.findElement(locator));
			text = driver.findElement(locator).getText();
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", driver.findElement(locator));
			System.out.println(text + " retrieved from the UI");
		} catch (Exception e) {
			test.log(Status.FAIL, MarkupHelper.createLabel("Exception at " + eleName, ExtentColor.RED));
			e.printStackTrace();
			Assert.fail("Exception on " + eleName);
		}
		return text;
	}

	public String getAttribute(By locator, String attributeName, String eleName) {
		try {
			text = driver.findElement(locator).getAttribute(attributeName);
			test.log(Status.INFO, MarkupHelper.createLabel(text + " retrieved from the UI", ExtentColor.BLUE));
			System.out.println(text + " retrieved from the UI");
		} catch (Exception e) {
			test.log(Status.FAIL, MarkupHelper.createLabel("Exception at " + eleName, ExtentColor.RED));
			e.printStackTrace();
			Assert.fail("Exception on " + eleName);
		}
		return text;
	}

	public void waitUntilElementDisplayed(By locator, String eleName) {
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForLoad() {
		executor = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}

	public void switchToFrame(By locator) {
		try {
			driver.switchTo().frame(driver.findElement(locator));
		} catch (NoSuchElementException e) {
			test.log(Status.FAIL, MarkupHelper.createLabel("Exception at " + locator, ExtentColor.RED));
			e.printStackTrace();
			Assert.fail("Exception on " + locator);
		} catch (NoSuchFrameException e2) {
			test.log(Status.FAIL, MarkupHelper.createLabel("Exception at " + locator, ExtentColor.RED));
			e2.printStackTrace();
			Assert.fail("Exception on " + locator);
		}
	}

	boolean condition = false;

	public void switchTOWindow(String title) {
		waitFor(1);
		for (String windows : driver.getWindowHandles()) {
			waitFor(1);
			driver.switchTo().window(windows);
			System.out.println("Title: " + driver.getTitle());
			if (driver.getTitle().contains(title)) {
				condition = true;
				break;
			}
		}
		if (condition == false) {
			test.log(Status.FAIL, MarkupHelper.createLabel("No window found with given title", ExtentColor.RED));
			Assert.fail("No window found with given title ");
		}
	}

	public void switchToWindowByIndex(int index) {
		driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(index));
	}

	public void scrollToTopofThePage() {
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_HOME);
			robot.keyRelease(KeyEvent.VK_HOME);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void scrollToElement(By locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
				driver.findElement(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
		waitFor(1);
	}

	Robot robot;

	public void scrollByElement(By locator) {
		WebElement body = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(body).click().sendKeys(org.openqa.selenium.Keys.ARROW_DOWN).perform();
	}

	public void verifyTextDisplay(By locator, String elementName) {
		String stage = getTextFromUI(locator, elementName);
		if (stage.contains(elementName)) {
			test.log(Status.INFO,
					MarkupHelper.createLabel(elementName + " displayed on the screen", ExtentColor.GREEN));
//			jsClickOn(locator, elementName);
			System.out.println(elementName + " displayed on the screen");

		} else {
			test.log(Status.FAIL,
					MarkupHelper.createLabel(elementName + " NOT displayed on the screen", ExtentColor.RED));

			Assert.assertTrue(false, elementName + " NOT displayed on the screen, so failed");
		}
	}

	public boolean nameStatus;

	public void verifyElementNOTDisplayed(By locator, String elementName) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			nameStatus = driver.findElement(locator).isDisplayed();

		} catch (NoSuchElementException e) {
			nameStatus = false;
		}
		if (nameStatus == false) {
			test.log(Status.INFO,
					MarkupHelper.createLabel(elementName + " not displayed as expected", ExtentColor.GREEN));
			System.out.println(elementName + " not displayed as expected");

		} else {
			test.log(Status.FAIL, MarkupHelper.createLabel(elementName + " displayed so failed, Ideally it should not",
					ExtentColor.RED));

			Assert.assertTrue(false, elementName + " displayed so failed");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public void captureDataToReport(By locator, String elementName) {
		String text = getAttribute(locator, "innerHTML", elementName);
		test.log(Status.INFO, MarkupHelper.createLabel(text + " displayed on the screen", ExtentColor.GREEN));

	}

	public void scrollToBottomOfthePage() {
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public int generateARandomNumberBetweenOneTo57() {
		Random random = new Random();

		// Generate random number between 1 and 57 (inclusive)
		int randomNumber = random.nextInt(57);

		System.out.println("Random number between 1 and 57: " + randomNumber);
		return randomNumber;
	}

	public char generateARandomCharacterBetweenAtoZ() {
		Random random = new Random();

		// Generate random character between 'a' (97) and 'z' (122)
		char randomChar = (char) (random.nextInt(26) + 'a');
		return randomChar;
	}

	static int index = 0;

	public static char getRandomStateInitial() {
		// The string of first characters of U.S. states
		String initials = "AAAA CCC DFGHIIIIKKLMMMMMMMMNNNNNNNNOOOPRSSTTUVVWWWW";

		// Generate a random index
		Random random = new Random();
		index = random.nextInt(initials.length());
		System.out.println("Index: " + index);
		// Return the character at that index
		return initials.charAt(index);
	}

	public static String getRandomStateInitial_() {
		String initials[] = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA",
				"KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY",
				"NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI",
				"WY" };

		// Generate a random index
//		Random random = new Random();
//		 index = random.nextInt(initials.length);
		System.out.println("Index2: " + index);
		// Return the character at that index
		return initials[index];
	}

	public int findTheDifference_Between(String date1, String date2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

		// Parse the input dates
		LocalDate startDate = LocalDate.parse(date1, formatter);
		LocalDate endDate = LocalDate.parse(date2, formatter);

		// Calculate the difference in days
		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		return (int) daysBetween;
	}

	public void scrollByPixels(int size) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll up by 300 pixels
		js.executeScript("window.scrollBy(0, " + size + ");");
	}

}// End of the class
