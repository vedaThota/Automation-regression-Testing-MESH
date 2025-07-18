package com.Mesh_TestSuites;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.Base.TestBase;
import com.Pages.ClearenceChecklist;
import com.Pages.DecisionPackagePage;
import com.Pages.HomePage;

public class DecisionPackages extends TestBase {
	HomePage homePage = new HomePage();
	DecisionPackagePage dpp = new DecisionPackagePage();
	ClearenceChecklist clearanceChecklistPage = new ClearenceChecklist();

	@Test(groups = { "Regression"})
	public void DecisionPackage_TC_001_Verify_DecisionPackage_Creation_with_APD_as_SubmisionType() {
		// Navigating to Decision package screen
		homePage.navigateTo_OpsTeam_DecisionPackage_Screen();
		// Validating the all mandatory fields on the Decision package creation form
		dpp.validateMandatoryFieldsErrorMessages();
		// Creation of Decision package
		dpp.verifyUserCanCreate_DecisionPackage(DecisionPackagePage.SubmissionTypeOption_APD, "APD");
//		dpp.verifyDueDate("Due Date On Emergency");
		// Validation of required fields after decision package creation 
		dpp.verifyMandatoryFields_OnDecisionPackage("E&E-HHS-APD", "APD");
		
//		dpp.selectEmergencyRequestInthe_DecisionPackage();
		
		dpp.scrollToBottomOfthePage();
		waitFor(1);
		dpp.verifyFundingTypeAmountDisplay();
		takeScreenshotFor("Amount Shows in APD type");
		
		dpp.verifyBeginReviewStatus();
		takeScreenshotFor("Begin Review status in APD type");

		dpp.verifyFileUpload("APD");
		dpp.verifyDownloadFile("APD");
//	////	dpp.verifyDueDate("Due Date when No Emergency");
		clearanceChecklistPage.updateClearanceChecklist("APD");
		dpp.addRelatedProject();
		dpp.verifyTemplateGeneration();
		takeScreenshotFor("Template Generation in APD type");
		dpp.verifyGenerateTemplateDisappearIfRequiredFieldMiss();
		dpp.closeOtherWindows();
	}
	
	@Test(groups = { "Regression"})
	public void DecisionPackage_TC_002_Verify_DecisionPackage_Creation_with_RFP_as_SubmisionType() {
	
		waitFor(2);
		dpp.jsClickOn(DecisionPackagePage.decisionPackages, "Decision Packages");
		dpp.jsClickOn(DecisionPackagePage.newDecisionPackage, "newDecisionPackage");
		// Creation of Decision package
		dpp.verifyUserCanCreate_DecisionPackage(DecisionPackagePage.SubmissionTypeOption_RFP, "RFP");
//		dpp.verifyDueDate("Due Date On Emergency");
		// Validation of required fields after decision package creation 
		dpp.verifyMandatoryFields_OnDecisionPackage("E&E-HHS-RFP", "RFP");
		
//		dpp.selectEmergencyRequestInthe_DecisionPackage();
		dpp.verifyBeginReviewStatus();
		takeScreenshotFor("Begin Review status in RFP type");
		dpp.verifyFileUpload("RFP");
		dpp.verifyDownloadFile("RFP");
		clearanceChecklistPage.updateClearanceChecklist("RFP");
		
		dpp.addRelatedProject();

		dpp.verifyTemplateGeneration();
		takeScreenshotFor("Template Generation in RFP type");
		dpp.verifyGenerateTemplateDisappearIfSummaryFieldMiss();
		driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
		driver.close();
		driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(0));
	}
	
	@Test(groups = { "Regression"})
	public void DecisionPackage_TC_003_Verify_DecisionPackage_Creation_with_Contract_as_SubmisionType() {

		waitFor(3);
		dpp.jsClickOn(DecisionPackagePage.decisionPackages, "Decision Packages");
		waitFor(2);
		dpp.jsClickOn(DecisionPackagePage.newDecisionPackage, "newDecisionPackage");
		// Creation of Decision package
		dpp.verifyUserCanCreate_DecisionPackage(DecisionPackagePage.SubmissionTypeOption_Contract, "Contract");
//		dpp.verifyDueDate("Due Date On Emergency");
		// Validation of required fields after decision package creation 
		dpp.verifyMandatoryFieldsOn_Contract_DecisionPackage("E&E-HHS-Contract");
		
//		dpp.selectEmergencyRequestInthe_DecisionPackage();
		
		dpp.scrollByPixels(600);//
		waitFor(1);
		dpp.verifyContractAmountDisplay();
		takeScreenshotFor("Amount Shows in Contract type");
//		dpp.verifyDueDate("Due Date when No Emergency");
		dpp.verifyBeginReviewStatus();
		takeScreenshotFor("Begin Review status in Contract type");
		dpp.verifyFileUpload("Contract");
		dpp.verifyDownloadFile("Contract");
		clearanceChecklistPage.updateClearanceChecklist("Contract");
		
		takeScreenshotFor("Template Generation in Contract type");
		dpp.addRelatedProject();
		dpp.verifyTemplateGeneration();
		dpp.verifyGenerateTemplateDisappearIfRequiredFieldMiss();
	}

	@Test(groups = { "Regression"})
	public void DecisionPackage_TC_004_Verify_Adding_bundle_Packages() throws InterruptedException {

		waitFor(3);
		dpp.verifyAddingBundleChanges();
		waitFor(2);
		
	}
	
}
