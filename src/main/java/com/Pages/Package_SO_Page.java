package com.Pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;

import com.Locators.Package_SO_Loc;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.utility.SafeActions;

public class Package_SO_Page extends SafeActions implements Package_SO_Loc {

	public void packageSOUpdates_Display_For_Admin() {
		waitFor(3);
		verifyTextDisplay(packageSO_Updates_Link, "Package SO Updates");
	}

	public void verifyPackageSOUpdates_NON_Display_For_StateOfficer() {
		try {
			String str = driver.findElement(packageSO_Updates_Link).getText();
			System.out.println("STR: " + str);
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Package SO Updates Tab displayed on the screen", ExtentColor.RED));
		} catch (Exception e) {
			test.log(Status.PASS, MarkupHelper.createLabel(
					"Package SO Updates Tab NOT displayed on the screen for state officer Login ", ExtentColor.GREEN));
		}
	}

	public void verifyStateOfficerReplacement() {
		Random rn = new Random();
		int firstIndex = rn.nextInt(50) + 1;
		int secondIndex = rn.nextInt(10) + 1;

		jsClickOn(packageSO_Updates_Link, "Package SO Updates");
		waitFor(1);
		jsClickOn(stateOfficerButton, "stateOfficerButton");
//		jsClickOn(selectCurrentStateOfficer, "selectCurrentStateOfficer");
		typeText(selectCurrentStateOfficer, "Debbie Cole", "selectCurrentStateOfficer");
		waitFor(1);
		typeText(selectCurrentStateOfficer, "", "selectCurrentStateOfficer");
		waitFor(1);
		By currentOfficerLoc = By.xpath("(//ul[@aria-label='Search Results']//span[2])[" + firstIndex + "]");
		jsClickOn(currentOfficerLoc, "currentOfficerLoc");
		jsClickOn(submitButton, "submitButton");
		waitFor(1);
		verifyTextDisplay(emptyStateOfficerErrorMessage, "Please select a State Officer to replace.");
		takeScreenshotFor("Please select a State Officer to replace.");
		waitFor(5);
		boolean checkBoxDiplay = false;
		for (int i = 0; i < 10; i++) {
			try {
				checkBoxDiplay = driver.findElement(selectStatecheckBox).isDisplayed();
			} catch (Exception e) {
			}
			if (checkBoxDiplay == true) {
				jsClickOn(selectStatecheckBox, "selectStatecheckBox");
				break;
			} else {
				jsClickOn(removeSelectedStateOfficer, "removeSelectedStateOfficer");
				typeText(selectCurrentStateOfficer, "Debbie Cole", "selectCurrentStateOfficer");
				waitFor(1);
				typeText(selectCurrentStateOfficer, "", "selectCurrentStateOfficer");
				waitFor(1);
				int firstIndexx = rn.nextInt(50) + 1;
				By currentOfficerLocator = By
						.xpath("(//ul[@aria-label='Search Results']//span[2])[" + firstIndexx + "]");
				jsClickOn(currentOfficerLocator, "currentOfficerLoc");
				waitFor(1);
			}
		}

		jsClickOn(selectReplacementStateOfficer, "selectReplacementStateOfficer");
		waitFor(1);
		typeText(selectReplacementStateOfficer, "Jessica Dunlap", "selectReplacementStateOfficer");
		waitFor(1);
		typeText(selectReplacementStateOfficer, "", "selectReplacementStateOfficer");
		waitFor(1);
		By replacementOfficerLoc = By.xpath("(//ul[@aria-label='Search Results']//span[2])[" + secondIndex + "]");
		jsClickOn(replacementOfficerLoc, "replacementOfficerLoc");
		waitFor(5);
		typeText(endDateInput, fetchDate("MMM d, yyyy", 7), "endDateInput");
		waitFor(5);
		clickOn(submitButton, "submitButton");
		waitFor(3);
		verifyTextDisplay(startDate_ErrorMsg, "Start Date is required when End Date is provided.");
		waitFor(1);
		takeScreenshotFor("Start Date Validation");
		typeText(startDateInput, fetchDate("MMM d, yyyy", 8), "startDateInput");
		clickOn(submitButton, "submitButton");
		waitFor(1);
		verifyTextDisplay(endDate_ErrorMsg, "End Date must be after Start Date.");
		waitFor(3);
		takeScreenshotFor("End Date Validation");
		typeText(startDateInput, fetchDate("MMM d, yyyy", 0), "startDateInput");
		clickOn(submitButton, "submitButton");
		waitFor(1);
		verifyTextDisplay(stateOfficer_SuccessMsg, "State Officer replaced");
		sentTime = fetchDate("MMM d, yyyy, h:m a", 0);
		URL = driver.getCurrentUrl();

	}

	String sentTime = "";
	String URL = "";

	public void validateEmailNotification() throws ParseException {
		if (prop.getProperty("url").contains("uat")) {
			driver.get("https://mailosaur.com/app/servers/csee9izm/messages/inbox");
		} else {
			driver.get("https://mailosaur.com/app/servers/drwhn6bn/messages/inbox");
		}
		waitFor(10);
		typeText(emailAddressTextField, "pghosh@index-analytics.com", "emailAddressTextField");
		jsClickOn(continueButton, "continueButton");
		typeText(passwordTextField, "Pass0110!@", "passwordTextField");
		jsClickOn(loginButtonEmail, "loginButtonEmail");
		waitFor(3);
		takeScreenshotFor("Email notification");
		String receivedDate = getTextFromUI(dateRecieved, "dateRecieved");

		SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy, h:m a");

		Date d1 = df.parse(sentTime);
		Date d2 = df.parse(receivedDate);
		if (d1.equals(d2) || d2.after(d1)) {

			jsClickOn(emailThread, "emailThread");
			waitFor(3);
			verifyTextDisplay(emailHeader, "Sandbox: State Officer Change Notification");
			String str = getTextFromUI(emailBody, "emailBody");
			test.log(Status.PASS, MarkupHelper.createLabel("Email Body - " + str, ExtentColor.BLUE));
			takeScreenshotFor("Email Body");

		} else {
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Email Notification not received to the server", ExtentColor.RED));
		}
	}

	public void validate_Reassignment_EmailNotification() throws ParseException {
		if (prop.getProperty("url").contains("uat")) {
			driver.get("https://mailosaur.com/app/servers/csee9izm/messages/inbox");
		} else {
			driver.get("https://mailosaur.com/app/servers/drwhn6bn/messages/inbox");
		}
		waitFor(10);
//		typeText(emailAddressTextField, "pghosh@index-analytics.com", "emailAddressTextField");
//		jsClickOn(continueButton, "continueButton");
//		typeText(passwordTextField, "Pass0110!@", "passwordTextField");
//		jsClickOn(loginButtonEmail, "loginButtonEmail");
//		waitFor(3);
		takeScreenshotFor("Email notification");
		String receivedDate = getTextFromUI(dateRecieved, "dateRecieved");

		SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy, h:m a");

		Date d1 = df.parse(sentTime);
		Date d2 = df.parse(receivedDate);
		if (d1.equals(d2) || d2.after(d1)) {
			jsClickOn(emailThread, "emailThread");
			waitFor(3);
			verifyTextDisplay(Re_assign_emailHeader, "Sandbox:");
			String str = getTextFromUI(emailBody, "emailBody");
			test.log(Status.PASS, MarkupHelper.createLabel("Email Body - " + str, ExtentColor.BLUE));
			takeScreenshotFor("Email Body");

		} else {
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Email Notification not received to the server", ExtentColor.RED));
		}
	}

	public void verifyStateOfficer_ReAssign() {
		driver.get(URL);
		waitFor(2);
		Random rn = new Random();
		int firstIndex = rn.nextInt(50) + 1;
		int secondIndex = rn.nextInt(10) + 1;

		jsClickOn(packageSO_Updates_Link, "Package SO Updates");
		waitFor(1);
		jsClickOn(Reassign_Decision_Package, "Reassign_Decision_Package");
		waitFor(1);
		typeText(selectStateOfficer, "Debbie Cole", "selectStateOfficer");
		waitFor(1);
		typeText(selectStateOfficer, "", "selectStateOfficer");
		waitFor(1);
		By currentOfficerLoc = By.xpath("(//ul[@aria-label='Search Results']//span[2])[" + firstIndex + "]");
		jsClickOn(currentOfficerLoc, "currentOfficerLoc");
		waitFor(2);
		boolean checkBoxDiplay = false;
		for (int i = 0; i < 10; i++) {
			try {
				checkBoxDiplay = driver.findElement(checkBoxOne).isDisplayed();
			} catch (Exception e) {
			}
			if (checkBoxDiplay == true) {
				jsClickOn(checkBoxOne, "checkBoxOne");
				break;
			} else {
				jsClickOn(removeSelectedStateOfficer, "removeSelectedStateOfficer");
				typeText(selectStateOfficer, "Debbie Cole", "selectStateOfficer");
				waitFor(1);
				typeText(selectStateOfficer, "", "selectStateOfficer");
				waitFor(1);
				int firstIndexx = rn.nextInt(50) + 1;
				By currentOfficerLocator = By
						.xpath("(//ul[@aria-label='Search Results']//span[2])[" + firstIndexx + "]");
				jsClickOn(currentOfficerLocator, "currentOfficerLocator");
				waitFor(2);
			}
		}
		takeScreenshotFor("Assigned decission package");
		scrollToElement(reassignPackageInput);
		scrollToBottomOfthePage();
		jsClickOn(reassignPackageInput, "reassignPackageInput");
		waitFor(1);
		typeText(reassignPackageInput, "Jessica Dunlap", "reassignPackageInput");
		waitFor(1);
		typeText(reassignPackageInput, "", "reassignPackageInput");
		waitFor(1);
		By reassignOfficerLoc = By.xpath("(//ul[@aria-label='Search Results']//span[2])[" + secondIndex + "]");
		jsClickOn(reassignOfficerLoc, "reassignOfficerLoc");
		waitFor(2);
		clickOn(submitButton, "submitButton");
		waitFor(1);
		verifyTextDisplay(reassignSuccessMessage, "Decision packages reassigned successfully.");
		sentTime = fetchDate("MMM d, yyyy, h:m a", 0);
	}

}// ENd of the Class
