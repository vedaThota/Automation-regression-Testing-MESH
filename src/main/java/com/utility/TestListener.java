package com.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

public class TestListener extends SafeActions implements ITestListener {

//	@Override
//	public void onTestFailure(ITestResult result) {
//		try {
//			String screenshotPath = captureScreenshot(driver, result.getName());
//			test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//		} catch (Exception e) {
//
//		}
//	}

}
