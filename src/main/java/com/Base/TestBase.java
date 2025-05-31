package com.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.cdimascio.dotenv.Dotenv;

public class TestBase {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties prop;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriverWait wait;

	public static final By userName = By.xpath("//label[contains(text(), 'Username')]/..//input");
	public static final By password = By.xpath("//label[contains(text(), 'Password')]/following-sibling::input");
	public static final By loginButton = By.xpath("//*[@value='Log In to Sandbox']");
	public static final By appLauncher = By.xpath("//*[@title='App Launcher']");

	// Data kept in properties file, will be store in "prop" variable
	static {

		try {

			String path = ".//src//main//resources//resources//config.properties";
			fis = new FileInputStream(path);
			prop = new Properties();
			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Below code will collect method name
	// All the group names should be specify here too
	@BeforeMethod(groups = { "Regression", "Smoke" })
	public void beofreMethod(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	String screenshotPath = "";

	// Once method execution completed based on the status screenshots will be
	// captured
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src,
					new File(System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png"));

			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			try {
				screenshotPath = captureScreenshot(driver, result.getName());
//				String screenshotBase64 = encodeImageToBase64(screenshotPath);
//				 saveBase64ToImage(screenshotBase64, screenshotPath);
				test.fail(result.getThrowable(),
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//				test.fail(result.getThrowable(),
//						MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
			} catch (Exception e) {

			}
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
			try {
				screenshotPath = captureScreenshot(driver, result.getName());
//				String screenshotBase64 = encodeImageToBase64(screenshotPath);
//				 saveBase64ToImage(screenshotBase64, screenshotPath);
				test.pass(result.getThrowable(),
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//				test.pass(result.getThrowable(),
//						MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());

			} catch (Exception e) {

			}
		}
	}

	String environment = "";

	@BeforeTest(groups = { "Regression", "Smoke" })
	public void beforetest(ITestContext context) {

		// Report path specified
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/"
				+ fetchDate("MMM_dd_yyyy_HH_mm_ss", 0) + "/testReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		test = extent.createTest(context.getName());

		// To capture Environment details in the report
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		if (prop.getProperty("browser").contains("chrome")) {
			extent.setSystemInfo("Browser", "Chrome");
		}
		if (prop.getProperty("url").contains("cmcsqa")) {
			environment = "QA";
		} else if (prop.getProperty("url").contains("seimcuat")) {
			environment = "SEMI-UAT";
		} else {
			environment = "QA";
		}
		extent.setSystemInfo("Application Environment", environment);
		extent.setSystemInfo("Engineer", System.getProperty("user.name"));
	}

	@BeforeClass(groups = { "Regression", "Smoke" })
	public void beforeClass() {

		// Chrome Options to disable notifications and to launch browser in incognito
		// mode
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");

		// driver instantiation
		driver = new ChromeDriver(options);

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		System.out.println(cap.getCapabilityNames());

		loginToApplication();

	}

	// To quit the browser session
	@AfterClass(groups = { "Regression", "Smoke" })
	public void afterClass() throws InterruptedException {
//		driver.quit();
	}

	// To flush out the reports information once execution completed
	@AfterTest(groups = { "Regression", "Smoke" })
	public void afterTest() throws InterruptedException {
		extent.flush();
	}

	// To fetch dates in desired format //
	public String fetchDate(String format, int numberOfDaysToBeAdded) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, numberOfDaysToBeAdded);
		return df.format(cal.getTime());
	}
	
	// To fetch past or future weekday dates in desired format //
	public String fetchWeekdayDate(String format, int numberOfWeekdaysToBeAdded) {
	    SimpleDateFormat df = new SimpleDateFormat(format);
	    Calendar cal = Calendar.getInstance();
	    
	    int addedDays = 0;
	    int direction = (numberOfWeekdaysToBeAdded >= 0) ? 1 : -1;

	    while (addedDays != numberOfWeekdaysToBeAdded) {
	        cal.add(Calendar.DATE, direction);  // move one day forward or backward
	        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	        
	        // Only count weekdays
	        if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
	            addedDays += direction;
	        }
	    }

	    return df.format(cal.getTime());
	}

	public void waitFor(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// Below will take screenshot into specified location
	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
		File destinationFile = new File(filePath);

		try {
			FileHandler.copy(src, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filePath;
	}

	// To attach screenshot in to the report
	public void takeScreenshotFor(String screenshotName) {
		waitFor(2);
		String screenshotPath = captureScreenshot(driver, screenshotName);
		try {
			// To encrypt image so that image will not break when shared to others
			// String screenshotBase64 = encodeImageToBase64(screenshotPath);
			// To embed encrypted screenshot in the report
			// test.pass(screenshotName,
			// MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());

			// Embed screenshot without encrypt
			test.pass(screenshotName, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// To embed images in to the report
	FileInputStream fileInputStream;

	public String encodeImageToBase64(String imagePath) throws IOException {
		File file = new File(imagePath);
		fileInputStream = new FileInputStream(file);
		byte[] bytes = new byte[(int) file.length()];
		fileInputStream.read(bytes);
		fileInputStream.close();
		return new String(Base64.getEncoder().encode(bytes));
	}

	public void saveBase64ToImage(String base64String, String outputPath) throws IOException {
		byte[] decodedBytes = Base64.getDecoder().decode(base64String); // Decode Base64 string into byte array
		File outputFile = new File(outputPath); // Create output file
		java.nio.file.Files.write(outputFile.toPath(), decodedBytes); // Write decoded bytes to file
	}

	// Since SafeActions functions not available to the base class, SendText and
	// click methods implemented here only for login
	private void sendTextTo(By locator, String value, String elementName) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
				driver.findElement(locator));
		driver.findElement(locator).sendKeys(value);
		test.log(Status.INFO, MarkupHelper.createLabel("User Name entered in the Text Field", ExtentColor.BLUE));
		System.out.println(elementName + " entered in the Text Field");
	}

	JavascriptExecutor executor;

	public void javaScriptClickOn(By locator, String eleName) {
		executor = (JavascriptExecutor) driver;
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
					driver.findElement(locator));
			executor.executeScript("arguments[0].click();", driver.findElement(locator));
			test.log(Status.INFO, MarkupHelper.createLabel("Clicked on " + eleName, ExtentColor.BLUE));
			System.out.println("Clicked on " + eleName);
		} catch (Exception e) {
			test.log(Status.FAIL, MarkupHelper.createLabel("Exception at " + eleName, ExtentColor.RED));
			e.printStackTrace();
			captureScreenshot(driver, eleName);
			Assert.fail("Exception on " + eleName);
		}
	}

	// To Sign in to the application
	// Username and password will fetch from .env file
	public void loginToApplication() {

		Dotenv dotenv = Dotenv.load();
		String USER_NAME = dotenv.get("USER_NAME");
		String PASSWORD = dotenv.get("PASSWORD");

		try {
			sendTextTo(userName, USER_NAME, "USER_NAME");
			sendTextTo(password, PASSWORD, "PASSWORD");
			javaScriptClickOn(loginButton, "Login button");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// To generate random string
	public static String generateRandomString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder result = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			result.append(characters.charAt(index));
		}

		return result.toString();
	}

}
// End of the class
