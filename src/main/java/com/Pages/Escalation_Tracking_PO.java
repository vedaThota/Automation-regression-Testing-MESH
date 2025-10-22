package com.Pages;

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
		scrollByElement(submitButton);
		waitFor(1);
		scrollToBottomOfthePage();
		waitFor(1);
		jsClickOn(submitButton, "submitButton");
		waitFor(1);
		verifyTextDisplay(StateMedicaidAgencyismissing, "State Medicaid Agency is missing.");
		verifyTextDisplay(DecisionPackageismissing, "Decision Package is missing.");
		verifyTextDisplay(TitleIsMissing, "Title is missing.");
		verifyTextDisplay(issueDescriptionIsMissing, "Issue Description is missing.");
		verifyTextDisplay(RecommendationIsMissing, "Recommendation is missing.");
		verifyTextDisplay(RiskImpactScoreIsMissing, "Risk Impact Score is missing.");
		verifyTextDisplay(pleaseSelectYesOrNo, "Please select Yes or No.");
		verifyTextDisplay(ResolutionNededByIsMissing, "Resolution Needed By is missing.");
		verifyTextDisplay(maximumFileSizeLimit, "Maximum file size is 4MB.");

	}

	public void verify_Escalation_Tracking_Creation() {
		String str = Character.toString(getRandomStateInitial());
		scrollToTopofThePage();
		waitFor(2);
		typeText(stateMedicalAgency_Input, str, "stateMedicalAgency_Input");
		jsClickOn(stateMedicalAgency_Option, "stateMedicalAgency_Option");
		typeText(DecisionPackage_Input, str, "DecisionPackage_Input");
		jsClickOn(DecisionPackage_Option, "DecisionPackage_Option");
		typeText(titleInput, generateRandomString(10), "titleInput");
		typeText(issueDescription,  generateRandomString(10), "issueDescription");
		jsClickOn(recomendationbutton, "recomendationbutton");
		waitFor(1);
		jsClickOn(recommendationOption, "recommendationOption");
		waitFor(1);
		jsClickOn(riskImpactButton, "riskImpactButton");
		waitFor(1);
		jsClickOn(riskImpactOption, "riskImpactOption");
		waitFor(1);
		jsClickOn(potentialImpactAccess_Yes, "potentialImpactAccess_Yes");
		jsClickOn(bussinessImpactArea_Button, "bussinessImpactArea_Button");
		waitFor(1);
		jsClickOn(bussinessImpactArea_Option, "bussinessImpactArea_Option");
		waitFor(1);
//		typeText(resolutionNeededBy_Input, fetchDate("MMM d, yyyy", 0), "resolutionNeededBy_Input");
		jsClickOn(submitButton, "submitButton");
		waitFor(1);
		verifyTextDisplay(escalationTrackerCreation_SuccessMsg, "The Escalation Tracking record has been created successfully");
		takeScreenshotFor("Escalation Tracking Creation");

	}
	
	public void verifyLeadershipReview() {
		String status = getAttribute(traigeStageSelection, "aria-selected", "traigeStageSelection");
		if (status.equals("true")) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Triage selected by default as expected", ExtentColor.GREEN));

		} else {
			test.log(Status.FAIL, MarkupHelper.createLabel("Triage NOT selected by default as expected",
					ExtentColor.RED));
		}
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
		String leadership_ReviewStatus = getAttribute(LeadershipReview_StageSelection, "aria-selected", "LeadershipReview_StageSelection");
		if (leadership_ReviewStatus.equals("true")) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("LeadershipReview selected as expected", ExtentColor.GREEN));

		} else {
			test.log(Status.FAIL, MarkupHelper.createLabel("LeadershipReview NOT selected as expected",
					ExtentColor.RED));
		}
		
		jsClickOn(editLeadershipDisposition, "editLeadershipDisposition");
		jsClickOn(leadershipDsipositionDropdown, "leadershipDsipositionDropdown");
		jsClickOn(resolved_ApprovePackageOption, "resolved_ApprovePackageOption");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		scrollToElement(issue_Sub_Status);
		verifyTextDisplay(issue_Sub_Status, "Complete");
		takeScreenshotFor("Leadership Approved Status");
		scrollToTopofThePage();
		
		jsClickOn(editLeadershipDisposition, "editLeadershipDisposition");
		jsClickOn(leadershipDsipositionDropdown, "leadershipDsipositionDropdown");
		jsClickOn(resolved_Approved_Monitoring, "resolved_Approved_Monitoring");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		verifyTextDisplay(monitoringDAteErrorMessage, "The Monitoring End Date is a required field and must be entered.");
		scrollToTopofThePage();
		waitFor(2);
		typeText(monitoringEndDate_Input, fetchDate("M/d/yyyy", -1), leadership_ReviewStatus);
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		verifyTextDisplay(monitoringDataErrorMessage2, "Monitoring End Date must be today or a future date.");
		
		typeText(monitoringEndDate_Input, fetchDate("M/d/yyyy", 3), leadership_ReviewStatus);
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		scrollToTopofThePage();
		String monitoringAwareness_Status = getAttribute(monitoringAwarenessStatus, "aria-selected", "monitoringAwarenessStatus");
		if (monitoringAwareness_Status.equals("true")) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Stage has been moved to Monitoring / Awareness as expected", ExtentColor.GREEN));

		} else {
			test.log(Status.FAIL, MarkupHelper.createLabel("Stage has NOT been moved to Monitoring / Awareness so failed",
					ExtentColor.RED));
		}
		
		jsClickOn(editLeadershipDisposition, "editLeadershipDisposition");
		jsClickOn(leadershipDsipositionDropdown, "leadershipDsipositionDropdown");
		jsClickOn(resolved_Not_Approvable, "resolved_Not_Approvable");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
//		jsClickOn(save_Button, "save_Button");
//		waitFor(2);
		scrollToTopofThePage();
		String resolved_Status = getAttribute(resolvedStatus, "aria-selected", "resolvedStatus");
		if (resolved_Status.equals("true")) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Stage has been moved to Resolved as expected", ExtentColor.GREEN));

		} else {
			test.log(Status.FAIL, MarkupHelper.createLabel("Stage has NOT been moved to Resolved so failed",
					ExtentColor.RED));
		}
		
		jsClickOn(editLeadershipDisposition, "editLeadershipDisposition");
		jsClickOn(leadershipDsipositionDropdown, "leadershipDsipositionDropdown");
		jsClickOn(resolved_DisApproved, "resolved_DisApproved");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
//		jsClickOn(save_Button, "save_Button");
//		waitFor(2);
		
		scrollToTopofThePage();
		String resolved_StatusDisApp = getAttribute(resolvedStatus, "aria-selected", "resolvedStatus");
		if (resolved_StatusDisApp.equals("true")) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Stage status is Resolved as expected", ExtentColor.GREEN));

		} else {
			test.log(Status.FAIL, MarkupHelper.createLabel("Stage status is NOT Resolved so failed",
					ExtentColor.RED));
		}
		
		jsClickOn(editLeadershipDisposition, "editLeadershipDisposition");
		jsClickOn(leadershipDsipositionDropdown, "leadershipDsipositionDropdown");
		jsClickOn(awaiting_FollowUp, "awaiting_FollowUp");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
//		jsClickOn(save_Button, "save_Button");
//		waitFor(2);
		scrollToTopofThePage();
		String monitoringAwareness_Status_Awaiting = getAttribute(monitoringAwarenessStatus, "aria-selected", "monitoringAwarenessStatus");
		if (monitoringAwareness_Status_Awaiting.equals("true")) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Stage has been moved to Monitoring / Awareness as expected", ExtentColor.GREEN));

		} else {
			test.log(Status.FAIL, MarkupHelper.createLabel("Stage has NOT been moved to Monitoring / Awareness so failed",
					ExtentColor.RED));
		}
		
		jsClickOn(editLeadershipDisposition, "editLeadershipDisposition");
		jsClickOn(leadershipDsipositionDropdown, "leadershipDsipositionDropdown");
		jsClickOn(underReview, "underReview");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
//		jsClickOn(save_Button, "save_Button");
//		waitFor(2);
		scrollToTopofThePage();
		String underReview_Status = getAttribute(monitoringAwarenessStatus, "aria-selected", "monitoringAwarenessStatus");
		if (underReview_Status.equals("true")) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Stage is Monitoring / Awareness as expected", ExtentColor.GREEN));

		} else {
			test.log(Status.FAIL, MarkupHelper.createLabel("Stage is NOT Monitoring / Awareness so failed",
					ExtentColor.RED));
		}
		
		jsClickOn(editLeadershipDisposition, "editLeadershipDisposition");
		jsClickOn(leadershipDsipositionDropdown, "leadershipDsipositionDropdown");
		jsClickOn(Other_Option, "Other_Option");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
//		jsClickOn(save_Button, "save_Button");
//		waitFor(2);
		verifyTextDisplay(completedThisField, "Complete this field.");
		scrollToBottomOfthePage();
		scrollByPixels(-400);
		typeText(otherDisposition_Reason, "Text", "otherDisposition_Reason");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		scrollToTopofThePage();
		String resolved_StatusOther = getAttribute(resolvedStatus, "aria-selected", "resolvedStatus");
		if (resolved_StatusOther.equals("true")) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Stage status is Resolved as expected", ExtentColor.GREEN));

		} else {
			test.log(Status.FAIL, MarkupHelper.createLabel("Stage status is NOT Resolved so failed",
					ExtentColor.RED));
		}
		
		
	}
	
	
	
	
	
	
	
	
	

}// ENd of the Class
