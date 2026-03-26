package com.CertificationWorkflow_Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.CertificationWorkflow_Loc.CW_CreationPage_Loc;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.utility.SafeActions;

public class CW_CreationPage extends SafeActions implements CW_CreationPage_Loc {

	public void verifying_Mandatory_Fields_CW_Creation_Form() {
		jsClickOn(new_Button, "new_Button");
		waitFor(3);
		jsClickOn(save_Button, "save_Button");
		waitFor(3);
		verifyTextDisplay(stateMedicaidAgencyIs_required, "State Medicaid Agency is required.");
		verifyTextDisplay(reviewType_ErrorMessage, "Select at least one Review Type.");
		verifyTextDisplay(certification_ModuleIs_Required, "Certification Module is required.");
		verifyTextDisplay(requestDate_Is_Required, "Request Date is required.");
		verifyTextDisplay(ORR_Date_is_required, "ORR Date is required.");
		verifyTextDisplay(Submission_Date_is_required, "Submission Date is required.");
		verifyTextDisplay(reviewDateIsRequired, "Review Date is required.");
		verifyTextDisplay(fileUplaodErrorMessage, "Maximum file size is 4MB. Larger file sizes can be added via the Box tab after submitting.");
		jsClickOn(fileUplaodErrorMessage, "fileUplaodErrorMessage");
		
		jsClickOn(Certification_Request_Date_Input, "Certification_Request_Date_Input");
		typeText(Certification_Request_Date_Input, fetchWeekdayDate("MMM d, yyyy", 1), "Certification_Request_Date_Input");
		typeText(ORR_Date_Input, fetchWeekdayDate("MMM d, yyyy", 1), "ORR_Date_Input");
		typeText(submission_Date_Input, fetchWeekdayDate("MMM d, yyyy", 1), "submission_Date_Input");
		typeText(certifcation_Review_Date, fetchWeekdayDate("MMM d, yyyy", 1), "certifcation_Review_Date");
		jsClickOn(save_Button, "save_Button");
		System.out.println("Clicked on Save button");
		waitFor(2);
		scrollToElement(save_Button);
		scrollToBottomOfthePage();
		jsClickOn(certifcation_Review_Date, "certifcation_Review_Date");
		typeText(certifcation_Review_Date, fetchWeekdayDate("MMM d, yyyy", 2), "certifcation_Review_Date");
		jsClickOn(Executive_Summary, "Executive_Summary");
		typeText(executive_Summary_, "Test", "executive_Summary_");
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		verifyTextDisplay(RequestDate_CannotBeFuture_ErrorMsg, "Request Date cannot be in the future.");
		verifyTextDisplay(ORR_Date_CannotBeFuture_ErrorMsg, "ORR Date cannot be in the future.");
		verifyTextDisplay(Submission_Date_CannotBeFuture_ErrorMsg, "Submission Date cannot be in the future.");
		verifyTextDisplay(Review_Date_CannotBeFuture_ErrorMsg, "Review Date cannot be in the future.");
		
		typeText(Certification_Request_Date_Input, fetchWeekendDate("MMM d, yyyy", -1), "Certification_Request_Date_Input");
		typeText(ORR_Date_Input, fetchWeekendDate("MMM d, yyyy", -1), "ORR_Date_Input");
		typeText(submission_Date_Input, fetchWeekendDate("MMM d, yyyy", -1), "submission_Date_Input");
		typeText(certifcation_Review_Date, fetchWeekendDate("MMM d, yyyy", -1), "certifcation_Review_Date");
		typeText(executive_Summary_, "Testing", "executive_Summary_");
		scrollToElement(save_Button);
		scrollToBottomOfthePage();
		jsClickOn(save_Button, "save_Button");
		waitFor(2);
		int count = driver.findElements(weekend_Holiday_ErrorMessage).size();
		System.out.println("");
		if(count == 4) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("weekend_Holiday_ErrorMessage is displayed", ExtentColor.BLUE));
		} else {
			test.log(Status.INFO,
					MarkupHelper.createLabel("weekend_Holiday_ErrorMessage is NOT displayed", ExtentColor.BLUE));
		}
	}
	
	Robot rb;
	
	public static String CW_Title_text = "";
	
	public void create_Certification_Workflow() {
		
		typeText(State_Medicaid_Agency, getRandomStateInitial_(), "State_Medicaid_Agency");
		waitFor(1);
		jsClickOn(stateMedicaidOption, "stateMedicaidOption");
		jsClickOn(CAP_Request, "CAP_Request");
		jsClickOn(moveToSelected, "moveToSelected");
		jsClickOn(Demo, "Demo");
		jsClickOn(moveToSelected, "moveToSelected");
		jsClickOn(Certification_Module, "Certification_Module");
		int index = getRandom1to15();
		By certificationMod_Random = By.xpath("//*[text()='Certification Module']/following::button[1]/following::lightning-base-combobox-item["+index+"]");
		jsClickOn(certificationMod_Random, "certificaation_Module_Option");
		
		typeText(Certification_Request_Date_Input, fetchWeekdayDate("MMM d, yyyy", -1), "Certification_Request_Date_Input");
		typeText(ORR_Date_Input, fetchWeekdayDate("MMM d, yyyy", -1), "ORR_Date_Input");
		typeText(submission_Date_Input, fetchWeekdayDate("MMM d, yyyy", -1), "submission_Date_Input");
		typeText(certifcation_Review_Date, fetchWeekdayDate("MMM d, yyyy", -1), "certifcation_Review_Date");
		typeText(executive_Summary_, "Testing Updated", "executive_Summary_");
//		
//		jsClickOn(uploadFiles, "uploadFiles");
//		waitFor(5);
//		
//		try {
//			rb = new Robot();
//		} catch (AWTException e) {
//		}
//		String filePath = System.getProperty("user.dir")
//				+ "\\src\\test\\resources\\data\\RAI Closeout Process and Closeout Email Template (2).docx";
//		StringSelection str = new StringSelection(filePath);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
//		waitFor(2);
//		rb.keyPress(KeyEvent.VK_CONTROL);
//		rb.keyPress(KeyEvent.VK_V);
//		waitFor(2);
//		rb.keyRelease(KeyEvent.VK_CONTROL);
//		rb.keyRelease(KeyEvent.VK_V);
//		waitFor(2);
//		rb.keyPress(KeyEvent.VK_ENTER);
//		rb.keyRelease(KeyEvent.VK_ENTER);
//		waitFor(2);
//		jsClickOn(done_Button, "done_Button");
		takeScreenshotFor("before submitting the form");
		jsClickOn(save_Button, "save_Button");
		waitFor(1);
		verifyTextDisplay(successMessage, "Certification Workflow created");
		takeScreenshotFor("After submitting the form");
		waitFor(5);
		CW_Title_text = getTextFromUI(CW_Title, "CW_Title_text");
	}

}
