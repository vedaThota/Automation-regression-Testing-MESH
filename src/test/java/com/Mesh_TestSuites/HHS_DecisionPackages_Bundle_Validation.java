package com.Mesh_TestSuites;

import org.testng.annotations.Test;

import com.Base.TestBase;
import com.Pages.ClearenceChecklist;
import com.Pages.DecisionPackagePage;
import com.Pages.HomePage;

public class HHS_DecisionPackages_Bundle_Validation extends TestBase {
	HomePage homePage = new HomePage();
	DecisionPackagePage dpp = new DecisionPackagePage();
	ClearenceChecklist clearanceChecklistPage = new ClearenceChecklist();

	@Test(groups = { "Regression" })
	public void DecisionPackage_TC_001_Verify_DecisionPackage_Creation_with_APD_as_SubmisionType() {
		// Navigating to Decision package screen
		homePage.navigateTo_OpsTeam_DecisionPackage_Screen("Vedha");
		// Validating the all mandatory fields on the Decision package creation form
		dpp.validateMandatoryFieldsErrorMessages();
		// Creation of Decision package
		dpp.verifyUserCanCreate_DecisionPackage(DecisionPackagePage.SubmissionTypeOption_APD, "APD", "HHS");
//		dpp.verifyDueDate("Due Date On Emergency");
		// Validation of required fields after decision package creation
		dpp.verifyMandatoryFields_OnDecisionPackage("E&E-HHS-APD", "APD");
		dpp.collectLeadTitle();
//
////		dpp.selectEmergencyRequestInthe_DecisionPackage();
//
		dpp.scrollToBottomOfthePage();
		waitFor(1);
		dpp.verifyFundingTypeAmountDisplay();
		takeScreenshotFor("Amount Shows in APD type");

		dpp.verifyBeginReviewStatus();
		takeScreenshotFor("Begin Review status in APD type");
		
////		dpp.verifyFileUpload("APD");
////		dpp.verifyDownloadFile("APD");
////	////	dpp.verifyDueDate("Due Date when No Emergency");
//
//		dpp.addRelatedProject();
//		dpp.verifyTemplateGeneration();
//		takeScreenshotFor("Template Generation in APD type");
//		dpp.verifyGenerateTemplateDisappearIfRequiredFieldMiss();
		
		System.out.println("========================  First Test case completed  =================================");
	}

	@Test(groups = { "Regression" })
	public void DecisionPackage_TC_002_Verify_DecisionPackage_Creation_with_RFP_as_SubmisionType() {

		waitFor(2);
		dpp.jsClickOn(DecisionPackagePage.decisionPackages, "Decision Packages");
		dpp.jsClickOn(DecisionPackagePage.newDecisionPackage, "newDecisionPackage");
		// Creation of Decision package
		dpp.verifyUserCanCreate_DecisionPackage(DecisionPackagePage.SubmissionTypeOption_RFP, "RFP", "HHS");
//		dpp.verifyDueDate("Due Date On Emergency");
		// Validation of required fields after decision package creation
		dpp.verifyMandatoryFields_OnDecisionPackage("E&E-HHS-RFP", "RFP");
//
////		dpp.selectEmergencyRequestInthe_DecisionPackage();
		dpp.verifyBeginReviewStatus();
		takeScreenshotFor("Begin Review status in RFP type");
////		dpp.verifyFileUpload("RFP");
////		dpp.verifyDownloadFile("RFP");
//		clearanceChecklistPage.updateClearanceChecklist("RFP");
//		dpp.closeOtherWindows();
//		dpp.addRelatedProject();
//
//		dpp.verifyTemplateGeneration();
//		takeScreenshotFor("Template Generation in RFP type");
//		dpp.verifyGenerateTemplateDisappearIfSummaryFieldMiss();
		System.out.println("================================ Test Case Two Completed ===========================");
	}

	@Test(groups = { "Regression" })
	public void DecisionPackage_TC_003_Verify_DecisionPackage_Creation_with_Contract_as_SubmisionType() {

		waitFor(3);
		dpp.jsClickOn(DecisionPackagePage.decisionPackages, "Decision Packages");
		waitFor(2);
		dpp.jsClickOn(DecisionPackagePage.newDecisionPackage, "newDecisionPackage");
		// Creation of Decision package
		dpp.verifyUserCanCreate_DecisionPackage(DecisionPackagePage.SubmissionTypeOption_Contract, "Contract", "HHS");
//		dpp.verifyDueDate("Due Date On Emergency");
		// Validation of required fields after decision package creation
		dpp.verifyMandatoryFieldsOn_Contract_DecisionPackage("E&E-HHS-Contract");
//
////		dpp.selectEmergencyRequestInthe_DecisionPackage();
//
//		dpp.scrollByPixels(600);//
//		waitFor(1);
//		dpp.verifyContractAmountDisplay();
//		takeScreenshotFor("Amount Shows in Contract type");
////		dpp.verifyDueDate("Due Date when No Emergency");
		dpp.verifyBeginReviewStatus();
		takeScreenshotFor("Begin Review status in Contract type");
////		dpp.verifyFileUpload("Contract");
////		dpp.verifyDownloadFile("Contract");
//		clearanceChecklistPage.updateClearanceChecklist("Contract");
//		takeScreenshotFor("Template Generation in Contract type");
//		dpp.addRelatedProject();
//		dpp.verifyTemplateGeneration();
//		dpp.verifyGenerateTemplateDisappearIfSummaryFieldMiss();
		System.out.println("================================ Test Case Three Completed ===========================");
	}

	@Test(groups = { "Regression" })
	public void DecisionPackage_TC_004_Verify_Adding_bundle_Packages() throws InterruptedException {

		waitFor(3);
		dpp.verifyAddingBundleChanges("HHS");
		waitFor(2);
		dpp.verifyMoveToDeputyDirector_BeforeAll_Fields_Submit("HHS");
		clearanceChecklistPage.updateClearanceChecklist("APD", "HHS");
		clearanceChecklistPage.moveToMainPage();
		dpp.addRelatedProject();
		dpp.verifyTemplateGeneration();
		takeScreenshotFor("Template Generation in APD type");
		clearanceChecklistPage.moveToFistChildPackage();
		clearanceChecklistPage.updateClearanceChecklist("RFP", "HHS");
		dpp.addRelatedProject();
		waitFor(2);
		clearanceChecklistPage.moveToLeadPackage();
		waitFor(2);
		clearanceChecklistPage.moveToSecondChildPackage();
		clearanceChecklistPage.updateClearanceChecklist("Contract", "HHS");
		waitFor(2);
		dpp.addRelatedProject();
		clearanceChecklistPage.moveToLeadPackage();
		dpp.verifyMoveToDeputyDirector_Stage();
	}

}
