package com.Locators;

import org.openqa.selenium.By;

public interface Escalation_Tracking_Locators {
	
	
	public static By escalationTracking_Tab = By.xpath("(//a[@href='/lightning/o/Escalation_Tracking__c/home'])[last()]");
	public static By newButton = By.xpath("//a[@title='New']");
	public static By relatedToDP_Yes = By.xpath("//*[text()='Related to Decision Package?']/following::input[1]");
	public static By submitButton = By.xpath("//*[text()='Submit']");
	public static By StateMedicaidAgencyismissing = By.xpath("//*[text()='State Medicaid Agency is missing.']");
	public static By DecisionPackageismissing = By.xpath("//*[text()='Decision Package is missing.']");
	public static By TitleIsMissing = By.xpath("//*[text()='Title is missing.']");
	public static By issueDescriptionIsMissing = By.xpath("//*[text()='Issue Description is missing.']");
	public static By RecommendationIsMissing = By.xpath("//*[text()='Recommendation is missing.']");
	public static By RiskImpactScoreIsMissing = By.xpath("//*[text()='Risk Impact Score is missing.']");
	public static By escalationTrackerCreation_SuccessMsg = By.xpath("//*[contains(text(),'The Escalation Tracking record has been created successfully')]");
	
	public static By pleaseSelectYesOrNo = By.xpath("//*[text()='Please select Yes or No.']");
	public static By ImpactedMESBusinessIsMissing = By.xpath("//*[text()='Impacted MES Business Area is missing.']");
	public static By ResolutionNededByIsMissing = By.xpath("//*[text()='Resolution Needed By is missing.']");
	public static By maximumFileSizeLimit = By.xpath("//*[contains(text(), 'Maximum file size is 4MB.')]");
	
	public static By stateMedicalAgency_Input = By.xpath("//*[text()='State Medicaid Agency']/following::input[1]");
	public static By stateMedicalAgency_Option = By.xpath("//*[text()='State Medicaid Agency']/following::input[1]/following::lightning-base-combobox-item/span[2]");
	public static By DecisionPackage_Option = By.xpath("//*[text()='Decision Package Lookup']/following::input[1]/following::lightning-base-combobox-item/span[2]");
	public static By DecisionPackage_Input = By.xpath("//*[text()='Decision Package Lookup']/following::input[1]");
	public static By titleInput = By.xpath("(//*[text()='Title']/following::input[1])[last()]");
	public static By issueDescription = By.xpath("//*[text()='Issue Description']/following::textarea[1]");
	public static By recomendationbutton = By.xpath("//*[text()='Recommendation']/following::button[1]");
	public static By recommendationOption = By.xpath("//*[text()='Recommendation']/following::button[1]/following::lightning-base-combobox-item[1]");
	public static By riskImpactButton = By.xpath("//*[text()='Risk Impact Score']/following::button[1]");
	public static By riskImpactOption = By.xpath("//*[text()='Risk Impact Score']/following::button[1]/following::lightning-base-combobox-item[1]");
	public static By potentialImpactAccess_Yes = By.xpath("//*[text()='Potential Impact to Access Benefits?']/following::input[@value='Yes']");
	public static By bussinessImpactArea_Button = By.xpath("//*[text()='Impacted MES Business Area']/following::button[1]");
	public static By bussinessImpactArea_Option = By.xpath("//*[text()='Impacted MES Business Area']/following::button[1]/following::lightning-base-combobox-item[1]");
	public static By resolutionNeededBy_Input = By.xpath("//*[text()='Resolution Needed By']/following::input");

	public static By traigeStageSelection = By.xpath("//a[@title='Needs Triage']");
	public static By issue_Sub_Status = By.xpath("//*[text()='Issue Sub-Status']/../following-sibling::div//lightning-formatted-text");
	public static By editLeaderShipAssigned = By.xpath("//button[@title='Edit Leadership Assigned']");
	public static By leadershipAssigngedInput = By.xpath("//*[text()='Leadership Assigned']/following::input[1]");
	public static By leadershipAssignedOption = By.xpath("//*[text()='Leadership Assigned']/following::lightning-base-combobox-item[2]");
	public static By LeadershipReview_StageSelection = By.xpath("//a[@title='Leadership Review']");
	public static By editLeadershipDisposition = By.xpath("//button[@title='Edit Leadership Disposition']");
	
	public static By leadershipDsipositionDropdown = By.xpath("//*[text()='Leadership Disposition']/following::button[1]");
	public static By resolved_ApprovePackageOption = By.xpath("//*[@title='Resolved - Approve Package']");
	
	public static By monitoringDAteErrorMessage = By.xpath("//*[text()='The Monitoring End Date is a required field and must be entered.']");
	public static By monitoringDataErrorMessage2 = By.xpath("//*[text()='Monitoring End Date must be today or a future date.']");
	public static final By save_Button = By.xpath("(//button[text()='Save'])[last()]");
	public static By monitoringEndDate_Input = By.xpath("//*[text()='Monitoring End Date']/following::input[1]");
	public static By resolved_Approved_Monitoring = By.xpath("//*[@title='Resolved - Approved but Monitoring']");
	
	public static By monitoringAwarenessStatus = By.xpath("//a[@title='Monitoring / For Awareness']");
	public static By resolved_Not_Approvable = By.xpath("//*[@title='Resolved - Not Approvable']");
	public static By resolvedStatus = By.xpath("//*[@title='Resolved']");
	public static By resolved_DisApproved = By.xpath("//*[@title='Resolved - Disapproved']");
	public static By awaiting_FollowUp = By.xpath("//*[@title='Awaiting Follow-Up']");
	public static By underReview = By.xpath("//*[@title='Under Review']");
	public static By Other_Option = By.xpath("//*[@title='Other']");
	public static By completedThisField = By.xpath("//*[text()='Complete this field.']");
	public static By otherDisposition_Reason = By.xpath("//*[text()='Other Disposition']/following::textarea");
//	public static By packageSO_Updates_Link = By.xpath("vfdnvfdkjvnkfvf");
//	public static By packageSO_Updates_Link = By.xpath("vfdnvfdkjvnkfvf");
//	public static By packageSO_Updates_Link = By.xpath("vfdnvfdkjvnkfvf");
//	public static By packageSO_Updates_Link = By.xpath("vfdnvfdkjvnkfvf");
//	public static By packageSO_Updates_Link = By.xpath("vfdnvfdkjvnkfvf");
	

	
}