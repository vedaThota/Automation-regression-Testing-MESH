package com.Mesh_TestSuites;

import org.testng.annotations.Test;

import com.Base.TestBase;
import com.Pages.DecisionPackagePage;
import com.Pages.HomePage;

public class DecisionPackages extends TestBase {
	HomePage homePage = new HomePage();
	DecisionPackagePage dpp = new DecisionPackagePage();

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
		dpp.selectEmergencyRequestInthe_DecisionPackage();
//		dpp.verifyDueDate("Due Date when No Emergency");//
	}
	
	@Test(groups = { "Regression"})
	public void DecisionPackage_TC_002_Verify_DecisionPackage_Creation_with_RFP_as_SubmisionType() {
		dpp.jsClickOn(DecisionPackagePage.decisionPackages, "Decision Packages");
		dpp.jsClickOn(DecisionPackagePage.newDecisionPackage, "newDecisionPackage");
		// Creation of Decision package
		dpp.verifyUserCanCreate_DecisionPackage(DecisionPackagePage.SubmissionTypeOption_RFP, "RFP");
//		dpp.verifyDueDate("Due Date On Emergency");
		// Validation of required fields after decision package creation 
		dpp.verifyMandatoryFields_OnDecisionPackage("E&E-HHS-RFP", "RFP");
		dpp.selectEmergencyRequestInthe_DecisionPackage();
//		dpp.verifyDueDate("Due Date when No Emergency");
	}
	
	@Test(groups = { "Regression"})
	public void DecisionPackage_TC_003_Verify_DecisionPackage_Creation_with_Contract_as_SubmisionType() {
		dpp.jsClickOn(DecisionPackagePage.decisionPackages, "Decision Packages");
		dpp.jsClickOn(DecisionPackagePage.newDecisionPackage, "newDecisionPackage");
		// Creation of Decision package
		dpp.verifyUserCanCreate_DecisionPackage(DecisionPackagePage.SubmissionTypeOption_Contract, "Contract");
//		dpp.verifyDueDate("Due Date On Emergency");
		// Validation of required fields after decision package creation 
		dpp.verifyMandatoryFieldsOn_Contract_DecisionPackage("E&E-HHS-Contract");
		dpp.selectEmergencyRequestInthe_DecisionPackage();
//		dpp.verifyDueDate("Due Date when No Emergency");
	}
}
