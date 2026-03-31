package com.CertificationWorkflow_Pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.CertificationWorkflow_Loc.CW_DetailsPage_Loc;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.utility.SafeActions;

public class CW_DetailsPage extends SafeActions implements CW_DetailsPage_Loc {

	public void navigateTo_Certification_Workflow_Screen() {
		waitFor(2);
		jsClickOn(appLauncher, "appLauncher");
		waitFor(1);
		typeText(appSearchTextField, "Certification Workflow", "appSearchTextFiel");
		waitFor(3);
		jsClickOn(certification_Workflow_Nav_Link, "certification_Workflow_Nav_Link");
		waitFor(3);
		takeScreenshotFor("Navigated to Certification Workflow screen");
	}

	public void verify_Generate_template_Activity() {

		jsClickOn(Edit_Director, "Edit_Director");
		typeText(director_Input, "ali", "director_Input");
		waitFor(2);
		jsClickOn(director_Option, "director_Option");
		waitFor(1);
		jsClickOn(save_Button, "save_Button");
		waitFor(5);
		takeScreenshotFor("Director Updated");
//		jsClickOn(Box_Link, "Box_Link");
//		waitFor(10);
//		new Actions(driver).dragAndDrop(driver.findElement(insertShadow), driver.findElement(dropShadow));
//		waitFor(10);
		
//		jsClickOn(create_Folder, "create_Folder");
//		waitFor(30);
//		jsClickOn(generate_Template_button, "generate_Template_button");
//		waitFor(2);
//		jsClickOn(generate_Word_Document_button, "generate_Word_Document_button");
//		verifyTextDisplay(documentUploaded_Successfully, "Document successfully uploaded");
//		takeScreenshotFor("Document successfully uploaded");
//		waitFor(10);
//		jsClickOn(generate_Template_button, "generate_Template_button");
//		waitFor(2);
//		jsClickOn(generate_Word_Document_button, "generate_Word_Document_button");
//		takeScreenshotFor("This template has already been generated");
//		verifyTextDisplay(templateError_Messaage, "This template has already been generated");
//		jsClickOn(cancel_Close, "cancel_Close");

	}

	public void verify_SO_Review_Activity() {
		jsClickOn(move_to_SO_Reeview, "move_to_SO_Reeview");
		jsClickOn(confirm_Button, "confirm_Button");
		waitFor(5);
		verifyTextDisplay(status_Updated, "SO Review");
		scrollToTopofThePage();
		takeScreenshotFor("SO Review Tab status");
		String status = getAttribute(SO_Review_Tab, "aria-selected", "SO_Review_Tab");
		if (status.equals("true")) {
			test.log(Status.INFO, MarkupHelper.createLabel("Status moved to SO Review", ExtentColor.GREEN));
		} else {
			test.log(Status.INFO, MarkupHelper.createLabel("Status NOT moved to SO Review", ExtentColor.RED));
		}

	}

	String sentTime = "";

	public void verify_Withdrawn_Functionality(int dateCreated) {
		jsClickOn(withdrawn_Button, "withdrawn_Button");
		waitFor(3);
		takeScreenshotFor("Withdrawn popup");
		new Select(driver.findElement(reason_For_Withdrawn)).selectByIndex(3);
		typeText(withdrawal_Comments, "Test", "Withdrawal comments");
		takeScreenshotFor("After mandatory fields added");
		jsClickOn(next_Button, "Next Button");
		waitFor(7);
		scrollToTopofThePage();
		takeScreenshotFor("After Withdrawn");
		verifyTextDisplay(Status_Field, "Completed");

		verifyTextDisplay(Sub_Status_Field, "Withdrawn");

		verifyTextDisplay(submittionDate_Field, fetchWeekdayDate("M/d/yyyy", -dateCreated));
		sentTime = fetchDate("h:m a", 0);
		jsClickOn(Edit_Certification_Request_Date, "Edit_Certification_Request_Date");
		jsClickOn(save_Button, "Save button");
		verifyTextDisplay(certificationPackage_Locked, "The Certification Package is Completed and Locked.");
		takeScreenshotFor("The Certification Package is Completed and Locked.");
		jsClickOn(Cancel_Button, "Cancel Button");

	}

	public void verify_Withdrawn_Functionality_Other_Reason(int dateCreated) {
		jsClickOn(withdrawn_Button, "withdrawn_Button");
		waitFor(3);
		takeScreenshotFor("Withdrawn popup");
		new Select(driver.findElement(reason_For_Withdrawn)).selectByIndex(4);
		jsClickOn(next_Button, "Next Button");
		waitFor(3);
		verifyTextDisplay(other_Reason_Without_Comments, "Comments are required when");
		takeScreenshotFor("Comments are required");
		jsClickOn(goBackButton, "goBackButton");
		waitFor(3);
		new Select(driver.findElement(reason_For_Withdrawn)).selectByIndex(4);

		typeText(withdrawal_Comments, "Test", "Withdrawal comments");
		takeScreenshotFor("After mandatory fields added");
		jsClickOn(next_Button, "Next Button");
		waitFor(7);
		scrollToTopofThePage();
		takeScreenshotFor("After Withdrawn");
		verifyTextDisplay(Status_Field, "Completed");

		verifyTextDisplay(Sub_Status_Field, "Withdrawn");

		verifyTextDisplay(submittionDate_Field, fetchWeekdayDate("M/d/yyyy", -dateCreated));
		sentTime = fetchDate("h:m a", 0);
		jsClickOn(Edit_Certification_Request_Date, "Edit_Certification_Request_Date");
		jsClickOn(save_Button, "Save button");
		verifyTextDisplay(certificationPackage_Locked, "The Certification Package is Completed and Locked.");
		takeScreenshotFor("The Certification Package is Completed and Locked.");
		jsClickOn(Cancel_Button, "Cancel Button");

	}

	public void validateEmailNotification(String login_Cond) throws ParseException {
		waitFor(30);
		String currentURL = driver.getCurrentUrl();
		if (prop.getProperty("url").contains("uat")) {
			driver.get("https://mailosaur.com/app/servers/tocbb3xf/messages/inbox");
		} else {
			driver.get("https://mailosaur.com/app/servers/drwhn6bn/messages/inbox");
		}
		waitFor(10);
		if (login_Cond.contains("Required")) {
			typeText(emailAddressTextField, "pghosh@index-analytics.com", "emailAddressTextField");
			jsClickOn(continueButton, "continueButton");
			typeText(passwordTextField, "Pass0110!@", "passwordTextField");
			jsClickOn(loginButtonEmail, "loginButtonEmail");
		}
		waitFor(5);
		takeScreenshotFor("Email notification");
		String receivedDate = getTextFromUI(dateRecieved, "dateRecieved");

		SimpleDateFormat df = new SimpleDateFormat("h:m a");

		Date d1 = df.parse(sentTime);
		Date d2 = df.parse(receivedDate);
		if (d1.equals(d2) || d1.after(d2)) {

			jsClickOn(emailThread, "emailThread");
			waitFor(3);
			verifyTextDisplay(emailHeader, "Sandbox: Certification_Package Package Has Been Withdrawn");

			String str = getTextFromUI(emailBody, "emailBody");
			test.log(Status.PASS, MarkupHelper.createLabel("Email Body - " + str, ExtentColor.BLUE));
			takeScreenshotFor("Email Body");

		} else {
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Email Notification not received to the server", ExtentColor.RED));
		}

		driver.get(currentURL);
		waitFor(3);
	}

	public void verify_SO_Begin_review() {
		waitFor(5);
		verifyTextDisplay(status_Updated, "SO Review");
		jsClickOn(beginReview, "beginReview");
		waitFor(2);
		jsClickOn(Move_to_CMS_Certification_Lead, "Move_to_CMS_Certification_Lead");
		waitFor(2);

	}

	public void verify_CMS_Certification_lead_review() {
		verifyTextDisplay(status_Updated, "CMS Certification Lead");
		jsClickOn(beginReview, "beginReview");
		waitFor(10);
		jsClickOn(Move_to_DSS_Review, "Move_to_DSS_Review");
		waitFor(2);
		jsClickOn(confirm_Button, "confirm_Button");
		waitFor(2);
		takeScreenshotFor("Moved to DSS review");
	}

	public void verify_DSS_DSG_review() {
		verifyTextDisplay(status_Updated, "DSS/DSG Review");
		jsClickOn(beginReview, "beginReview");
		waitFor(2);
		takeScreenshotFor("DSS Begin Review");
		jsClickOn(approve_Package, "approve_Package");
		waitFor(2);
		takeScreenshotFor("moved to pending issueance to State");
	}

	public void verify_pending_issuance_review() {
		verifyTextDisplay(status_Updated, "Pending Issuance to State");
		jsClickOn(closeOut_Package, "closeOut_Package");
		waitFor(2);
		takeScreenshotFor("Confirm Closeout package");
		jsClickOn(confirm_Button, "confirm_Button");
		waitFor(1);
		verifyTextDisplay(update_Failed_Error_Message,
				"Update failed: Issuance to State Date must be completed to closeout package");
		takeScreenshotFor("Update failed: Issuance to State Date must be completed to closeout package");
		jsClickOn(edit_Issuance_To_StateDate, "edit_Issuance_To_StateDate");
		waitFor(2);
		typeText(issuanceDate_Input, fetchWeekdayDate("M/d/yyyy", 0), "issuanceDate_Input");
		jsClickOn(save_Button, "Save Button");
		waitFor(2);
		jsClickOn(save_Button, "Save Button");
		waitFor(2);
		jsClickOn(closeOut_Package, "closeOut_Package");
		waitFor(2);
		jsClickOn(confirm_Button, "confirm_Button");
		waitFor(10);

		String status = getAttribute(completed_Tab, "aria-selected", "completed_Tab");
		if (status.equals("true")) {
			test.log(Status.INFO, MarkupHelper.createLabel("Status moved to Completed", ExtentColor.GREEN));
		} else {
			test.log(Status.INFO, MarkupHelper.createLabel("Status NOT moved to Completed", ExtentColor.RED));
		}
	}

}
