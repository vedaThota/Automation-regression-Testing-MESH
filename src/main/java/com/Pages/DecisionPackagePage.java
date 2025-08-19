package com.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.Locators.DecisionPackage_Loc;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.utility.SafeActions;

public class DecisionPackagePage extends SafeActions implements DecisionPackage_Loc {

	int packageCreationDuration = 0;

	public void validateMandatoryFieldsErrorMessages() {
		waitFor(3);
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
	static String stateCharacter = "";

	public void verifyUserCanCreate_DecisionPackage(By submisionTypeLoc, String text, String OPsType) {
		jsClickOn(CancelButton, "CancelButton");
		waitFor(1);
		jsClickOn(newDecisionPackage, "newDecisionPackage");
		scrollToTopofThePage();
		if (text.contains("APD"))
			stateCharacter = Character.toString(getRandomStateInitial());
		waitFor(2);
		typeText(State_Medicaid_Agency_Input, stateCharacter, "State_Medicaid_Agency_Input");
		jsClickOn(State_Medicaid_Agency_Option, "State_Medicaid_Agency_Option");
		jsClickOn(Submission_Type, "Submission_Type");
		jsClickOn(submisionTypeLoc, "SubmissionTypeOption");
		jsClickOn(fundType_E_E, "fundType_E_E");
		if (text.contains("APD")) {
			typeText(estimatedAmount, "1000", "estimatedAmount");
		}
		typeText(submitDate, fetchWeekdayDate("MMM dd, yyyy", packageCreationDuration), "submitDate");
		jsClickOn(acknowledgementDate, "acknowledgementDate");
		typeText(acknowledgementDate, fetchWeekdayDate("MMM dd, yyyy", packageCreationDuration), "acknowledgementDate");
		if (OPsType.contains("HHS"))
			jsClickOn(oPsDiv_HHS, "oPsDiv_HHS");
		if (OPsType.contains("CMS"))
			jsClickOn(oPsDiv_CMS, "oPsDiv_CMS");
		if (OPsType.contains("FNS"))
			jsClickOn(oPsDiv_FNS, "oPsDiv_FNS");

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

	public void verifyFileUpload(String Type) {

		try {
			rb = new Robot();
		} catch (AWTException e) {
		}
		waitFor(5);
		scrollToTopofThePage();
		switchToFrame(parentBoxFrame);
		waitFor(1);
		switchToFrame(boxFrame);
		waitFor(2);
		jsClickOn(fileUploadNewButton, "fileUploadNewButton");
		waitFor(2);
		jsClickOn(fileUploadButton, "fileUploadButton");
		waitFor(1);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_ENTER);
		System.out.println("KeyPress");
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Key release");
		waitFor(2);
		driver.switchTo().defaultContent();
		String filePath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\data\\FilesUpload\\2-Proposed Process JIRA SOP.pdf";
		StringSelection str = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		waitFor(2);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		waitFor(2);
		System.out.println("File Path");
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		waitFor(2);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		scrollToTopofThePage();
		takeScreenshotFor("Before File Upload for " + Type);
		waitFor(5);
		scrollToTopofThePage();
		takeScreenshotFor("File Uploaded successfully for " + Type);
	}

	public String verifyFileName(String type) {
		String condition = "";
		File folder = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\data\\FilesDownload");
		File[] listOfFiles = folder.listFiles();
		if (listOfFiles != null) {
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					String fileName = listOfFiles[i].getName();
					System.out.println("File " + fileName);
					if (fileName.contains(fetchDate("yyyy-MM-dd", packageCreationDuration))
							&& fileName.contains(type)) {
						condition = fileName;
						break;
					}
				}
			}
		}
		return condition;
	}

	public void verifyDownloadFile(String type) {
		switchToFrame(parentBoxFrame);
		waitFor(1);
		switchToFrame(boxFrame);
		waitFor(2);
		new Actions(driver).moveToElement(driver.findElement(selectFile)).build().perform();

//		jsClickOn(selectFile, "selectFile");
		waitFor(2);
		jsClickOn(fileCheckbox, "fileCheckbox");
		waitFor(2);
		jsClickOn(moreOptions, "moreOptions");
		waitFor(2);
		jsClickOn(downloadButton, "downloadButton");
		waitFor(5);
		String isDownloaded = verifyFileName(type);
		System.out.println("File Name : " + isDownloaded);
		if (!isDownloaded.isEmpty())
			test.log(Status.INFO,
					MarkupHelper.createLabel("File downloaded with name - " + isDownloaded, ExtentColor.GREEN));
		else
			test.log(Status.FAIL, MarkupHelper.createLabel("File NOT downloaded", ExtentColor.RED));
		driver.switchTo().defaultContent();
		deleteAllFilesAfter_Verification();
	}

	public void deleteAllFilesAfter_Verification() {
		try {
			Files.walk(Paths.get(System.getProperty("user.dir") + "\\src\\test\\resources\\data\\FilesDownload"))
					.filter(Files::isRegularFile).map(Path::toFile).forEach(File::delete);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String decisionTitle = "";
	public String decisionPackageTitle_APD = "";
	public static String directorState = "";
	public static String rfpTitle = "";
	public static String contractTitle = "";

	public void verifyMandatoryFields_OnDecisionPackage(String title, String submisionType) {
		waitFor(5);
		stateMedicaidAgency = getTextFromUI(State_Medicaid_Agency, "State_Medicaid_Agency");
		System.out.println("stateMedicaidAgency: " + stateMedicaidAgency);
		waitFor(4);
		decisionTitle = getTextFromUI(decisionPackageTitle, "decisionPackageTitle");
		if(submisionType.contains("RFP")){
				rfpTitle = decisionTitle;
		}
	   System.out.println("Decision Package Title: " + decisionTitle);
		directorState = getTextFromUI(State_Medicaid_Agency, "State_Medicaid_Agency");
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
		waitFor(2);
		scrollByPixels(-500);
		waitFor(3);
		typeText(State_Medicaid_Director_Input, directorState.split(" ")[0], "State_Medicaid_Director_Input");
		waitFor(5);
		String directorName = getAttribute(state_Medicaid_Director_Option, "title", "state_Medicaid_Director_Option");
		System.out.println("directorName: " + directorName);
		jsClickOn(state_Medicaid_Director_Option, "state_Medicaid_Director_Option");
		scrollToBottomOfthePage();
		if (submisionType.contains("APD")) {
			jsClickOn(APD_Type, "APD_Type");
			jsClickOn(APD_Type_Option, "APD_Type_Option");
			decisionPackageTitle_APD = decisionTitle;
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

	public static String stateMedicaidAgency = "";

	public void verifyMandatoryFieldsOn_Contract_DecisionPackage(String title) {
		waitFor(5);
		stateMedicaidAgency = getTextFromUI(State_Medicaid_Agency, "State_Medicaid_Agency");
		System.out.println("stateMedicaidAgency: " + stateMedicaidAgency);
		contractTitle = getTextFromUI(decisionPackageTitle, "decisionPackageTitle");
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
		waitFor(2);
		scrollByPixels(-500);
		waitFor(3);
		typeText(State_Medicaid_Director_Input, stateMedicaidAgency.trim().split(" ")[0], "State_Medicaid_Director_Input");
		waitFor(5);
		String directorName = getAttribute(state_Medicaid_Director_Option, "title", "state_Medicaid_Director_Option");
		System.out.println("directorName: " + directorName);
		jsClickOn(state_Medicaid_Director_Option, "state_Medicaid_Director_Option");
		waitFor(5);
		scrollToBottomOfthePage();
		waitFor(2);
		scrollByPixels(-600);
		waitFor(2);
		scrollByPixels(-500);
		waitFor(2);
		scrollByPixels(-300);
		typeText(ContractNumber, "ABC" + fetchDate("yyyy", 4), "ContractNumber");
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
		scrollToTopofThePage();
		verifyTextDisplay(stateOfficerReview, "State Officer Review");
		verifyTextDisplay(inReview, "In Review");
	}

	public void verifyMoveToDeputyDirector_BeforeAll_Fields_Submit(String opDivType) {
		jsClickOn(cancelAndClose, "cancelAndClose");
		waitFor(3);
		jsClickOn(decisionPackageTab, "decisionPackageTab");
		By leadPackage = By.xpath("//a[@title='" + decisionPackageNameText + "']");
		waitFor(3);
		jsClickOn(leadPackage, "leadPackage");
		waitFor(3);
		jsClickOn(moveToDeputyDirector, "moveToDeputyDirector");
		verifyTextDisplay(ErrorMessage, "At least one project should be linked to the decision package., No Letter Generated, SO Clearance Checklist");
		waitFor(1);
		if(opDivType.contains("CMS")) {
		String EM_ChildPak = getTextFromUI(ErrorMessage2, "ErrorMessage2");
		if(EM_ChildPak.contains("Bundled Decision Package Errors:") && EM_ChildPak.contains("At least one project should be linked to the decision package")
				&& EM_ChildPak.contains("SO Clearance Checklist, At least one project should be linked to the decision package.") && EM_ChildPak.contains("The following Bundled Packages have a Recommended Action does not match the Lead Package:")) {
			test.log(Status.INFO, MarkupHelper.createLabel("Bundled packages error messages displayed as expected", ExtentColor.BLUE));
		} else {
			test.log(Status.FAIL, MarkupHelper.createLabel("Bundled packages error messages NOT displayed as expected", ExtentColor.RED));
		}
		waitFor(1);
	}
		takeScreenshotFor("Deputy director stage naviagtion Error message");
//		try {
//			if (driver.findElement(closeErrorPopup).isDisplayed()) {
//				jsClickOn(closeErrorPopup, "closeErrorPopup");
//			}
//		} catch (Exception e) {
//		}
	}

	public void verifyMoveToDeputyDirector_Stage() {
		scrollToBottomOfthePage();
		waitFor(3);
		jsClickOn(apdEdit, "apdEdit");
		waitFor(1);
		jsClickOn(initialSubmision, "initialSubmision");
		jsClickOn(APD_Type_Option, "APD_Type_Option");
		jsClickOn(save_Button, "save_Button");
		waitFor(3);

		jsClickOn(moveToDeputyDirector, "moveToDeputyDirector");
		takeScreenshotFor("Deputy director stage navigation success messaage");
		waitFor(5);
		String status = getAttribute(deputyDirectorTab, "aria-selected", "deputyDirectorTab");
		if (status.contains("true"))
			test.log(Status.INFO, MarkupHelper.createLabel("Moved to Deputy Director", ExtentColor.BLUE));
		else
			test.log(Status.FAIL, MarkupHelper.createLabel("Failed to Moved to Deputy Director", ExtentColor.RED));
	}

	public void verifyFundingTypeAmountDisplay() {
		String amountDisplay = getTextFromUI(estimatedFundingRequested, "estimatedFundingRequested");
		if (!amountDisplay.contains(".000"))
			test.log(Status.INFO, MarkupHelper.createLabel("Amount shows correctly", ExtentColor.BLUE));
		else
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Amount shows three decimal places after decimal point", ExtentColor.RED));
	}

	public void verifyContractAmountDisplay() {
		String amountDisplay = getTextFromUI(totalContractValue, "totalContractValue");
		if (!amountDisplay.contains(".000"))
			test.log(Status.INFO, MarkupHelper.createLabel("Amount shows correctly", ExtentColor.BLUE));
		else
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Amount shows three decimal places after decimal point", ExtentColor.RED));
	}

	public void addRelatedProject() {
		waitFor(10);
		scrollToBottomOfthePage();
		waitFor(2);
		jsClickOn(RelatedProjects_button, "RelatedProjects_button");
		waitFor(2);
		jsClickOn(New_Link, "RelatedProjects_button");
		waitFor(2);
		jsClickOn(MDBT_Project_Tab_Name, "MDBT_Project_Tab_Name");
		jsClickOn(NewProject, "NewProject");
		waitFor(2);
		String stateShortForm = decisionTitle.split("-")[0];
		String text = generateRandomString(10);
		takeScreenshotFor("Adding new project form screenshot");
		waitFor(2);
		typeText(newProject_MDBT_Project_Tab_Name, stateShortForm + "-" + text, "newProject_MDBT_Project_Tab_Name");
		typeText(newProject_FullName, stateShortForm + "-" + text + " Full", "newProject_FullName");
		typeText(newProject_State_Medicaid_Agency, stateMedicaidAgency, "newProject_State_Medicaid_Agency");
		jsClickOn(newProject_State_Medicaid_Agency_Option, "newProject_State_Medicaid_Agency_Option");
		jsClickOn(fundingType_EandE, "fundingType_EandE");
		jsClickOn(newProject_FundType_AddButton, "newProject_FundType_AddButton");
		jsClickOn(systemTypeButton, "systemTypeButton");
		jsClickOn(newSystem, "newSystem");
		takeScreenshotFor("Before related project added screenshot");
		waitFor(3);
		jsClickOn(save_Button, "save_Button");
		waitFor(3);
		jsClickOn(save_Button, "save_Button");
		takeScreenshotFor("New Project Created screenshot");

	}

	public void closeOtherWindows() {
		driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(0));
		driver.close();
		driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(0));
	}

	public void verifyTemplateGeneration() {
		jsClickOn(generateTemplate, "generateTemplate");
		jsClickOn(selectATemplate, "selectATemplate");
		jsClickOn(templateFirstOption, "templateFirstOption");
		waitFor(2);
		jsClickOn(generateWordDocument, "generateWordDocument");
		waitFor(4);
	}

	public void verifyGenerateTemplateDisappearIfRequiredFieldMiss() {
		waitFor(5);
		scrollToBottomOfthePage();
		waitFor(2);
		jsClickOn(editUpdateType, "editUpdateType");
		jsClickOn(initialSubmision, "initialSubmision");
		jsClickOn(submitback, "submitback");
		jsClickOn(save_Button, "save_Button");
		waitFor(3);
		try {
			driver.findElement(By.xpath("//*[text()='Generate Template']")).click();
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Generate Template button still displaying so failed", ExtentColor.RED));
		} catch (Exception e) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Generate Template button NOT displaying as expected", ExtentColor.GREEN));
		}
		takeScreenshotFor("Generate button Not showing on the screen");
	}

	public static String decisionPackageNameText = "";

	public void collectLeadTitle() {
		decisionPackageNameText = getTextFromUI(decisionPackageName, "decisionPackageName");
	}

	public void verifyGenerateTemplateDisappearIfSummaryFieldMiss() {
		waitFor(5);
		jsClickOn(EditStatus, "EditStatus");
		waitFor(2);
		jsClickOn(clearMedicaidDirector, "clearMedicaidDirector");
		waitFor(1);
		jsClickOn(save_Button, "save_Button");
		waitFor(3);
		try {
			driver.findElement(By.xpath("//*[text()='Generate Template']")).click();
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Generate Template button still displaying so failed", ExtentColor.RED));
		} catch (Exception e) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Generate Template button NOT displaying as expected", ExtentColor.GREEN));
		}

		takeScreenshotFor("Generate button Not showing on the screen");
		jsClickOn(EditStatus, "EditStatus");
		waitFor(2);
		scrollByPixels(400);
		jsClickOn(State_Medicaid_Director_Input, "State_Medicaid_Director_Input");
		waitFor(2);
		typeText(State_Medicaid_Director_Input, stateMedicaidAgency.trim().split(" ")[0], "State_Medicaid_Director_Input");
		waitFor(5);
		String directorName = getAttribute(state_Medicaid_Director_Option, "title", "state_Medicaid_Director_Option");
		System.out.println("directorName: " + directorName);
		jsClickOn(state_Medicaid_Director_Option, "state_Medicaid_Director_Option");
		waitFor(2);
		jsClickOn(save_Button, "save_Button");
		waitFor(3);
		takeScreenshotFor("Generate Template button enabled after all mandataory fields added");
	}

	static String str = "";
	JavascriptExecutor executor;

	public void verifyAddingBundleChanges() throws InterruptedException {
		executor = (JavascriptExecutor) driver;
		jsClickOn(decisionPackages, "decisionPackages");
		waitFor(1);
		takeScreenshotFor("Decision packages screen");
		jsClickOn(packageLink, "packageLink");
		takeScreenshotFor("navigate to recent Decision packages");
		jsClickOn(bundleButton, "bundleButton");
		waitFor(2);
		typeText(searchDecisionPackage_Input, decisionPackageTitle_APD.replace("APD", "PAPD"), "searchDecisionPackage");
		waitFor(2);
		takeScreenshotFor("Selection of now created APD Decision Package");
		jsClickOn(reviewDecisionPackageFNS, "reviewDecisionPackageFNS");
		waitFor(3);
//		jsClickOn(NameColumnHeader, "NameColumnHeader");
//		waitFor(1);
		takeScreenshotFor("Before Selection of recently created RFP and Contract Decision Packages");
		String countBeforeSelection = getTextFromUI(packageSelectionCount, "packageSelectionCount");
		By checkBox = By.xpath("//button[@title='Add "+rfpTitle+"']");
		By checkBox2 = By.xpath("//button[contains(@title, 'Add "+contractTitle+"')]");
		jsClickOn(checkBox, "checkBox");
		jsClickOn(checkBox2, "checkBox2");
		takeScreenshotFor("After Selection of recently created RFP and Contract Decision Packages");
		jsClickOn(savebundle_button, "savebundle_button");
		Thread.sleep(500);
		verifyTextDisplay(successMsg_BundleChanges, "Bundle changes saved successfully");
		takeScreenshotFor("Bundle the packages completed");
		String countAfterSelection = getTextFromUI(packageSelectionCount, "packageSelectionCount");

		int beforeCount = Integer.parseInt(countBeforeSelection) + 2;
		int afterCount = Integer.parseInt(countAfterSelection);
		if (beforeCount == afterCount) {
			test.log(Status.INFO, MarkupHelper.createLabel("Package selection count was matched", ExtentColor.GREEN));
		} else {
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Package selection count was NOT  matched", ExtentColor.RED));
		}
	}

}
