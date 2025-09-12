package com.Mesh_TestSuites;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.Base.TestBase;
import com.Pages.ClearenceChecklist;
import com.Pages.DecisionPackagePage;
import com.Pages.HomePage;

public class Decision_Package_Creation extends TestBase{
	
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
		dpp.verifyUserCanCreate_DecisionPackage(DecisionPackagePage.SubmissionTypeOption_APD, "APD", "CMS_FNS");
//		dpp.verifyDueDate("Due Date On Emergency");
		// Validation of required fields after decision package creation
		dpp.verifyMandatoryFields_OnDecisionPackage("E&E-FNS-APD", "APD");

//		dpp.selectEmergencyRequestInthe_DecisionPackage();

		dpp.scrollToBottomOfthePage();
		waitFor(1);
		dpp.verifyFundingTypeAmountDisplay();
		takeScreenshotFor("Amount Shows in APD type");

		dpp.verifyBeginReviewStatus();
		takeScreenshotFor("Begin Review status in APD type");
		
//		dpp.verifyFileUpload("APD");
//		dpp.verifyDownloadFile("APD");
//	////	dpp.verifyDueDate("Due Date when No Emergency");

		dpp.addRelatedProject();
		dpp.verifyTemplateGeneration();
		takeScreenshotFor("Template Generation in APD type");
		dpp.verifyGenerateTemplateDisappearIfRequiredFieldMiss();
		dpp.collectLeadTitle();
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

//		dpp.selectEmergencyRequestInthe_DecisionPackage();
		dpp.verifyBeginReviewStatus();
		takeScreenshotFor("Begin Review status in RFP type");
//		dpp.verifyFileUpload("RFP");
//		dpp.verifyDownloadFile("RFP");
		clearanceChecklistPage.updateClearanceChecklist("RFP", "");
		dpp.closeOtherWindows();
		dpp.addRelatedProject();

		dpp.verifyTemplateGeneration();
		takeScreenshotFor("Template Generation in RFP type");
		dpp.verifyGenerateTemplateDisappearIfSummaryFieldMiss();
		System.out.println("================================ Test Case Two Completed ===========================");
	}
	
	@Test(groups = { "Regression" })
	public void DecisionPackage_TC_003_Verify_DecisionPackage_Creation_with_Contract_as_SubmisionType() {
		waitFor(3);
		dpp.jsClickOn(DecisionPackagePage.decisionPackages, "Decision Packages");
		waitFor(2);
		dpp.jsClickOn(DecisionPackagePage.newDecisionPackage, "newDecisionPackage");
		// Creation of Decision package
		dpp.verifyUserCanCreate_DecisionPackage(DecisionPackagePage.SubmissionTypeOption_Contract, "Contract", "CMSFNS");
//		dpp.verifyDueDate("Due Date On Emergency");
		// Validation of required fields after decision package creation
		dpp.verifyMandatoryFieldsOn_Contract_DecisionPackage("E&E-FNS-Contract");

//		dpp.selectEmergencyRequestInthe_DecisionPackage();

		dpp.scrollByPixels(600);//
		waitFor(1);
		dpp.verifyContractAmountDisplay();
		takeScreenshotFor("Amount Shows in Contract type");
//		dpp.verifyDueDate("Due Date when No Emergency");
		dpp.verifyBeginReviewStatus();
		takeScreenshotFor("Begin Review status in Contract type");
//		dpp.verifyFileUpload("Contract");
//		dpp.verifyDownloadFile("Contract");
		clearanceChecklistPage.updateClearanceChecklist("Contract", "");
		takeScreenshotFor("Template Generation in Contract type");
		dpp.addRelatedProject();
		dpp.verifyTemplateGeneration();
		dpp.verifyGenerateTemplateDisappearIfSummaryFieldMiss();
		System.out.println("================================ Test Case Three Completed ===========================");
	}

}
