package com.Pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.Locators.Escalation_Tracking_Locators;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.utility.SafeActions;

public class Escalation_Tracking_PO extends SafeActions implements Escalation_Tracking_Locators {

	public void verifyMandatoryFieldsOn_EscalationTracking() {
		waitFor(2);
		jsClickOn(escalationTracking_Tab, "escalationTracking_Tab");
		waitFor(1);
		jsClickOn(newButton, "newButton");
		waitFor(1);
		jsClickOn(relatedToDP_Yes, "relatedToDP_Yes");
		waitFor(1);
		takeScreenshotFor("Escalation Tracking Form");
		scrollByElement(submitButton);
		waitFor(1);
		takeScreenshotFor("Escalation Tracking Form with all mandatory fields");
		scrollToBottomOfthePage();
		waitFor(1);
		jsClickOn(submitButton, "submitButton");
		waitFor(1);
		verifyTextDisplay(StateMedicaidAgencyismissing, "State Medicaid Agency is missing.");
		verifyTextDisplay(DecisionPackageismissing, "Decision Package is missing.");
		verifyTextDisplay(TitleIsMissing, "Title is missing.");
		verifyTextDisplay(issueDescriptionIsMissing, "Issue Description is missing.");
//		verifyTextDisplay(RecommendationIsMissing, "Recommendation is missing.");
		verifyTextDisplay(RiskImpactScoreIsMissing, "Risk Impact Score is missing.");
		verifyTextDisplay(pleaseSelectYesOrNo, "Please select Yes or No.");
		verifyTextDisplay(ResolutionNededByIsMissing, "Resolution Needed By is missing.");
		verifyTextDisplay(maximumFileSizeLimit, "Maximum file size is 4MB.");
		takeScreenshotFor("Escalation Tracking Form with all mandatory fields");
	}

	public void OpenNew_ET_Creation_Form() {
		waitFor(2);
		jsClickOn(escalationTracking_Tab, "escalationTracking_Tab");
		waitFor(1);
		jsClickOn(newButton, "newButton");
		waitFor(1);
		jsClickOn(relatedToDP_Yes, "relatedToDP_Yes");
		waitFor(1);
		takeScreenshotFor("Escalation Tracking Form");
	}

	String str = "";
	public void verify_Escalation_Tracking_Creation() {
		 str = Character.toString(getRandomStateInitial());
		scrollToTopofThePage();
		waitFor(2);
		for (int i = 1; i <= 10; i++) {

			typeText(stateMedicalAgency_Input, str, "stateMedicalAgency_Input");
			for (int j = 1; j <= 10; j++) {
				try {
					if (driver.findElement(stateMedicalAgency_Option).isDisplayed()) {
						jsClickOn(stateMedicalAgency_Option, "stateMedicalAgency_Option");
						break;
					}
				} catch (Exception e) {
					str = Character.toString(getRandomStateInitial());
					typeText(stateMedicalAgency_Input, str, "stateMedicalAgency_Input");
					System.out.println("stateMedicalAgency_Option not available in " + j + " search");
				}
			}
			jsClickOn(stateMedicalAgency_Option, "stateMedicalAgency_Option");
			typeText(DecisionPackage_Input, str, "DecisionPackage_Input");
			try {
				if (driver.findElement(DecisionPackage_Option).isDisplayed()) {
					jsClickOn(DecisionPackage_Option, "DecisionPackage_Option");
					break;
				}
			} catch (Exception e) {
				jsClickOn(clearSelection, "clearSelection");
				System.out.println("Decission Package not available in " + i + " search");
			}
		}

		typeText(titleInput, generateRandomString(10), "titleInput");
		typeText(issueDescription, generateRandomString(10), "issueDescription");
		jsClickOn(riskImpactButton, "riskImpactButton");
		waitFor(1);
		jsClickOn(riskImpactOption, "riskImpactOption");
		waitFor(1);
		jsClickOn(potentialImpactAccess_Yes, "potentialImpactAccess_Yes");
		jsClickOn(bussinessImpactArea_Button, "bussinessImpactArea_Button");
		waitFor(1);
		jsClickOn(bussinessImpactArea_Option, "bussinessImpactArea_Option");
		waitFor(1);
		scrollToElement(resolutionNeededBy_Input);
		scrollToBottomOfthePage();
		jsClickOn(resolutionNeededBy_Input, "resolutionNeededBy_Input");
		waitFor(1);
		typeText(resolutionNeededBy_Input, fetchDate("MMM d, yyyy", 1), "resolutionNeededBy_Input");
		waitFor(1);
		jsClickOn(submitButton, "submitButton");
		waitFor(1);
		driver.findElement(submitButton).click();
		waitFor(1);
		verifyTextDisplay(escalationTrackerCreation_SuccessMsg,
				"The Escalation Tracking record has been created successfully");
		takeScreenshotFor("Escalation Tracking Creation");

	}

	public void verifyLeadershipReview() {
		moveEscalationTo_Review_Stage();

		jsClickOn(editLeadershipDisposition, "editLeadershipDisposition");
		jsClickOn(leadershipDsipositionDropdown, "leadershipDsipositionDropdown");
		jsClickOn(disposition_Monitoring_Option, "disposition_Monitoring_Option");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		verifyTextDisplay(monitoringDAteErrorMessage, "Complete this field with format");
		scrollToTopofThePage();
		waitFor(2);
		takeScreenshotFor("Monitoring End Date field Validation");
		typeText(monitoringEndDate_Input, fetchDate("M/d/yyyy", -1), "monitoringEndDate_Input");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		verifyTextDisplay(monitoringDataErrorMessage2, "Monitoring End Date must be today or a future date.");

		typeText(monitoringEndDate_Input, fetchDate("M/d/yyyy", 3), "monitoringEndDate_Input");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		scrollToTopofThePage();
		String monitoringAwareness_Status = getAttribute(monitoringAwarenessStatus, "aria-selected",
				"monitoringAwarenessStatus");
		if (monitoringAwareness_Status.equals("true")) {
			test.log(Status.INFO, MarkupHelper.createLabel("Stage has been moved to Monitoring / Awareness as expected",
					ExtentColor.GREEN));

		} else {
			test.log(Status.FAIL, MarkupHelper
					.createLabel("Stage has NOT been moved to Monitoring / Awareness so failed", ExtentColor.RED));
		}
		takeScreenshotFor("Stage moved to Monitoring");

		updateDispositionTo_Resolved("Escalation Tracker moved to Resolved Status");
		checkEscalation_Status_As_resolved();
		updateDispositionTo_Other();
		verifyTextDisplay(escalationLockMessage, "The Escalation Tracking Item is Resolved and Locked.");
		takeScreenshotFor("ET locked when chosen Other reason");
		jsClickOn(cancelButton, "cancelButton");
		waitFor(3);
	}

	public void verifyReturnEscalationItem() {
		takeScreenshotFor("Before Begin Review");
		jsClickOn(beginReview, "beginReview");
		waitFor(5);
		takeScreenshotFor("Before return Escaltion Item");
		jsClickOn(returnEscaltionItem, "returnEscaltionItem");
		waitFor(2);
		typeText(comments, "Test", "comments");
		jsClickOn(submitButton, "submitButton");
		waitFor(2);
		scrollToTopofThePage();
		sentTime = fetchDate("MMM d, yyyy, h:m a", 0);
		waitFor(2);
		verifyTextDisplay(return_Esc_AlertMessage,
				"Escalation Tracking item has been returned and is being reviewed by the creator");
		takeScreenshotFor("Escalation Tracking item has been returned");
	}

	public void verifyEscalationTrackerwith_NoActionNeeded() {

		moveEscalationTo_Review_Stage();
		updateDispositionTo_NoActionNeeded();
		checkEscalation_Status_As_resolved();
		updateDispositionTo_Resolved("ET locked when chosen Resolved after disposition updated as No Action Needed");
		verifyTextDisplay(escalationLockMessage, "The Escalation Tracking Item is Resolved and Locked.");
		jsClickOn(cancelButton, "cancelButton");
		waitFor(3);
	}

	public void verifyEscalationTrackerwith_OtherReason() {

		moveEscalationTo_Review_Stage();
		updateDispositionTo_Other();
		checkEscalation_Status_As_resolved();
		updateDispositionTo_Resolved("ET locked when chosen Resolved after disposition updated as Other Reason");
		verifyTextDisplay(escalationLockMessage, "The Escalation Tracking Item is Resolved and Locked.");
		jsClickOn(cancelButton, "cancelButton");
		waitFor(3);

	}

	public void updateDispositionTo_NoActionNeeded() {
		jsClickOn(editLeadershipDisposition, "editLeadershipDisposition");
		jsClickOn(leadershipDsipositionDropdown, "leadershipDsipositionDropdown");
		jsClickOn(noActionNeeded, "noActionNeeded");
		takeScreenshotFor("No Action Needed");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		scrollToTopofThePage();
	}

	public void updateDispositionTo_Other() {
		jsClickOn(editLeadershipDisposition, "editLeadershipDisposition");
		jsClickOn(leadershipDsipositionDropdown, "leadershipDsipositionDropdown");
		jsClickOn(Other_Option, "Other_Option");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		verifyTextDisplay(completedThisField, "Complete this field.");
		scrollToBottomOfthePage();
		scrollByPixels(-400);
		typeText(otherDisposition_Reason, "Text", "otherDisposition_Reason");
		takeScreenshotFor("otherDisposition_Reason");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		scrollToTopofThePage();
	}

	public void updateDispositionTo_Resolved(String screenshotName) {
		jsClickOn(editLeadershipDisposition, "editLeadershipDisposition");
		jsClickOn(leadershipDsipositionDropdown, "leadershipDsipositionDropdown");
		jsClickOn(resolved_Option, "resolved_Option");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		scrollToBottomOfthePage();
		verifyTextDisplay(actionTaken_ErrorMsg, "Please provide Status Update/Actions Taken when resolving an ET item");
		takeScreenshotFor("actionTaken_ErrorMsg");
		jsClickOn(actionTakenArea, "actionTakenArea");
		waitFor(2);
		typeText(actionTakenArea_, "Test", "actionTakenArea_");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		takeScreenshotFor(screenshotName);
	}

	public void checkEscalation_Status_As_resolved() {
		scrollToTopofThePage();
		String resolved_StatusOther = getAttribute(resolvedStatus, "aria-selected", "resolvedStatus");
		if (resolved_StatusOther.equals("true")) {
			test.log(Status.INFO, MarkupHelper.createLabel("Stage status is Resolved as expected", ExtentColor.GREEN));

		} else {
			test.log(Status.FAIL, MarkupHelper.createLabel("Stage status is NOT Resolved so failed", ExtentColor.RED));
		}
	}

	public void moveEscalationTo_Review_Stage() {
		waitFor(5);
		String status = getAttribute(traigeStageSelection, "aria-selected", "traigeStageSelection");
		if (status.equals("true")) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Triage selected by default as expected", ExtentColor.GREEN));

		} else {
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Triage NOT selected by default as expected", ExtentColor.RED));
		}

		jsClickOn(relatedTab, "relatedTab");
		waitFor(1);
		jsClickOn(detailsTab, "detailsTab");
		waitFor(1);
		scrollToBottomOfthePage();
		waitFor(2);
		scrollToTopofThePage();
		waitFor(2);
		scrollToElement(issue_Sub_Status);
		verifyTextDisplay(issue_Sub_Status, "Pending Review");

		jsClickOn(editLeaderShipAssigned, "editLeaderShipAssigned");
		typeText(leadershipAssigngedInput, "Ricardo Melendez", "leadershipAssigngedInput");
		jsClickOn(leadershipAssignedOption, "leadershipAssignedOption");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		scrollToTopofThePage();
		String leadership_ReviewStatus = getAttribute(LeadershipReview_StageSelection, "aria-selected",
				"LeadershipReview_StageSelection");
		if (leadership_ReviewStatus.equals("true")) {
			test.log(Status.INFO, MarkupHelper.createLabel("LeadershipReview selected as expected", ExtentColor.GREEN));

		} else {
			test.log(Status.FAIL,
					MarkupHelper.createLabel("LeadershipReview NOT selected as expected", ExtentColor.RED));
		}
	}

	String sentTime = "";

	public void validateEmailNotification() throws ParseException {
		driver.get("https://mailosaur.com/app/servers/drwhn6bn/messages/inbox");
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
			verifyTextDisplay(emailHeader, "Sandbox: Escalation Item Has Been Returned");
			String str = getTextFromUI(emailBody, "emailBody");
			test.log(Status.PASS, MarkupHelper.createLabel("Email Body - " + str, ExtentColor.BLUE));
			takeScreenshotFor("Email Body");

		} else {
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Email Notification not received to the server", ExtentColor.RED));
		}
	}

}// ENd of the Class
