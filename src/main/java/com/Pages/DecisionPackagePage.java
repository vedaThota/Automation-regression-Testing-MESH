package com.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import com.Locators.DecisionPackage_Loc;
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
		scrollToBottomOfthePage();
		jsClickOn(submitButton, "submitButton");
		waitFor(1);
		verifyTextDisplay(Acknowledgement_Date_is_required, "Acknowledgement date cannot be a future date.");
		verifyTextDisplay(At_least_one_OpDiv_must_be_selected, "At least one OpDiv must be selected.");
		verifyTextDisplay(Maximum_file_size_is_4MB, "Maximum file size is 4MB.");
		takeScreenshotFor("Seccond half of validation form ");
	}

	Robot rb;

	public void verifyUserCanCreate_DecisionPackage() {
		scrollToTopofThePage();
		String randomChar = Character.toString(getRandomStateInitial());
		typeText(State_Medicaid_Agency_Input, randomChar, "State_Medicaid_Agency_Input");
		jsClickOn(State_Medicaid_Agency_Option, "State_Medicaid_Agency_Option");
		jsClickOn(Submission_Type, "Submission_Type");
		jsClickOn(SubmissionTypeOption, "SubmissionTypeOption - APD");
		jsClickOn(fundType_E_E, "fundType_E_E");
		typeText(estimatedAmount, "1000", "estimatedAmount");
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

	public void verifyMandatoryFields_OnDecisionPackage() {
		waitFor(2);
		String directorState = getTextFromUI(State_Medicaid_Agency, "State_Medicaid_Agency");
		System.out.println("directorName: " + directorState);
		verifyTextDisplay(decisionPackageTitle, "E&E-HHS-APD-Emergency Request");
		takeScreenshotFor("After Decision Package created verifying title");
		jsClickOn(Edit_Recommended_Action, "Edit_Recommended_Action");
		jsClickOn(Recommended_Action, "Recommended_Action");
		waitFor(2);
		jsClickOn(Approve_Option, "Approve_Option");

		typeText(State_Medicaid_Director_Input, directorState.split(" ")[0], "State_Medicaid_Director_Input");
		waitFor(5);
		String directorName = getAttribute(state_Medicaid_Director_Option, "title", "state_Medicaid_Director_Option");
		System.out.println("directorName: " + directorName);
		jsClickOn(state_Medicaid_Director_Option, "state_Medicaid_Director_Option");
		scrollToBottomOfthePage();
		jsClickOn(APD_Type, "APD_Type");
		jsClickOn(APD_Type_Option, "APD_Type_Option");
		jsClickOn(event_Summary_TextArea, "event_Summary_TextArea");
		waitFor(2);
		typeText(event_Summary_TextArea_AfterClick, "Event Summary Added", "event_Summary_TextArea_");
		waitFor(1);
		jsClickOn(APD_Update_Type, "APD_Update_Type");
		jsClickOn(APD_Update_Type_Add_Button, "APD_Update_Type_Add_Button");

		takeScreenshotFor("Star Fields before submit");
		jsClickOn(save_Button, "save_Button");
		waitFor(3);
		verifyTextDisplay(approveChoosen, "Approve");
		verifyTextDisplay(APD_Type_Choosen, "Planning Advanced Planning Document (PAPD)");
		verifyTextDisplay(APD_Update_Type_Choosen, "Initial Submission");
		verifyTextDisplay(stateMedicaidDirector_selected, directorName);
		scrollToBottomOfthePage();
		verifyTextDisplay(event_Summary_Entered, "Event Summary Added");
		scrollToTopofThePage();
		takeScreenshotFor("First half of the screen with Updated Mandatory fields");
		scrollToBottomOfthePage();
		takeScreenshotFor("Second half of the screen with Updated Mandatory fields");

	}
}
