package com.Locators;

import org.openqa.selenium.By;

public interface Escalation_Tracking_Locators {

	public static By escalationTracking_Tab = By
			.xpath("(//a[@href='/lightning/o/Escalation_Tracking__c/home'])[last()]");
	public static By newButton = By.xpath("//a[@title='New']");
	public static By relatedToDP_Yes = By.xpath("//*[text()='Related to Decision Package?']/following::input[1]");
	public static By submitButton = By.xpath("//*[text()='Submit']");
	public static By StateMedicaidAgencyismissing = By.xpath("//*[text()='State Medicaid Agency is missing.']");
	public static By DecisionPackageismissing = By.xpath("//*[text()='Decision Package is missing.']");
	public static By TitleIsMissing = By.xpath("//*[text()='Title is missing.']");
	public static By issueDescriptionIsMissing = By.xpath("//*[text()='Issue Description is missing.']");
	public static By RecommendationIsMissing = By.xpath("//*[text()='Recommendation is missing.']");
	public static By RiskImpactScoreIsMissing = By.xpath("//*[text()='Risk Impact Score is missing.']");
	public static By escalationTrackerCreation_SuccessMsg = By
			.xpath("//*[contains(text(),'The Escalation Tracking record has been created successfully')]");

	public static By pleaseSelectYesOrNo = By.xpath("//*[text()='Please select Yes or No.']");
	public static By ImpactedMESBusinessIsMissing = By.xpath("//*[text()='Impacted MES Business Area is missing.']");
	public static By ResolutionNededByIsMissing = By.xpath("//*[text()='Resolution Needed By is missing.']");
	public static By maximumFileSizeLimit = By.xpath("//*[contains(text(), 'Maximum file size is 4MB.')]");

	public static By stateMedicalAgency_Input = By
			.xpath("(//*[text()='State Medicaid Agency']/following::input[1])[last()]");
	public static By stateMedicalAgency_Option = By.xpath(
			"(//*[text()='State Medicaid Agency']/following::input[1]/following::lightning-base-combobox-item/span[2])[last()]");
	public static By DecisionPackage_Option = By.xpath(
			"(//*[text()='Decision Package Lookup']/following::input[1]/following::lightning-base-combobox-item/span[2])[last()]");
	public static By DecisionPackage_Input = By
			.xpath("(//*[text()='Decision Package Lookup']/following::input[1])[last()]");
	public static By titleInput = By.xpath("(//*[text()='Title']/following::input[1])[last()]");
	public static By issueDescription = By.xpath("//*[text()='Issue Description']/following::textarea[1]");
	public static By recomendationbutton = By.xpath("//*[text()='Recommendation']/following::button[1]");
	public static By recommendationOption = By
			.xpath("//*[text()='Recommendation']/following::button[1]/following::lightning-base-combobox-item[1]");
	public static By riskImpactButton = By.xpath("(//*[text()='Risk Impact Score']/following::button[1])[last()]");
	public static By riskImpactOption = By.xpath(
			"(//*[text()='Risk Impact Score']/following::button[1]/following::lightning-base-combobox-item[1])[last()]");
	public static By riskImpactOption2 = By.xpath(
			"(//*[text()='Risk Impact Score']/following::button[1]/following::lightning-base-combobox-item[3])[last()]");
	public static By potentialImpactAccess_Yes = By
			.xpath("(//*[text()='Potential Impact to Access Benefits?']/following::input[@value='Yes'])[last()]");
	public static By bussinessImpactArea_Button = By
			.xpath("(//*[text()='Impacted MES Business Area']/following::button[1])[last()]");
	public static By bussinessImpactArea_Option = By.xpath(
			"(//*[text()='Impacted MES Business Area']/following::button[1]/following::lightning-base-combobox-item[1])[last()]");
	public static By bussinessImpactArea_Button_MES = By
			.xpath("(//*[text()='Impacted/MES Business Area']/following::button[1])[last()]");
	public static By bussinessImpactArea_MES_Option = By.xpath(
			"(//*[text()='Impacted/MES Business Area']/following::button[1]/following::lightning-base-combobox-item[3])[last()]");
	public static By resolutionNeededBy_Input = By
			.xpath("(//*[text()='Resolution Needed By']/following::input[1])[last()]");

	public static By traigeStageSelection = By.xpath("//a[@title='Needs Triage']");
	public static By issue_Sub_Status = By
			.xpath("//*[text()='Issue Sub-Status']/../following-sibling::div//lightning-formatted-text");
	public static By editLeaderShipAssigned = By.xpath("//button[@title='Edit Leadership Assigned']");
	public static By leadershipAssigngedInput = By.xpath("//*[text()='Leadership Assigned']/following::input[1]");
	public static By leadershipAssignedOption = By
			.xpath("//*[text()='Leadership Assigned']/following::ul/li/lightning-base-combobox-item");
	public static By LeadershipReview_StageSelection = By.xpath("//a[@title='Leadership Review']");
	public static By editLeadershipDisposition = By.xpath("//button[@title='Edit Leadership Disposition']");

	public static By leadershipDsipositionDropdown = By
			.xpath("//*[text()='Leadership Disposition']/following::button[1]");
	public static By resolved_Option = By.xpath(
			"//*[text()='Leadership Disposition']/following::button/following::lightning-base-combobox-item[@data-value='Resolved']");

	public static By monitoringDAteErrorMessage = By.xpath("//*[contains(text(),'Complete this field with format')]");
	public static By monitoringDataErrorMessage2 = By
			.xpath("//*[text()='Monitoring End Date must be today or a future date.']");
	public static final By save_Button = By.xpath("(//button[text()='Save'])[last()]");
	public static By monitoringEndDate_Input = By.xpath("//*[text()='Monitoring End Date']/following::input[1]");
	public static By disposition_Monitoring_Option = By.xpath(
			"//*[text()='Leadership Disposition']/following::button/following::lightning-base-combobox-item[@data-value='Monitoring']");

	public static By monitoringAwarenessStatus = By.xpath("//a[@title='Monitoring']");
	public static By resolved_Not_Approvable = By.xpath("//*[@title='Resolved - Not Approvable']");
	public static By resolvedStatus = By.xpath("//*[@title='Resolved']");
	public static By resolved_DisApproved = By.xpath("//*[@title='Resolved - Disapproved']");
	public static By awaiting_FollowUp = By.xpath("//*[@title='Awaiting Follow-Up']");
	public static By noActionNeeded = By.xpath("//*[@title='No Action Needed']");
	public static By Other_Option = By.xpath("//*[@title='Other']");
	public static By completedThisField = By.xpath("//*[text()='Complete this field.']");
	public static By otherDisposition_Reason = By.xpath("//*[text()='Other Disposition']/following::textarea");

	public static By beginReview = By.xpath("//button[text()='Begin Review']");
	public static By returnEscaltionItem = By.xpath("//button[text()='Return Escalation Item']");
	public static By comments = By.xpath("//*[text()='Comments']/following::textarea");
	public static By return_Esc_AlertMessage = By
			.xpath("//*[text()='Escalation Tracking item has been returned and is being reviewed by the creator']");

	public static By actionTakenArea = By.xpath(
			"//*[text()='Status Update/Actions Taken']/following::div[contains(@class, 'slds-rich-text-area__content')]");
	public static By actionTakenArea_ = By
			.xpath("//*[text()='Status Update/Actions Taken']/following::div[contains(@class, 'ql-editor ql-blank')]");

	public static By actionTaken_ErrorMsg = By
			.xpath("//*[text()='Please provide Status Update/Actions Taken when resolving an ET item']");
	public static By escalationLockMessage = By
			.xpath("//*[text()='The Escalation Tracking Item is Resolved and Locked.']");
	public static By cancelButton = By.xpath("//button[text()='Cancel']");
	public static By detailsTab = By.xpath("//*[text()='Details']");
	public static By relatedTab = By.xpath("//*[text()='Related']");
	public static By clearSelection = By.xpath("//button[@title='Clear Selection']");
	public static By emailAddressTextField = By.xpath("//label[text()='Email address']/following::input");

	public static By continueButton = By.xpath("//button[text()='Continue']");
	public static By passwordTextField = By.xpath("//label[text()='Password']/following::input");
	public static By loginButtonEmail = By.xpath("//button[text()='Log in']");
	public static By dateRecieved = By.xpath("//tbody/tr/td[2]/div/div[2]/p");
	public static By emailBody = By.xpath("//div[@id='mailcontainer']");

	public static By Reassign_Decision_Package = By.xpath("//button[text()='Reassign Decision Package']");
	public static By selectStateOfficer = By.xpath("//label[text()='Select State Officer']/following::input");
	public static By checkBoxOne = By.xpath("//input[@part='checkbox']/..//span[1]");
	public static By reassignPackageInput = By
			.xpath("//*[text()='Reassign 1 package(s) to New State Officer']/following::input");
	public static By reassignSuccessMessage = By.xpath("//*[text()='Decision packages reassigned successfully.']");
	public static By emailThread = By.xpath("//tbody/tr/td[2]/div/div");
	public static By emailHeader = By.xpath("//p[text()='Sandbox: Ricardo Melendez mentioned you in a comment']");
	
	public static By editTitle = By.xpath("//button[@title='Edit Title']");
	public static By issueStatus = By.xpath("//*[text()='Issue Status']/following::button[1]");
	public static By issueStatusOption = By.xpath("(//*[text()='Issue Status']/following::button[1]/following::lightning-base-combobox-item[4])[last()]");
	public static By issueSubStatus = By.xpath("//*[text()='Issue Sub-Status']/following::button[1]");
	public static By issueSubStatusOption = By.xpath("(//*[text()='Issue Sub-Status']/following::button[1]/following::lightning-base-combobox-item[5])[last()]");
	public static By viewAll = By.xpath("//*[@class='view-all-label']/..");
	
	public static By escalationTracker_Link = By.xpath("//a[@title='Escalation Tracking']/following::li[1]/a");
	public static By statusMemoTab = By.xpath("//a[text()='Status Memo']");
	public static By writeAComment = By.xpath("//input[@placeholder='Write a comment...']");
	public static By optionItem = By.xpath("//a[@class='optionItem medium']");
	public static By comment_Button = By.xpath("//button[text()='Comment']");
	
	public static By comments_TextField = By.xpath("//div[contains(@class, 'ql-editor ql-blank')]");
	public static By writeAComment_ = By.xpath("//div[@data-placeholder='Write a comment...']");
	public static By writeComments_TextField = By.xpath("//*[contains(@class, 'ql-editor slds-rich-text-area__content')]");
	public static By answerComment = By.xpath("//textarea[@placeholder='Write a comment...']");
	public static final By createEscaltionTracking = By.xpath("//*[text()='Create Escalation Tracking']");
	
//	public static By underRevieww = By.xpath("dsdfdsfdsf");
//	public static By underRevieww = By.xpath("dsdfdsfdsf");
//	public static By underRevieww = By.xpath("dsdfdsfdsf");
//	public static By underRevieww = By.xpath("dsdfdsfdsf");
//	public static By underRevieww = By.xpath("dsdfdsfdsf");
//	public static By underRevieww = By.xpath("dsdfdsfdsf");
//	public static By underRevieww = By.xpath("dsdfdsfdsf");
//	public static By underRevieww = By.xpath("dsdfdsfdsf");
//	public static By underRevieww = By.xpath("dsdfdsfdsf");
//	public static By underRevieww = By.xpath("dsdfdsfdsf");
//	public static By underRevieww = By.xpath("dsdfdsfdsf");
//	public static By underRevieww = By.xpath("dsdfdsfdsf");
//	public static By underRevieww = By.xpath("dsdfdsfdsf");

}