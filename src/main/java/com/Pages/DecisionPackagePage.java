package com.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.Locators.DecisionPackage_Loc;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.utility.SafeActions;

public class DecisionPackagePage extends SafeActions implements DecisionPackage_Loc {

	public void validateMandatoryFieldsErrorMessages() {

		jsClickOn(newDecisionPackage, "newDecisionPackage");

		typeText(submitDate, fetchWeekdayDate("MMM dd, yyyy", 2), "submitDate");
		typeText(acknowledgementDate, fetchWeekdayDate("MMM dd, yyyy", 2), "acknowledgementDate");
		jsClickOn(submitButton, "submitButton");
		waitFor(1);
		verifyTextDisplay(State_Medicaid_Agency_is_required, "State Medicaid Agency is required.");
		verifyTextDisplay(Submission_Type_is_required, "Submission Type is required.");
		verifyTextDisplay(At_least_one_Funding_Type_must_be_selected, "At least one Funding Type must be selected.");
		verifyTextDisplay(Submission_Date_is_required, "Submission Date must be today or earlier.");
		takeScreenshotFor("First half of validation form");
		jsClickOn(Emergency_Request, "Emergency_Request");
		waitFor(2);
		jsClickOn(Emergency_Request, "Emergency_Request");
		waitFor(2);
		scrollToBottomOfthePage();
		jsClickOn(submitButton, "submitButton");
		waitFor(1);
		verifyTextDisplay(Acknowledgement_Date_is_required, "Acknowledgement date cannot be a future date.");
		verifyTextDisplay(At_least_one_OpDiv_must_be_selected, "At least one OpDiv must be selected.");
		verifyTextDisplay(Maximum_file_size_is_4MB, "Maximum file size is 4MB.");
		takeScreenshotFor("Seccond half of validation form ");
	}

	Robot rb;

	public void verifyUserCanCreate_DecisionPackage(By submisionTypeLoc, String text) {
		scrollToTopofThePage();
		String randomChar = Character.toString(getRandomStateInitial());
		waitFor(2);
		typeText(State_Medicaid_Agency_Input, randomChar, "State_Medicaid_Agency_Input");
		jsClickOn(State_Medicaid_Agency_Option, "State_Medicaid_Agency_Option");
		jsClickOn(Submission_Type, "Submission_Type");
		jsClickOn(submisionTypeLoc, "SubmissionTypeOption");
		jsClickOn(fundType_E_E, "fundType_E_E");
		if (text.contains("APD")) {
			typeText(estimatedAmount, "1000", "estimatedAmount");
		}
		typeText(submitDate, fetchWeekdayDate("MMM dd, yyyy", -1), "submitDate");
		typeText(acknowledgementDate, fetchWeekdayDate("MMM dd, yyyy", -1), "acknowledgementDate");
		jsClickOn(oPsDiv_HHS, "oPsDiv_HHS");
		takeScreenshotFor("Filling the form before the file upload");
		jsClickOn(uploadFiles, "uploadFiles");
		waitFor(5);
		try {
			rb = new Robot();
		} catch (AWTException e) {
		}
		String filePath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\data\\RAI Closeout Process and Closeout Email Template (2).docx";
		StringSelection str = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		waitFor(2);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		waitFor(2);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		waitFor(2);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		waitFor(2);
		jsClickOn(done_Button, "done_Button");
		takeScreenshotFor("before submitting the form");
		jsClickOn(submitButton, "submitButton");
//		waitFor(1);
		verifyTextDisplay(successMessage, "The Decision Package has been Created Sucessfully");
		takeScreenshotFor("After submitting the form");

	}

	public String decisionTitle = "";
	public void verifyMandatoryFields_OnDecisionPackage(String title, String submisionType) {
		waitFor(5);
		stateMedicaidAgency = getTextFromUI(State_Medicaid_Agency, "State_Medicaid_Agency");
		System.out.println("stateMedicaidAgency: " + stateMedicaidAgency);
		waitFor(4);
		decisionTitle = getTextFromUI(decisionPackageTitle, "decisionPackageTitle");
		String directorState = getTextFromUI(State_Medicaid_Agency, "State_Medicaid_Agency");
		System.out.println("directorName: " + directorState);
		
		verifyTextDisplay(decisionPackageTitle, title);
		takeScreenshotFor("After Decision Package created verifying title");
		jsClickOn(Edit_Recommended_Action, "Edit_Recommended_Action");
		waitFor(1);
		jsClickOn(Recommended_Action, "Recommended_Action");
		waitFor(2);
		jsClickOn(Approve_Option, "Approve_Option");
		jsClickOn(event_Summary_TextArea, "event_Summary_TextArea");
		waitFor(2);
		jsClickOn(event_Summary_TextArea_AfterClick, "event_Summary_TextArea_AfterClick");
		waitFor(2);
		typeText(event_Summary_TextArea_AfterClick, "Event Summary Added", "event_Summary_TextArea_");
		waitFor(5);
		typeText(State_Medicaid_Director_Input, directorState.split(" ")[0], "State_Medicaid_Director_Input");
		waitFor(5);
		String directorName = getAttribute(state_Medicaid_Director_Option, "title", "state_Medicaid_Director_Option");
		System.out.println("directorName: " + directorName);
		jsClickOn(state_Medicaid_Director_Option, "state_Medicaid_Director_Option");
		scrollToBottomOfthePage();
		if (submisionType.contains("APD")) {
			jsClickOn(APD_Type, "APD_Type");
			jsClickOn(APD_Type_Option, "APD_Type_Option");
		}
		
		
		if (submisionType.contains("APD")) {
			jsClickOn(APD_Update_Type, "APD_Update_Type");
			jsClickOn(APD_Update_Type_Add_Button, "APD_Update_Type_Add_Button");
		}
		takeScreenshotFor("Mandatory Fields before submit");
		jsClickOn(save_Button, "save_Button");
		waitFor(3);
		verifyTextDisplay(approveChoosen, "Approve");
		if (submisionType.contains("APD")) {
			verifyTextDisplay(APD_Type_Choosen, "Planning Advanced Planning Document (PAPD)");
			verifyTextDisplay(APD_Update_Type_Choosen, "Initial Submission");
		}
		verifyTextDisplay(stateMedicaidDirector_selected, directorName);
		scrollToBottomOfthePage();
		verifyTextDisplay(event_Summary_Entered, "Event Summary Added");
		scrollToTopofThePage();
		takeScreenshotFor("First half of the screen with Updated Mandatory fields");
		scrollToBottomOfthePage();
		takeScreenshotFor("Second half of the screen with Updated Mandatory fields");

	}
	
	public String stateMedicaidAgency = "";
	public void verifyMandatoryFieldsOn_Contract_DecisionPackage(String title) {
		waitFor(2);
		stateMedicaidAgency = getTextFromUI(State_Medicaid_Agency, "State_Medicaid_Agency");
		System.out.println("stateMedicaidAgency: " + stateMedicaidAgency);
		verifyTextDisplay(decisionPackageTitle, title);
		takeScreenshotFor("After Decision Package created verifying title");
		jsClickOn(Edit_Recommended_Action, "Edit_Recommended_Action");
		waitFor(1);
		jsClickOn(Recommended_Action, "Recommended_Action");
		waitFor(2);
		jsClickOn(Approve_Option, "Approve_Option");
		jsClickOn(event_Summary_TextArea, "event_Summary_TextArea");
		waitFor(2);
		jsClickOn(event_Summary_TextArea_AfterClick, "event_Summary_TextArea_AfterClick");
		waitFor(2);
		typeText(event_Summary_TextArea_AfterClick, "Event Summary Added", "event_Summary_TextArea_");
		waitFor(5);
		typeText(State_Medicaid_Director_Input, stateMedicaidAgency.split(" ")[0], "State_Medicaid_Director_Input");
		waitFor(5);
		String directorName = getAttribute(state_Medicaid_Director_Option, "title", "state_Medicaid_Director_Option");
		System.out.println("directorName: " + directorName);
		jsClickOn(state_Medicaid_Director_Option, "state_Medicaid_Director_Option");
		scrollToBottomOfthePage();
		typeText(ContractNumber, "ABC"+fetchDate("yyyy", 4), "ContractNumber");
		jsClickOn(contractType, "contractType");
		jsClickOn(contracType_SoleSource, "contracType_SoleSource");
		typeText(Total_ContractValue, "1000", "Total_ContractValue");
		typeText(vendor, "test", "Vendor");
		waitFor(1);
		jsClickOn(vendorOption, "vendorOption");
		jsClickOn(claimsProcessing_CheckBox, "claimsProcessing_CheckBox");
		jsClickOn(auditingCheckBox, "auditingCheckBox");
		takeScreenshotFor("Mandatory Fields before submit");
		jsClickOn(save_Button, "save_Button");
		waitFor(3);
		verifyTextDisplay(approveChoosen, "Approve");
		verifyTextDisplay(stateMedicaidDirector_selected, directorName);
		
		scrollByPixels(200);
		verifyTextDisplay(event_Summary_Entered, "Event Summary Added");
		scrollToTopofThePage();
		takeScreenshotFor("First half of the screen for contract Type");
		scrollByPixels(500);
		takeScreenshotFor("Second half of the screen for contract Type");

	}

	public void verifyDueDate(String screenshotName) {
		waitFor(3);
		jsClickOn(decisionPackageTitle, "decisionPackageTitle");
		scrollToBottomOfthePage();
		String date1 = getTextFromUI(acknowledgementDate_LabelText, "acknowledgementDate").split(",")[0];
		String date2 = getTextFromUI(dueDate, "dueDate").split(",")[0];
		String duedays = getTextFromUI(daysUntilDue, "daysUntilDue");
		takeScreenshotFor(screenshotName);
		int duedateFromDates = findTheDifference_Between(date1, date2);
		int dueDateDisplayed = Integer.parseInt(duedays);
		Assert.assertEquals(duedateFromDates - 1, dueDateDisplayed,
				"Due days count NOT displayed as expected so failed");
	}

	public void selectEmergencyRequestInthe_DecisionPackage() {
		jsClickOn(edit_Emergency_Request, "edit_Emergency_Request");
		jsClickOn(emergency_Request_CheckBox, "emergency_Request_CheckBox");
		jsClickOn(save_Button, "save_Button");
		waitFor(3);
		
	}
	
	public void verifyBeginReviewStatus() {
		jsClickOn(DetailsTab, "DetailsTab");
		waitFor(1);
		jsClickOn(beginReview, "beginReview");
		waitFor(1);
		verifyTextDisplay(stateOfficerReview, "State Officer Review");
		verifyTextDisplay(inReview, "In Review");		
	}
	
	public void verifyFundingTypeAmountDisplay() {
		String amountDisplay = getTextFromUI(estimatedFundingRequested, "estimatedFundingRequested");
		if(!amountDisplay.contains(".000"))
			test.log(Status.INFO, MarkupHelper.createLabel("Amount shows correctly", ExtentColor.BLUE));
		else
			test.log(Status.FAIL, MarkupHelper.createLabel("Amount shows three decimal places after decimal point", ExtentColor.RED));
	}
	
	public void verifyContractAmountDisplay() {
		String amountDisplay = getTextFromUI(totalContractValue, "totalContractValue");
		if(!amountDisplay.contains(".000"))
			test.log(Status.INFO, MarkupHelper.createLabel("Amount shows correctly", ExtentColor.BLUE));
		else
			test.log(Status.FAIL, MarkupHelper.createLabel("Amount shows three decimal places after decimal point", ExtentColor.RED));
	}
	
	public void addRelatedProject() {
		jsClickOn(RelatedProjects_button, "RelatedProjects_button");
		jsClickOn(New_Link, "RelatedProjects_button");
		jsClickOn(MDBT_Project_Tab_Name, "MDBT_Project_Tab_Name");
		jsClickOn(NewProject, "NewProject");
		String stateShortForm = decisionTitle.split("-")[0];
		String text = generateRandomString(10);
		takeScreenshotFor("Adding new project form screenshot");
		typeText(newProject_MDBT_Project_Tab_Name, stateShortForm+"-"+text, "newProject_MDBT_Project_Tab_Name");
		typeText(newProject_FullName, stateShortForm+"-"+text+" Full", "newProject_FullName");
		typeText(newProject_State_Medicaid_Agency, stateMedicaidAgency, "newProject_State_Medicaid_Agency");
		jsClickOn(newProject_State_Medicaid_Agency_Option, "newProject_State_Medicaid_Agency_Option");
		jsClickOn(fundingType_EandE, "fundingType_EandE");
		jsClickOn(newProject_FundType_AddButton, "newProject_FundType_AddButton");
		jsClickOn(systemTypeButton, "systemTypeButton");
		jsClickOn(newSystem, "newSystem");
		takeScreenshotFor("Before related project added screenshot");
		waitFor(3);
		jsClickOn(save_Button, "save_Button");
		
		takeScreenshotFor("New Project Created screenshot");
		
	}
	
	public void closeOtherWindows() {
		driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(0));
		driver.close();
		driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(0));
		driver.close();
		driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
		driver.close();
		driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(0));
	}
	
	public void verifyTemplateGeneration() {
		jsClickOn(generateTemplate, "generateTemplate");
		jsClickOn(selectATemplate, "selectATemplate");
		jsClickOn(templateFirstOption, "templateFirstOption");
		jsClickOn(generateWordDocument, "generateWordDocument");
		waitFor(4);
	}

}
